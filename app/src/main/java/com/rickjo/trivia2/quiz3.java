package com.rickjo.trivia2;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class quiz3 extends AppCompatActivity {

    private QuestionDatabase3 mQuestionLibrary = new QuestionDatabase3(this);

    private TextView mScoreView;
    private TextView lifePointView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private Vibrator buttonVib;

    private String mAnswer;
    private int mScore = 0;
    private int lifePoint = 3;
    private int mQuestionNumber = 0;
    private int countQuiz = 0;
    static final private int QUIZ_COUNT = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);

        mScoreView = (TextView)findViewById(R.id.score);
        lifePointView = (TextView) findViewById(R.id.lifeText);
        mQuestionView = (TextView)findViewById(R.id.question);

        mButtonChoice1 = (Button) findViewById(R.id.answer1);
        mButtonChoice2 = (Button) findViewById(R.id.answer2);
        mButtonChoice3 = (Button) findViewById(R.id.answer3);
        mButtonChoice4 = (Button) findViewById(R.id.answer4);

        buttonVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        final MediaPlayer buttonSound = MediaPlayer.create(this, R.raw.right_answer2);

        updateQuestion();

        //Start Button 1 Listener
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mButtonChoice1.getText().toString().contentEquals(mAnswer)){
                    mScore++;
                    updateScore(mScore);
                    lifePoint = 3;
                    resetLife(lifePoint);
                    buttonSound.start();
                    updateQuestion();

                    Toast.makeText(quiz3.this, "BENAR!", Toast.LENGTH_SHORT).show();
                }
                else {
                    mScore--;
                    lifePoint--;
                    updateScore(mScore);
                    updateLife(lifePoint);
                    buttonVib.vibrate(50);
                    zeroScore();
                    Toast.makeText(quiz3.this, "SALAH!", Toast.LENGTH_SHORT).show();
                    //gameOver();
                }
            }
        });
        //End Button 1 Listener

        //Start Button 2 Listener
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mButtonChoice2.getText().toString().contentEquals(mAnswer)){
                    mScore++;
                    updateScore(mScore);
                    lifePoint = 3;
                    resetLife(lifePoint);
                    buttonSound.start();
                    updateQuestion();

                    Toast.makeText(quiz3.this, "BENAR!", Toast.LENGTH_SHORT).show();
                }
                else {
                    mScore--;
                    lifePoint--;
                    updateScore(mScore);
                    updateLife(lifePoint);
                    buttonVib.vibrate(50);
                    zeroScore();
                    Toast.makeText(quiz3.this, "SALAH!", Toast.LENGTH_SHORT).show();
                    //gameOver();
                }
            }
        });
        //End Button 2 Listener

        //Start Button 3 Listener
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mButtonChoice3.getText().toString().contentEquals(mAnswer)){
                    mScore++;
                    updateScore(mScore);
                    lifePoint = 3;
                    resetLife(lifePoint);
                    buttonSound.start();
                    updateQuestion();

                    Toast.makeText(quiz3.this, "BENAR!", Toast.LENGTH_SHORT).show();
                }
                else {
                    mScore--;
                    lifePoint--;
                    updateScore(mScore);
                    updateLife(lifePoint);
                    buttonVib.vibrate(50);
                    zeroScore();
                    Toast.makeText(quiz3.this, "SALAH!", Toast.LENGTH_SHORT).show();
                    //gameOver();
                }
            }
        });
        //End Button 3 Listener

        //Start Button 4 Listener
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mButtonChoice4.getText().toString().contentEquals(mAnswer)){
                    mScore++;
                    updateScore(mScore);
                    lifePoint = 3;
                    resetLife(lifePoint);
                    buttonSound.start();
                    updateQuestion();

                    Toast.makeText(quiz3.this, "BENAR!", Toast.LENGTH_SHORT).show();
                }
                else {
                    mScore--;
                    lifePoint--;
                    updateScore(mScore);
                    updateLife(lifePoint);
                    buttonVib.vibrate(50);
                    zeroScore();
                    Toast.makeText(quiz3.this, "SALAH!", Toast.LENGTH_SHORT).show();
                    //gameOver();
                }
            }
        });
        //End Button 4 Listener
    }

    private void updateQuestion(){
        try {
            if (countQuiz == QUIZ_COUNT) {
                Intent intent = new Intent(getApplicationContext(), resultALGOEX.class);
                intent.putExtra("algoexScore", mScore);
                startActivity(intent);
            } else {
                mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
                mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
                mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
                mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
                mButtonChoice4.setText(mQuestionLibrary.getChoice4(mQuestionNumber));

                mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
                mQuestionNumber++;
                countQuiz++;
            }
        }catch (Exception e){
            AlertDialog.Builder errorConn = new AlertDialog.Builder(quiz3.this);
            errorConn
                    .setMessage("Koneksi Bermasalah")
                    .setCancelable(false)
                    .setPositiveButton("Kembali", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(getApplicationContext(), mode.class));
                        }
                    });
            AlertDialog alertDialog = errorConn.create();
            alertDialog.show();
        }
    }

    private void updateScore(int point){
        mScoreView.setText("" + mScore);
    }

    private void resetLife(int life){ lifePointView.setText("" + lifePoint);}

    private void updateLife(int life){ lifePointView.setText("" + lifePoint);}

    private void zeroScore(){
        if (lifePoint < 1) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(quiz3.this);
            alertDialogBuilder
                    .setMessage("Permainan Berakhir")
                    .setCancelable(false)
                    .setPositiveButton("Ulangi",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    startActivity(new Intent(getApplicationContext(), quiz3.class));
                                }
                            })
                    .setNegativeButton("Keluar",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    startActivity(new Intent(getApplicationContext(), start.class));
                                }
                            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            //startActivity(new Intent(getApplicationContext(), result.class));
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(quiz3.this);
        alertDialogBuilder
                .setMessage("Kembali ke Menu ?")
                .setCancelable(true)
                .setPositiveButton("Ya",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), start.class));
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
