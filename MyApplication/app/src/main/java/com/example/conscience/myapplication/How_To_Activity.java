package com.example.conscience.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class How_To_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howto);
    }

    public void onClickPrep(View view) {
        Intent intent = new Intent(How_To_Activity.this,podgActivity.class);
        startActivity(intent);
    }

    public void onClickRules(View view) {
        Intent intent = new Intent(How_To_Activity.this,rulesActivity.class);
        startActivity(intent);
    }
}
