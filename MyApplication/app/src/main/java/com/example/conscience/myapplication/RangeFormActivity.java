package com.example.conscience.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

//import static com.example.conscience.myapplication.R.id.specSpinner;
//import static com.example.conscience.myapplication.R.id.progSpinner;

public class RangeFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_form);

        final Spinner progSpinner = (Spinner)findViewById(R.id.progSpinner);
        final Spinner specSpinner = (Spinner)findViewById(R.id.specSpinner);


        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.programs, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        progSpinner.setAdapter(adapter);

        progSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View itemSelected, int pos, long id){
                //String[] choose = getResources().getStringArray(R.array.programs);
                //Toast toast = Toast.makeText(getApplicationContext(),"your choise is " + choose[pos], Toast.LENGTH_SHORT);
                //toast.show();

                parent.getItemAtPosition(pos);
                if (pos == 0){
                    ArrayAdapter<CharSequence> specAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.bachelor, android.R.layout.simple_spinner_item);
                    specSpinner.setAdapter(specAdapter);
                }
                else if (pos == 1){
                    ArrayAdapter<CharSequence> specAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.magistracy, android.R.layout.simple_spinner_item);
                    specSpinner.setAdapter(specAdapter);
                }
                else if (pos == 2){
                    ArrayAdapter<CharSequence> specAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.postgraduate, android.R.layout.simple_spinner_item);
                    specSpinner.setAdapter(specAdapter);
                }

            }

            public void onNothingSelected(AdapterView<?> parent){}
            });

        //String specSelected = specSpinner.getSelectedItem().toString();
        //outSpecTextView.setText(specSelected);
        }


}
