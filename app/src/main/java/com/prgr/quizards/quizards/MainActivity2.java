package com.prgr.quizards.quizards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.jaseunda.scodetools.SCodeDesign;
import com.jaseunda.scodetools.SCodeUtil;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {
    /*
    Logic
         */
    private TextInputEditText title;
    private TextInputEditText desc;
    private TextInputEditText amt;
    private SharedPreferences jshared;

    public MainActivity2() {
    }

    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);
    AppCompatButton btn = findViewById(R.id.button2);
    ConstraintLayout home = findViewById(R.id.home);
    btn.setOnClickListener(v -> logic());
    home.setEnabled(true);
    SCodeDesign.ExportDesign(home, true);
    initializelogic();
    /*
    Calls for TDA Screen
    */
        ConstraintLayout newquiz = findViewById(R.id.newquiz);
        AppCompatButton btn3 = findViewById(R.id.button);
        AppCompatButton btn2 = findViewById(R.id.button3);
        btn2.setOnClickListener(v -> back());
        btn3.setOnClickListener(v -> gotom3());
        newquiz.setEnabled(false);
        SCodeDesign.ExportDesign(newquiz, false);
   }
    private void logic(){
        ConstraintLayout newquiz = findViewById(R.id.newquiz);
        ConstraintLayout home = findViewById(R.id.home);
        if(newquiz.isEnabled()){
            SCodeDesign.ExportDesign(newquiz, false);
            SCodeDesign.ExportDesign(home, true);
        }else{
            SCodeDesign.ExportDesign(newquiz, true);
            SCodeDesign.ExportDesign(home, false);
        }
    }
    private void back(){
        ConstraintLayout home = findViewById(R.id.home);
        ConstraintLayout newquiz = findViewById(R.id.newquiz);
        if(home.isEnabled()){
            SCodeDesign.ExportDesign(newquiz, true);
            SCodeDesign.ExportDesign(home, false);
        }else{
            SCodeDesign.ExportDesign(newquiz, false);
            SCodeDesign.ExportDesign(home, true);
        }
    }
    private void initializelogic(){
        title = findViewById(R.id.quizname);
        desc = findViewById(R.id.desc);
        amt = findViewById(R.id.amount);
        jshared = getSharedPreferences("QData", Activity.MODE_PRIVATE);
    }
    private void gotom3(){
            jshared.edit().putString("quizname", title.getText().toString()).apply();
            jshared.edit().putString("desc", desc.getText().toString()).apply();
            jshared.edit().putString("amount", amt.getText().toString()).apply();
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}