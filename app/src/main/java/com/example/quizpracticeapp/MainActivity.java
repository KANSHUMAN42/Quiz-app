package com.example.quizpracticeapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button btntrue,btnfalse;
    int index=0;
    int mscore=0;
    TextView tvscore;
    ProgressBar mprogressbar;

private Quesans[] mquesbank=new Quesans[]{
        new Quesans("Delhi is in India",true),
        new Quesans("Delhi is capital of India",true),
        new Quesans("java is a programming language",true),
        new Quesans("Mumbai is in India",true),
        new Quesans("Mumbai is capital of India",false),
        new Quesans("c++ is a programming language",true),
        new Quesans("Patna is in India",true),
        new Quesans("patna is capital of India",false),
        new Quesans("python is a  programming language",true)
};
final int progressbarcount=(int)Math.ceil(100.0/mquesbank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.tvques);
        mprogressbar=findViewById(R.id.progressBar);
        btntrue=(Button)findViewById(R.id.btntrue);
        tv.setText(mquesbank[0].getQues());
        tvscore=(TextView)findViewById(R.id.tvscore);
        btntrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getApplicationContext(),"true passed", Toast.LENGTH_SHORT);
              String nextques=updateques();
              if(nextques!="done") {
                  checkans(true);               //to make Toast
                      tv.setText(nextques);
                      setscore();
              }
              else{
                  Intent i=new Intent(getApplicationContext(),Scorepage.class);
                  startActivity(i);
              }


            }
        });
        btnfalse=(Button)findViewById(R.id.btnfalse);
        btnfalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Falsed passed", Toast.LENGTH_SHORT);
                String nextques=updateques();
                if(nextques!="done") {
                    //to make toast
                    checkans(false);
                    tv.setText(nextques);
                    setscore();
                }
                else{
                    Intent i=new Intent(getApplicationContext(),Scorepage.class);
                    startActivity(i);
                }
            }
        });


    }
    private String updateques(){
        if(index< mquesbank.length-1){
            ++index;
            mprogressbar.incrementProgressBy(progressbarcount);
            mprogressbar.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
        String mques=mquesbank[index].getQues();
        return mques;
            }
        else{
            return "done";
        }
    }
    private void checkans(boolean flag){  //to check ans and give feed back
        boolean rightans=mquesbank[index].isAns();
        if(flag==rightans){
         mscore++;
            Toast.makeText(getApplicationContext(),"You Got it ",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Wrong ans ",Toast.LENGTH_SHORT).show();
        }
    }
    private void setscore(){
        tvscore.setText(mscore+" / "+mquesbank.length);


    }
}