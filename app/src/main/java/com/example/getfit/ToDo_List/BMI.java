package com.example.getfit.ToDo_List;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.getfit.R;

public class BMI extends AppCompatActivity {

    EditText SignUpHeight,SignUpWeight,SignUpAge;
    TextView BMIResult;

    String H,W,A;

    float finalheight, finalweight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);

        SignUpHeight = findViewById(R.id.SignUpHeight);
        SignUpWeight = findViewById(R.id.SignUpWeight);
        SignUpAge = findViewById(R.id.SignUpAge);
        BMIResult = findViewById(R.id.BMIResult);

        Intent intent = getIntent();

        H = intent.getStringExtra("height");
        W = intent.getStringExtra("weight");
        A = intent.getStringExtra("age");

        SignUpHeight.setText(H);
        SignUpWeight.setText(W);
        SignUpAge.setText(A);

        finalheight = Float.valueOf(H);
        finalweight = Float.valueOf(W);
    }

    public void sub(View view){
        float bmi = (float)(finalweight / ((finalheight/100) * ( finalheight /100)));
        String calculate = Float.toString(bmi);
        BMIResult.setText(calculate);
    }
}