package com.example.getfit.Nutrition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.getfit.R;
import com.example.getfit.Supplement.BMICalculator;

public class MainActivity extends AppCompatActivity {

    Button btnBMICal,btnWeightCon,btnMacroCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBMICal = findViewById(R.id.btnBMICal);
        btnWeightCon = findViewById(R.id.btnWeightCon);
        btnMacroCal = findViewById(R.id.btnMacroCal);

        //redirects to BMI calculator page
        btnBMICal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, BMICalculator.class);
                startActivity(intent);

            }
        });

        //redirects to weight convertor page
        btnWeightCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //redirects to macro finder page
        btnMacroCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,macroCal.class);
                startActivity(intent);

            }
        });
    }
}