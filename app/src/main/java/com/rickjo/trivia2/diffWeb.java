package com.rickjo.trivia2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class diffWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diff_web);
    }

    public void startEasy(View view){
        QuestionDatabasePHPEZ mQLib = new QuestionDatabasePHPEZ(getApplicationContext());
        mQLib.getJSON();
    }

    public void startNormal(View view){
        QuestionDatabasePHPIN mQLib = new QuestionDatabasePHPIN(getApplicationContext());
        mQLib.getJSON();
    }

    public void startHard(View view){
        QuestionDatabasePHPEX mQLib = new QuestionDatabasePHPEX(getApplicationContext());
        mQLib.getJSON();
    }
}
