package com.example.getfit.ToDo_List;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.getfit.R;

public class BMI extends AppCompatActivity {

    EditText SignUpHeight,SignUpWeight,SignUpAge;
    TextView BMIResult , txtResultHbmi;
    Button button;

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
        txtResultHbmi = findViewById(R.id.txtResultHbmi);
        button = findViewById(R.id.button);


        Intent intent = getIntent();

        H = intent.getStringExtra("height");
        W = intent.getStringExtra("weight");
        A = intent.getStringExtra("age");

        SignUpHeight.setText(H);
        SignUpWeight.setText(W);
        SignUpAge.setText(A);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finalheight = Float.valueOf(H);
                finalweight = Float.valueOf(W);

                float healthybmi = calculate(finalheight, finalweight);

                BMIResult.setText("BMI =" + healthybmi);
                showhealthyBMI(healthybmi);

            }
        });


    }

    public float calculate(float finalheight, float finalweight) {
        return finalweight / ((finalheight / 100) * (finalheight / 100));
    }

    public void showhealthyBMI(float healthybmi) {
        if ((healthybmi == 18.49) || (healthybmi < 18.49)) {
            txtResultHbmi.setText("Under Weight");
        } else if (((healthybmi == 18.5) || (healthybmi > 18.5)) && ((healthybmi == 24.99) || (healthybmi < 24.99))) {
            txtResultHbmi.setText("Normal Weight");
        } else if (((healthybmi == 25) || (healthybmi > 25)) && ((healthybmi == 29.99) || (healthybmi < 29.99))) {
            txtResultHbmi.setText("OVER WEIGHT");
        } else {
            txtResultHbmi.setText("OBESE");
        }
    }
}