package com.example.getfit.Nutrition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.getfit.R;
import com.example.getfit.Supplement.BMICalculator;
import com.example.getfit.Supplement.ViewSupplement;
import com.example.getfit.ToDo_List.To_Do_List;
import com.example.getfit.Workout.WeightConverter;
import com.example.getfit.Workout.WorkOuts;

public class MainActivity extends AppCompatActivity {

    Button btnBMICal,btnWeightCon,btnMacroCal,navigate_todo,navigate_workout,navigate_nutrition,navigate_supplement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBMICal = findViewById(R.id.btnBMICal);
        btnWeightCon = findViewById(R.id.btnWeightCon);
        btnMacroCal = findViewById(R.id.btnMacroCal);

        navigate_todo = findViewById(R.id.navigate_todo);
        navigate_workout = findViewById(R.id.navigate_workout);
        navigate_nutrition = findViewById(R.id.navigate_nutrition);
        navigate_supplement = findViewById(R.id.navigate_supplement);

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
                Intent intent = new Intent(MainActivity.this, WeightConverter.class);
                startActivity(intent);
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

        //redirects to todoList
        navigate_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, To_Do_List.class);
                startActivity(intent);

            }
        });

        //redirects to workout
        navigate_workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, WorkOuts.class);
                startActivity(intent);

            }
        });

        //redirects to meal list
        navigate_nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,ViewMeals.class);
                startActivity(intent);

            }
        });

        //redirects to supplement list
        navigate_supplement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ViewSupplement.class);
                startActivity(intent);

            }
        });
    }
}