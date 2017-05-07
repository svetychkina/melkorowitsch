package com.example.conscience.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

//import static com.example.conscience.myapplication.R.id.specSpinner;
//import static com.example.conscience.myapplication.R.id.progSpinner;

public class RangeFormActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    /*String[] specbach = getResources().getStringArray(R.array.bachelor);
    String[] specmag = getResources().getStringArray(R.array.magistracy);
    String[] specpostgrad = getResources().getStringArray(R.array.postgraduate);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_form);

        final Spinner progSpinner = (Spinner)findViewById(R.id.progSpinner);
        final Spinner specSpinner = (Spinner)findViewById(R.id.specSpinner);

        //MyCustomAdapter adapter = new MyCustomAdapter(RangeFormActivity.this,R.layout.row, specbach);


        Switch notifSwitch = (Switch)findViewById(R.id.notificationSwitch);
        if (notifSwitch != null){
            notifSwitch.setOnCheckedChangeListener(this);
        }



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
                    specAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

<<<<<<< HEAD
                    //ArrayAdapter<String> specAdapter = new ArrayAdapter<String>(RangeFormActivity.this,R.layout.row,R.id.selspec,specbach);
=======
                    //ArrayAdapter<String> specAdapter = new ArrayAdapter<String>(this, R.layout.row, R.id.selspec, specbach);
>>>>>>> master

                    specSpinner.setAdapter(specAdapter);

                    specSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        public void onItemSelected(AdapterView<?> parent, View itemSel, int selPos, long posId){
                            String[] selected = getResources().getStringArray(R.array.bachelor);
<<<<<<< HEAD

=======
>>>>>>> master
                            Toast toast = Toast.makeText(getApplicationContext(), "Вы выбрали "+selected[selPos], Toast.LENGTH_SHORT);
                            toast.show();
                        }

                        public void onNothingSelected(AdapterView<?> parent){}
                    });
                    specAdapter.notifyDataSetChanged();

                }
                else if (pos == 1){
                    ArrayAdapter<CharSequence> specAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.magistracy, android.R.layout.simple_spinner_item);
                    specAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    specSpinner.setAdapter(specAdapter);

                    specSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        public void onItemSelected(AdapterView<?> parent, View itemSel, int selPos, long posId){
                            String[] selected = getResources().getStringArray(R.array.magistracy);
                            Toast toast = Toast.makeText(getApplicationContext(), "Вы выбрали "+selected[selPos], Toast.LENGTH_SHORT);
                            toast.show();
                        }

                        public void onNothingSelected(AdapterView<?> parent){}
                    });
                    specAdapter.notifyDataSetChanged();


                }
                else if (pos == 2){
                    ArrayAdapter<CharSequence> specAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.postgraduate, android.R.layout.simple_spinner_item);
                    specAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    specSpinner.setAdapter(specAdapter);

                    specSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        public void onItemSelected(AdapterView<?> parent, View itemSel, int selPos, long posId){
                            String[] selected = getResources().getStringArray(R.array.postgraduate);
                            Toast toast = Toast.makeText(getApplicationContext(), "Вы выбрали "+selected[selPos], Toast.LENGTH_SHORT);
                            toast.show();
                        }

                        public void onNothingSelected(AdapterView<?> parent){}
                    });
                    specAdapter.notifyDataSetChanged();


                }

                                //Spinner spinner = (Spinner)findViewById(R.id.specSpinner);
                //String selected = spinner.getSelectedItem().toString();
                //Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();

            }



            public void onNothingSelected(AdapterView<?> parent){}
            });

        /*specSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View itemSel, int selPos, long posId){
                String[] selected = getResources().getStringArray(R.array.bachelor);
                Toast toast = Toast.makeText(getApplicationContext(), "choise is "+selected[selPos], Toast.LENGTH_SHORT);
                toast.show();
            }

            public void onNothingSelected(AdapterView<?> parent){}
        });*/


            }



        //String specSelected = specSpinner.getSelectedItem().toString();
        //outSpecTextView.setText(specSelected);



    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(this, "Уведомления " + (isChecked ? "включены" : "отключены"), Toast.LENGTH_SHORT).show();
    }
}
