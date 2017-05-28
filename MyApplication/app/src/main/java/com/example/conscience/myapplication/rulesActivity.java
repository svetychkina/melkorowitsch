package com.example.conscience.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class rulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

    }

    public void onClickEntries(View view) {
        Intent intent = new Intent(rulesActivity.this,entriesActivity.class);
        startActivity(intent);
    }

    public void onClickEgeMin(View view) {
        Intent intent = new Intent(rulesActivity.this,EGEMinActivity.class);
        startActivity(intent);
    }

    public void onClickDocs(View view) {
        Intent intent = new Intent(rulesActivity.this,docsActivity.class);
        startActivity(intent);
    }
}
