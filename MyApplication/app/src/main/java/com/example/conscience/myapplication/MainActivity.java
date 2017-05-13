package com.example.conscience.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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
