package com.example.conscience.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.conscience.myapplication.R.id.specSpinner;
import static com.example.conscience.myapplication.R.id.progSpinner;

public class RangeFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_form);

        Spinner progSpinner = (Spinner) findViewById(R.id.progSpinner);
        progSpinner.setOnItemSelectedListener(this);

        Spinner specSpinner = (Spinner) findViewById(R.id.specSpinner);

    }

    public void onClickRate(View view) {
        Intent intent = new Intent(RangeFormActivity.this, RateActivity.class);
        startActivity(intent);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        parent.getItemAtPosition(pos);
        if (pos == 1){
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bachelor, android.R.layout.simple_spinner_item);
            specSpinner.setAdapter(adapter);
        }
        else if (pos == 2){
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.magistracy, android.R.layout.simple_spinner_item);
            specSpinner.setAdapter(adapter);
        }
        else if (pos == 3){
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.postgraduate, android.R.layout.simple_spinner_item);
            specSpinner.setAdapter(adapter);
        }
        else if (pos == 4){
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.extramural, android.R.layout.simple_spinner_item);
            specSpinner.setAdapter(adapter);
        }
        else if (pos == 5){
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.foreign, android.R.layout.simple_spinner_item);
            specSpinner.setAdapter(adapter);
        }
        else if (pos == 6){
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.training, android.R.layout.simple_spinner_item);
            specSpinner.setAdapter(adapter);
        }
    }
}
