package com.example.conscience.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RangeFormActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    ArrayList<String> bachList = new ArrayList<>(19);
    //final String[] bachList = {"05.03.06 Экология и природопользование", "07.03.01 Архитектура", "07.03.03 Дизайн архитектурной среды", "08.03.01 Строительство", "08.05.01 Строительство уникальных зданий и сооружений", "09.03.02 Информационные системы и технологии", "09.03.03 Прикладная информатика", "13.03.01 Теплоэнергетика и теплотехника", "20.03.01 Техносферная безопасность", "21.03.02 Землеустройство и кадастры", "21.03.03 Геодезия и дистанционное зондирование", "27.03.01 Стандартизация и метрология", "35.03.10 Ландшафтная архитектура", "38.03.01 Экономика", "38.03.02 Менеджмент", "40.03.01 Юриспруденция", "43.03.02 Туризм", "51.03.01 Культурология", "54.03.01 Дизайн"};
    String plan = "";

    public static String LOG_TAG = "my_log";
    private static final int NOTIFY_ID=101;

private class ParseTask extends AsyncTask<Void,Void,String>{

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resJson = "";


        @Override
        protected String doInBackground(Void... params) {

            try{
                URL url = new URL("http://www.nngasu.ru/Abitur/information/data.php?func=getCGList&type=bakalavr");

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();

                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine())!= null){
                    buffer.append(line);
                }

                resJson = buffer.toString();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return resJson;
        }

        @Override
        protected void onPostExecute (String strjson){
            super.onPostExecute(strjson);

            Log.d(LOG_TAG, strjson);

            JSONObject dataJsonObj = null;


            try {
                dataJsonObj = new JSONObject(strjson);
                JSONObject bach = dataJsonObj.getJSONObject("Очная");
                Iterator<String> iterator = bach.keys();
                while (iterator.hasNext()){
                    String keys = iterator.next();
                    bachList.add(keys);
                }
                Log.d(LOG_TAG, bachList.toString());

                //надо думать
                JSONObject spec = bach.getJSONObject("05.03.06 Экология и природопользование").getJSONObject("Экология и природопользование");

                JSONObject regular = spec.getJSONObject("На общих основаниях").getJSONObject("Бюджет").getJSONObject("Нет ограничений");
                plan = regular.getString("plan");

                //вывод количества мест в текствью
                TextView places = (TextView)findViewById(R.id.planTextView);
                places.setText(plan);

                Log.d(LOG_TAG, "plan: " + plan);

                for (int i = 0; i < bachList.size(); i++) {

                    String bachArray = bachList.get(i);
                    Log.d(LOG_TAG, "bacharray: " + bachArray);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    //final String[] abitur = {""}; //жсон с массивом абитур-в

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_form);

        //abitur
        /*AutoCompleteTextView abiturNames = (AutoCompleteTextView)findViewById(R.id.nameAutoCompleteTextView);
        abiturNames.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,abitur));}*/

        final Spinner specSpinner = (Spinner)findViewById(R.id.specSpinner);

    ArrayAdapter<String> specAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, bachList);//json
        specAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        specSpinner.setAdapter(specAdapter);

        specSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View itemSel, int selPos, long posId){

                Toast toast = Toast.makeText(getApplicationContext(), "Вы выбрали "+ bachList.get(selPos), Toast.LENGTH_SHORT);
                toast.show();

                TextView places = (TextView)findViewById(R.id.planTextView);
                places.setText(plan);
            }});}
            public void onNothingSelected(AdapterView<?> parent){};

    TextView places = (TextView)findViewById(R.id.planTextView);
        places.setText(plan);

        new ParseTask().execute();

        Switch notifSwitch = (Switch)findViewById(R.id.notificationSwitch);
        if (notifSwitch != null){
            notifSwitch.setOnCheckedChangeListener(this);
        }

    }

    //с этим связать приход уведомления
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(this, "Уведомления " + (isChecked ? "включены" : "отключены"), Toast.LENGTH_SHORT).show();

    }

    //уведомления. настроить на время, а не по кнопке. 16:00 по мск мб. связать со свичом
    public void onCheckNotifs(View view) {
        Context context = getApplicationContext();

        Intent notIntent = new Intent(this,RangeFormActivity.class);

        PendingIntent contentIntent = PendingIntent.getActivity(context,0,notIntent,PendingIntent.FLAG_CANCEL_CURRENT);

        Resources res = context.getResources();
        Notification.Builder builder = new Notification.Builder(context);

        builder.setContentIntent(contentIntent)
                .setSmallIcon(R.drawable.smallnotif)
                .setLargeIcon(BitmapFactory.decodeResource(res,R.mipmap.ic_launcher))
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle(res.getString(R.string.warning))
                .setContentText(res.getString(R.string.check))
                .setDefaults(Notification.DEFAULT_ALL);

        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFY_ID,notification);
    }


    //добавить к эдиттекст
}