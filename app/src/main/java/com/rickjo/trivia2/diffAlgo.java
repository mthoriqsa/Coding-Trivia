package com.rickjo.trivia2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class diffAlgo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diff_algo);
    }

    public void startEasy(View view){
        QuestionDatabase mQLib = new QuestionDatabase(getApplicationContext());
        mQLib.getJSON();
    }

    public void startNormal(View view){
        QuestionDatabase2 mQLib = new QuestionDatabase2(getApplicationContext());
        mQLib.getJSON();
    }

    public void startHard(View view){
        QuestionDatabase3 mQLib = new QuestionDatabase3(getApplicationContext());
        mQLib.getJSON();
    }
}
