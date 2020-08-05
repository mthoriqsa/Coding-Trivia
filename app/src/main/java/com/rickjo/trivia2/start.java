package com.rickjo.trivia2;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class start extends AppCompatActivity {

    MediaPlayer backgroundFX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        backgroundFX = MediaPlayer.create(this, R.raw.applause);
        if(!backgroundFX.isPlaying()){
            backgroundFX.start();
        }
    }

    public void startGame(View view){
        startActivity(new Intent(getApplicationContext(), mode.class));
    }

    public void hiScore(View view){
        startActivity(new Intent(getApplicationContext(), hiscore.class));
    }

    public void creatorCredits(View view){
        startActivity(new Intent(getApplicationContext(), credits.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(backgroundFX==null)
            backgroundFX = MediaPlayer.create(this, R.raw.applause);

        if(!backgroundFX.isPlaying())
            backgroundFX.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        backgroundFX.pause();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(start.this);
        alertDialogBuilder
                .setMessage("Keluar dari Aplikasi ?")
                .setCancelable(true)
                .setPositiveButton("Ya",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finishAffinity();
                            }
                        })
                .setNegativeButton("Tidak",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
