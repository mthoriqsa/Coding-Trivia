package com.rickjo.trivia2;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuestionDatabasePHPEX {
    Context mContext;
    private String JSON_STRING;
    public QuestionDatabasePHPEX(Context C){
        mContext = C;
    }
    private void getQuestion(){

        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            List<String> myQuestion = new ArrayList<String>();
            List<String> myChoice1 = new ArrayList<String>();
            List<String> myChoice2 = new ArrayList<String>();
            List<String> myChoice3 = new ArrayList<String>();
            List<String> myChoice4 = new ArrayList<String>();
            List<String> myAnswer = new ArrayList<String>();
            for (int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(konfigurasi.KEY_ID);

                String soal = jo.getString(konfigurasi.KEY_Q);
                myQuestion.add(soal);

                String pil1 = jo.getString(konfigurasi.KEY_C1);
                myChoice1.add(pil1);

                String pil2 = jo.getString(konfigurasi.KEY_C2);
                myChoice2.add(pil2);

                String pil3 = jo.getString(konfigurasi.KEY_C3);
                myChoice3.add(pil3);

                String pil4 = jo.getString(konfigurasi.KEY_C4);
                myChoice4.add(pil4);

                String jawaban = jo.getString(konfigurasi.KEY_A);
                myAnswer.add(jawaban);

            }

            String[] tmp = new String[myQuestion.size()];
            myQuestion.toArray(tmp);
            showQuestion = tmp;

            String[] tmp1 = new String[myChoice1.size()];
            myChoice1.toArray(tmp1);
            showChoice1 = tmp1;

            String[] tmp2 = new String[myChoice2.size()];
            myChoice2.toArray(tmp2);
            showChoice2 = tmp2;

            String[] tmp3 = new String[myChoice3.size()];
            myChoice3.toArray(tmp3);
            showChoice3 = tmp3;

            String[] tmp4 = new String[myChoice4.size()];
            myChoice4.toArray(tmp4);
            showChoice4 = tmp4;

            String[] tmp5 = new String[myAnswer.size()];
            myAnswer.toArray(tmp5);
            showAnswer = tmp5;

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getJSON(){
        class GetJSON extends AsyncTask<Void, Void, String> {


            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                //loading = ProgressDialog.show(ApplicationContextProvider.getContext() ,"Mengambil Data","Mohon Tunggu...",false,false);
                //Toast.makeText(ApplicationContextProvider.getContext(), "Loading........",Toast.LENGTH_LONG).show();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                JSON_STRING = s;
                //loading.dismiss();
                getQuestion();
                mContext.startActivity( new Intent(ApplicationContextProvider.getContext(), quizPHPEX.class));
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_PHPEX);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
        return JSON_STRING;
    }

    //list data in arrays
    private static String showQuestion[] = {

    };

    private static String showChoice1[] = {

    };

    private static String showChoice2[] = {

    };

    private static String showChoice3[] = {

    };

    private static String showChoice4[] = {

    };

    private static String showAnswer[] = {

    };
    //end list data

    //get data from arrays & return to main
    public String getQuestion(int a){
        String question = showQuestion[a];
        return question;
    }

    public String getChoice1(int a){
        String choice1 = showChoice1[a];
        return choice1;
    }

    public String getChoice2(int a){
        String choice2 = showChoice2[a];
        return choice2;
    }

    public String getChoice3(int a){
        String choice3 = showChoice3[a];
        return choice3;
    }

    public String getChoice4(int a){
        String choice4 = showChoice4[a];
        return choice4;
    }

    public String getCorrectAnswer(int a){
        String answer = showAnswer[a];
        return answer;
    }
    //end get data
}
