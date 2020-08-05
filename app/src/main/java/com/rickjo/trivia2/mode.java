package com.rickjo.trivia2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class mode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);
    }

    public void startMode1(View view){
        startActivity(new Intent(getApplicationContext(), diffAlgo.class));

        //loading = ProgressDialog.show(mode.this,"Loading", "Please Wait");
        //QuestionDatabase mQLib = new QuestionDatabase(getApplicationContext());
        //mQLib.getJSON();
    }

    public void startMode2 (View view){

        startActivity(new Intent(getApplicationContext(), diffCPP.class));
        //QuestionDatabase2 mQLib = new QuestionDatabase2(getApplicationContext());
        //mQLib.getJSON();
    }

    public void startMode3 (View view){

        startActivity(new Intent(getApplicationContext(), diffWeb.class));
        //QuestionDatabase3 mQLib = new QuestionDatabase3(getApplicationContext());
        //mQLib.getJSON();
    }

    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), start.class));
    }
}
