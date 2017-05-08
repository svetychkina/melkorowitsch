package com.example.conscience.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;


public class RangeFormActivity extends AppCompatActivity
implements CompoundButton.OnCheckedChangeListener {

    private static final int NOTIFY_ID=101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_form);

        Switch notifSwitch = (Switch)findViewById(R.id.notificationSwitch);
        if (notifSwitch != null){
            notifSwitch.setOnCheckedChangeListener(this);
        }

        final Spinner specSpinner = (Spinner)findViewById(R.id.specSpinner);

        String[] specbach = getResources().getStringArray(R.array.bachelor);

        ArrayAdapter<String> specAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,specbach);
        specAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        specSpinner.setAdapter(specAdapter);

        specSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View itemSel, int selPos, long posId){
                String[] selected = getResources().getStringArray(R.array.bachelor);
                Toast toast = Toast.makeText(getApplicationContext(), "Вы выбрали "+selected[selPos], Toast.LENGTH_SHORT);
                toast.show();
            }

            public void onNothingSelected(AdapterView<?> parent){}
        });


    }
@Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(this, "Уведомления " + (isChecked ? "включены" : "отключены"), Toast.LENGTH_SHORT).show();

    }

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
}
