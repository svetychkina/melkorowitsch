package com.example.conscience.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void onClickProfs(View view) {
        Intent intent = new Intent(AboutActivity.this,profsActivity.class);
        startActivity(intent);
    }

    public void onClickAboutUs(View view) {
        Intent intent = new Intent(AboutActivity.this,aboutUsActivity.class);
        startActivity(intent);
    }

    public void onClickStuds(View view) {
        Intent intent = new Intent(AboutActivity.this,studsActivity.class);
        startActivity(intent);
    }
}
