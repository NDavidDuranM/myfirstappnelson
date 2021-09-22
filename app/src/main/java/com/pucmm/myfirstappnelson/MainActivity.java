package com.pucmm.myfirstappnelson;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText firstName;
    EditText lastName;
    Spinner  gender;
    TextView dateTextView;
    Calendar calendar;
    DatePickerDialog date;
    RadioButton doYouLikeProgrammingYes;
    RadioButton doYouLikeProgrammingNo;
    CheckBox language1;
    CheckBox language2;
    CheckBox language3;
    CheckBox language4;
    CheckBox language5;
    CheckBox language6;
    CheckBox language7;
    CheckBox language8;
    Button cleanBtn;
    Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstNameTxt);
        lastName = findViewById(R.id.lastNameTxt);

        gender = findViewById(R.id.genderSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);
        gender.setOnItemSelectedListener(this);

        language1 = findViewById(R.id.option1Checkbox);
        language2 = findViewById(R.id.option2Checkbox);
        language3 = findViewById(R.id.option3Checkbox);
        language4 = findViewById(R.id.option4Checkbox);
        language5 = findViewById(R.id.option5Checkbox);
        language6 = findViewById(R.id.option6Checkbox);
        language7 = findViewById(R.id.option7Checkbox);
        language8 = findViewById(R.id.option8Checkbox);

        doYouLikeProgrammingYes = findViewById(R.id.yesRadio);
        doYouLikeProgrammingYes.setChecked(true);
        doYouLikeProgrammingYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                language1.setEnabled(true);
                language2.setEnabled(true);
                language3.setEnabled(true);
                language4.setEnabled(true);
                language5.setEnabled(true);
                language6.setEnabled(true);
                language7.setEnabled(true);
                language8.setEnabled(true);
            }
        });

        doYouLikeProgrammingNo = findViewById(R.id.noRadio);
        doYouLikeProgrammingNo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View v) {
                language1.setEnabled(false);
                language2.setEnabled(false);
                language3.setEnabled(false);
                language4.setEnabled(false);
                language5.setEnabled(false);
                language6.setEnabled(false);
                language7.setEnabled(false);
                language8.setEnabled(false);
                language1.setChecked(false);
                language2.setChecked(false);
                language3.setChecked(false);
                language4.setChecked(false);
                language5.setChecked(false);
                language6.setChecked(false);
                language7.setChecked(false);
                language8.setChecked(false);
            }
        });

        dateTextView = findViewById(R.id.birthDateView);
        dateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int moth = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                date = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int numYear, int numMonth, int numDay) {
                        dateTextView.setText(numDay + "/" + (numMonth + 1) + "/" + numYear);
                    }
                }, day, moth, year);
                date.show();
            }
        });

        sendBtn = findViewById(R.id.sendButton);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int validator = 0;

                Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);

                if(firstName.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please enter your name.", Toast.LENGTH_LONG)
                            .show();
                } else {
                    intent.putExtra("info1",firstName.getText().toString());
                    validator++;
                }
                if(lastName.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please enter your last name.", Toast.LENGTH_LONG)
                            .show();
                } else {
                    intent.putExtra("info2",lastName.getText().toString());
                    validator++;
                }

                intent.putExtra("info3",gender.getSelectedItem().toString());
                intent.putExtra("info4",dateTextView.getText().toString());
                intent.putExtra("info5",doYouLikeProgrammingYes.isChecked());

                if(doYouLikeProgrammingYes.isChecked()){
                    if(!language1.isChecked() && !language2.isChecked() && !language3.isChecked() && !language4.isChecked() &&
                            !language5.isChecked() && !language6.isChecked() && !language7.isChecked() && !language8.isChecked()){

                        Toast.makeText(getApplicationContext(), "Select at least one language.", Toast.LENGTH_LONG)
                                .show();
                    } else {

                        if(language1.isChecked()){
                            intent.putExtra("info6",language1.getText().toString());
                        } else {
                            intent.putExtra("info6","");
                        }
                        if(language2.isChecked()){
                            intent.putExtra("info7",language2.getText().toString());
                        } else {
                            intent.putExtra("info7","");
                        }
                        if(language3.isChecked()){
                            intent.putExtra("info8",language3.getText().toString());
                        } else {
                            intent.putExtra("info8","");
                        }
                        if(language4.isChecked()){
                            intent.putExtra("info9",language4.getText().toString());
                        } else {
                            intent.putExtra("info9","");
                        }
                        if(language5.isChecked()){
                            intent.putExtra("info10",language5.getText().toString());
                        } else {
                            intent.putExtra("info10","");
                        }
                        if(language6.isChecked()){
                            intent.putExtra("info11",language6.getText().toString());
                        } else {
                            intent.putExtra("info11","");
                        }
                        if(language7.isChecked()){
                            intent.putExtra("info12",language7.getText().toString());
                        } else {
                            intent.putExtra("info12","");
                        }
                        if(language8.isChecked()){
                            intent.putExtra("info13",language8.getText().toString());
                        } else {
                            intent.putExtra("info13","");
                        }
                        validator++;
                    }
                } else {
                    intent.putExtra("info6","");
                    intent.putExtra("info7","");
                    intent.putExtra("info8","");
                    intent.putExtra("info9","");
                    intent.putExtra("info10","");
                    intent.putExtra("info11","");
                    intent.putExtra("info12","");
                    intent.putExtra("info13","");
                    validator++;
                }

                if(validator == 3){
                    startActivity(intent);
                }
            }
        });

        cleanBtn = findViewById(R.id.cleanButton);
        cleanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName.setText("");
                lastName.setText("");
                gender.setSelection(0, true);
                doYouLikeProgrammingYes.setChecked(true);

                if(language1.isChecked()){
                    language1.toggle();
                }
                if(language2.isChecked()){
                    language2.toggle();
                }
                if(language3.isChecked()){
                    language3.toggle();
                }
                if(language4.isChecked()){
                    language4.toggle();
                }
                if(language5.isChecked()){
                    language5.toggle();
                }
                if(language6.isChecked()){
                    language6.toggle();
                }
                if(language7.isChecked()){
                    language7.toggle();
                }
                if(language8.isChecked()){
                    language8.toggle();
                }

                language1.setEnabled(true);
                language2.setEnabled(true);
                language3.setEnabled(true);
                language4.setEnabled(true);
                language5.setEnabled(true);
                language6.setEnabled(true);
                language7.setEnabled(true);
                language8.setEnabled(true);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        //String text = adapterView.getItemAtPosition(position).toString();
        //Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}