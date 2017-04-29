package com.example.conscience.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
    }


    public void OnClickVK(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/nngasu"));
        startActivity(browserIntent);
    }

    public void OnClickFB(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/nngasu1930"));
        startActivity(browserIntent);
    }

    public void OnClickTwi(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/nngasu2016"));
        startActivity(browserIntent);
    }

    public void OnClickYT(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/user/nngasuvideo"));
        startActivity(browserIntent);
    }
}
