package com.example.conscience.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class WhereActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where);
    }

    public void onClickBach(View view) {
        Intent intent = new Intent(WhereActivity.this, BachelorActivity.class);
        startActivity(intent);
    }

    public void onClickMag(View view) {
        Intent intent = new Intent(WhereActivity.this, magistrActivity.class);
        startActivity(intent);
    }

    public void onClickAsp(View view) {
        Intent intent = new Intent(WhereActivity.this, aspActivity.class);
        startActivity(intent);
    }

    public void onClickExtr(View view) {
        Intent intent = new Intent(WhereActivity.this, extramActivity.class);
        startActivity(intent);
    }

}
