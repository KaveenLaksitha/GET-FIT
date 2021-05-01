package com.example.getfit.Workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.getfit.R;

import java.util.Locale;

public class Counter extends AppCompatActivity {
    private static long START_TIME_IN_MILLIS;

    TextView mTextViewCountDown;
    Button mButtonStartPause;
    Button mButtonReset;

    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftinMillis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        //getSupportActionBar().setTitle("Counter");

        mTextViewCountDown = findViewById(R.id.counter_tv2);
        mButtonStartPause = findViewById(R.id.StartBtn);
        mButtonReset = findViewById(R.id.StopBtn);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("time");

        long duration = Long.parseLong(msg);
        START_TIME_IN_MILLIS = (duration*60000);
        mTimeLeftinMillis = START_TIME_IN_MILLIS;
        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTimerRunning){
                    pauseTimer();
                }else{
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        updateCountDownText();
    }

    public void startTimer(){
        mCountDownTimer = new CountDownTimer(mTimeLeftinMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftinMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning =false;
                mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
            }
        }.start();

        mTimerRunning = true;
        mButtonStartPause.setText("pause");
        mButtonReset.setVisibility(View.INVISIBLE);
    }

    public void pauseTimer(){
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);
    }

    public void resetTimer(){
        mTimeLeftinMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
    }
    public void updateCountDownText(){
        int minutes = (int) (mTimeLeftinMillis /1000) / 60;
        int seconds = (int) (mTimeLeftinMillis /1000) % 60;


        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }
}