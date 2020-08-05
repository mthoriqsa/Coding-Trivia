package com.rickjo.trivia2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class resultPHPIN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_phpin);

        TextView result = (TextView) findViewById(R.id.result);
        TextView hiscore = (TextView) findViewById(R.id.hiscore);

        int score = getIntent().getIntExtra("phpinScore", 0);
        result.setText(score + "");

        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highScore = settings.getInt("PHPIN_SCORE", 0);

        if (score > highScore){
            hiscore.setText("High Score : " + score);

            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("PHPIN_SCORE", score);
            editor.commit();
        }else {
            hiscore.setText("Skor Tertinggi : " + highScore);
        }
    }

    public void returnMenu(View view){
        startActivity(new Intent(getApplicationContext(), start.class));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), start.class));
    }
}
