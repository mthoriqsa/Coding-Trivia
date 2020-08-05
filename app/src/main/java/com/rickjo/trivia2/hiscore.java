package com.rickjo.trivia2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class hiscore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiscore);

        TextView algoez = (TextView) findViewById(R.id.algoez);
        TextView algoin = (TextView) findViewById(R.id.algoin);
        TextView algoex = (TextView) findViewById(R.id.algoex);
        TextView cppez = (TextView) findViewById(R.id.cppez);
        TextView cppin = (TextView) findViewById(R.id.cppin);
        TextView cppex = (TextView) findViewById(R.id.cppex);
        TextView phpez = (TextView) findViewById(R.id.phpez);
        TextView phpin = (TextView) findViewById(R.id.phpin);
        TextView phpex = (TextView) findViewById(R.id.phpex);

        SharedPreferences setting = getSharedPreferences("GAME_DATA", MODE_PRIVATE);
        int hi_algoez = setting.getInt("ALGOEZ_SCORE", 0);
        int hi_algoin = setting.getInt("ALGOIN_SCORE", 0);
        int hi_algoex = setting.getInt("ALGOEX_SCORE", 0);
        int hi_cppez = setting.getInt("CPPEZ_SCORE", 0);
        int hi_cppin = setting.getInt("CPPIN_SCORE", 0);
        int hi_cppex = setting.getInt("CPPEX_SCORE", 0);
        int hi_phpez = setting.getInt("PHPEZ_SCORE", 0);
        int hi_phpin = setting.getInt("PHPIN_SCORE", 0);
        int hi_phpex = setting.getInt("PHPEX_SCORE", 0);

        algoez.setText(hi_algoez + "");
        algoin.setText(hi_algoin + "");
        algoex.setText(hi_algoex + "");
        cppez.setText(hi_cppez + "");
        cppin.setText(hi_cppin + "");
        cppex.setText(hi_cppex + "");
        phpez.setText(hi_phpez +"");
        phpin.setText(hi_phpin + "");
        phpex.setText(hi_phpex + "");

    }


    public void deleteAll(){
        SharedPreferences setting = getSharedPreferences("GAME_DATA", MODE_PRIVATE);
        SharedPreferences.Editor editor = setting.edit();
        editor.putInt("ALGOEZ_SCORE", 0);
        editor.putInt("ALGOIN_SCORE", 0);
        editor.putInt("ALGOEX_SCORE", 0);
        editor.putInt("CPPEZ_SCORE", 0);
        editor.putInt("CPPIN_SCORE", 0);
        editor.putInt("CPPEX_SCORE", 0);
        editor.putInt("PHPEZ_SCORE", 0);
        editor.putInt("PHPIN_SCORE", 0);
        editor.putInt("PHPEX_SCORE", 0);
        editor.commit();
    }

    public void deleteScore(View view){
        AlertDialog.Builder hapus = new AlertDialog.Builder(hiscore.this);
        hapus
                .setMessage("Hapus semua skor tertinggi?")
                .setCancelable(true)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteAll();
                        startActivity(new Intent(getApplicationContext(), hiscore.class));
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = hapus.create();
        alertDialog.show();
    }

    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), start.class));
    }
}
