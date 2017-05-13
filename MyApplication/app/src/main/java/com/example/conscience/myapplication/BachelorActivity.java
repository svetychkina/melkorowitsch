package com.example.conscience.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BachelorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bachelor);
    }

    public void onClickIeup(View view) {
        Intent intent = new Intent(BachelorActivity.this,ieupActivity.class);
        startActivity(intent);
    }

    public void onClickIsf(View view) {
        Intent intent = new Intent(BachelorActivity.this,IsfActivity.class);
        startActivity(intent);
    }

    public void onClickMiepm(View view) {
        Intent intent = new Intent(BachelorActivity.this,miepmActivity.class);
        startActivity(intent);
    }


    public void onClickOtf(View view) {
        Intent intent = new Intent(BachelorActivity.this,otfActivity.class);
        startActivity(intent);
    }

    public void onClickFaid(View view) {
        Intent intent = new Intent(BachelorActivity.this,faidActivity.class);
        startActivity(intent);
    }

    public void onClickFiesis(View view) {
        Intent intent = new Intent(BachelorActivity.this,fiesisActivity.class);
        startActivity(intent);
    }
}
