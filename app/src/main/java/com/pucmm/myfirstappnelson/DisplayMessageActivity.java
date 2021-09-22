package com.pucmm.myfirstappnelson;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DisplayMessageActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();

        String firstName = intent.getStringExtra("info1");
        String lastName = intent.getStringExtra("info2");

        String gender = intent.getStringExtra("info3");
        gender = gender.toLowerCase();

        String birthDate = intent.getStringExtra("info4");
        Boolean doYouLikeProgramming = intent.getBooleanExtra("info5",true);
        String doYouLikeProgrammingMessage = "";

        String language1 = intent.getStringExtra("info6");
        String language2 = intent.getStringExtra("info7");
        String language3 = intent.getStringExtra("info8");
        String language4 = intent.getStringExtra("info9");
        String language5 = intent.getStringExtra("info10");
        String language6 = intent.getStringExtra("info11");
        String language7 = intent.getStringExtra("info12");
        String language8 = intent.getStringExtra("info13");

        ArrayList<String> language = new ArrayList<>();
        language.add(language1);
        language.add(language2);
        language.add(language3);
        language.add(language4);
        language.add(language5);
        language.add(language6);
        language.add(language7);
        language.add(language8);

        if(doYouLikeProgramming.equals(true)){
            doYouLikeProgrammingMessage = "Me gusta programar. Mis lenguajes favoritos son: ";

            for(int i = 0; i < language.size(); i++){
                if( !language.get(i).isEmpty() ){
                    doYouLikeProgrammingMessage = doYouLikeProgrammingMessage.concat(language.get(i)).concat(", ");
                }
            }
            doYouLikeProgrammingMessage = doYouLikeProgrammingMessage.substring(0,doYouLikeProgrammingMessage.length()-2)+".";

        } else if (doYouLikeProgramming.equals(false)) {
            doYouLikeProgrammingMessage = "No me gusta programar.";
        }

        TextView view = findViewById(R.id.yourDataView);
        view.setText("Hola! Mi nombre es " + firstName + " " + lastName + ".\n\n" +
                        "Mi genero es " + gender + ", y naci el " + birthDate + ".\n\n" +
                doYouLikeProgrammingMessage);
    }
}