package com.example.conscience.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class RangeFormActivity extends AppCompatActivity
implements CompoundButton.OnCheckedChangeListener {

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
            //String name = "";
            String plan = "";

            try {
                dataJsonObj = new JSONObject(strjson);
                JSONObject bach = dataJsonObj.getJSONObject("Очная");
                JSONObject spec = bach.getJSONObject("05.03.06 Экология и природопользование").getJSONObject("Экология и природопользование");

                JSONObject regular = spec.getJSONObject("На общих основаниях").getJSONObject("Бюджет").getJSONObject("Нет ограничений");
                plan = regular.getString("plan");

                Log.d(LOG_TAG, "plan: " + plan);

                /*for (int i = 0; i < friends.length(); i++) {

                    JSONObject friend = friends.getJSONObject(i);

                    JSONObject conts = friend.getJSONObject("contacts");

                    String phone = conts.getString("mobile");
                    String email = conts.getString("email");
                    String skype = conts.getString("skype");

                    Log.d(LOG_TAG, "phone: " + phone);
                    Log.d(LOG_TAG, "email: " + email);
                    Log.d(LOG_TAG, "skype: " + skype);
                }*/

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_form);

        new ParseTask().execute();

        Switch notifSwitch = (Switch)findViewById(R.id.notificationSwitch);
        if (notifSwitch != null){
            notifSwitch.setOnCheckedChangeListener(this);
        }

        final Spinner specSpinner = (Spinner)findViewById(R.id.specSpinner);

        String[] specbach = getResources().getStringArray(R.array.bachelor);//сюда воткнуть массив из жсон

        ArrayAdapter<String> specAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,specbach);
        specAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        specSpinner.setAdapter(specAdapter);

        specSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View itemSel, int selPos, long posId){
                String[] selected = getResources().getStringArray(R.array.bachelor); //сюда тоже воткнуть массив жсон

                Toast toast = Toast.makeText(getApplicationContext(), "Вы выбрали "+selected[selPos], Toast.LENGTH_SHORT);
                toast.show();

                //воткнуть в текствью параметр из объекта в объекте в объекте в объекте каждого объекта в массиве жсон
                //осталось_только_прихуярить_монитор.жпг
            }

            public void onNothingSelected(AdapterView<?> parent){}
        });


    }

    //вот с этим говном связать приход уведомления
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(this, "Уведомления " + (isChecked ? "включены" : "отключены"), Toast.LENGTH_SHORT).show();

    }

    //цэ уведомления. настроить на время, а не по кнопке. 16:00 по мск мб. связать со свичом
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

    //куда-то сюда прихуярить жсон с массивом школоло
    //добавить к эдиттекст
}
