package com.example.getfit.Nutrition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.getfit.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MealList extends AppCompatActivity {

    FloatingActionButton button_addMeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_list);

        button_addMeal = findViewById(R.id.button_addMeal);

        button_addMeal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MealList.this, AddMeal.class);
                startActivity(intent);
            }
        });
    }
}