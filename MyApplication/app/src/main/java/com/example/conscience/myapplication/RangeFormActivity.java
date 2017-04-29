package com.example.conscience.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RangeFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_form);
    }

    public void onClickRate(View view) {
        Intent intent = new Intent(RangeFormActivity.this, RateActivity.class);
        startActivity(intent);
    }
}
