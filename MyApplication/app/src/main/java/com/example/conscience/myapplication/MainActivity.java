package com.example.conscience.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    /*final Button about = (Button)findViewById(R.id.aboutButon);
    final Button cont = (Button)findViewById(R.id.contactsButton);
    final Button where = (Button)findViewById(R.id.whereButton);
    final Button how = (Button)findViewById(R.id.howButton);
    final Button range = (Button)findViewById(R.id.rateButton);
    final Button web = (Button)findViewById(R.id.webButton);
    final Button appabout = (Button)findViewById(R.id.appAboutButton);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*about.setOnClickListener(this);
        cont.setOnClickListener(this);
        where.setOnClickListener(this);
        how.setOnClickListener(this);
        range.setOnClickListener(this);
        web.setOnClickListener(this);
        appabout.setOnClickListener(this);*/
    }

    /*@Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.aboutButon:
                Intent about = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(about); break;
            case R.id.contactsButton:
                Intent cont = new Intent(MainActivity.this, ContactsActivity.class);
                startActivity(cont); break;
            case R.id.whereButton:
                Intent where = new Intent(MainActivity.this, WhereActivity.class);
                startActivity(where); break;
            case R.id.howButton:
                Intent how = new Intent(MainActivity.this, How_To_Activity.class);
                startActivity(how); break;
            case R.id.rateButton:
                Intent range = new Intent(MainActivity.this, RangeFormActivity.class);
                startActivity(range); break;
            case R.id.webButton:
                Intent web = new Intent(MainActivity.this, WebActivity.class);
                startActivity(web); break;
            case R.id.appAboutButton:
                Intent appinfo = new Intent(MainActivity.this, AboutAppActivity.class);
                startActivity(appinfo); break;
        }
    }*/

    public void onClickAbout(View view) {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }


    public void onClickCont(View view) {
        Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
        startActivity(intent);
    }

    public void onClickWhere(View view) {
        Intent intent = new Intent(MainActivity.this, WhereActivity.class);
        startActivity(intent);
    }

    public void onClickHow(View view) {
        Intent intent = new Intent(MainActivity.this, How_To_Activity.class);
        startActivity(intent);
    }

    public void onClickRating(View view) {
        Intent intent = new Intent(MainActivity.this, RangeFormActivity.class);
        startActivity(intent);
    }

    public void onClickWeb(View view) {
        Intent intent = new Intent(MainActivity.this, WebActivity.class);
        startActivity(intent);
    }

    public void onClickApp(View view) {
        Intent intent = new Intent(MainActivity.this, AboutAppActivity.class);
        startActivity(intent);
    }
}
