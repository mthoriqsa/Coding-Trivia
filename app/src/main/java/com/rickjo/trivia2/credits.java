package com.rickjo.trivia2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        TextView programmer = (TextView) findViewById(R.id.programmer);
        TextView design = (TextView) findViewById(R.id.design);
        TextView concept = (TextView) findViewById(R.id.concept);
        TextView tq1 = (TextView) findViewById(R.id.tq1);
        TextView tq2 = (TextView) findViewById(R.id.tq2);
        TextView tq3 = (TextView) findViewById(R.id.tq3);

        programmer.setText("Muhammad Thoriq S. A.");
        design.setText("Muhammad Thoriq S. A.");
        concept.setText("Muhammad Thoriq S. A.");
        tq1.setText("Dosen");
        tq2.setText("Teman-teman");
        tq3.setText("Internet");
    }




}
