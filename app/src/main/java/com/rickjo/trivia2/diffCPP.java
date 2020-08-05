package com.rickjo.trivia2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class diffCPP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diff_cpp);
    }

    public void startEasy(View view){
        QuestionDatabaseCPPEZ mQLib = new QuestionDatabaseCPPEZ(getApplicationContext());
        mQLib.getJSON();
    }

    public void startNormal(View view){
        QuestionDatabaseCPPIN mQLib = new QuestionDatabaseCPPIN(getApplicationContext());
        mQLib.getJSON();
    }

    public void startHard(View view){
        QuestionDatabaseCPPEX mQLib = new QuestionDatabaseCPPEX(getApplicationContext());
        mQLib.getJSON();
    }
}
