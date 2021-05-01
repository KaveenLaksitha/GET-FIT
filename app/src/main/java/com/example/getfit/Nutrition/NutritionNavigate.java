package com.example.getfit.Nutrition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.getfit.R;

public class NutritionNavigate extends AppCompatActivity {

    Button view_meal,add_meal,update_meal,view_macros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_navigate);

        view_meal = findViewById(R.id.nutrition_button_viewMeals);
        add_meal = findViewById(R.id.nutrition_button_addMeals);
        update_meal = findViewById(R.id.nutrition_button_updateMeals);
        view_macros = findViewById(R.id.nutrition_button_Macros);

        view_meal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NutritionNavigate.this, MealList.class);
                startActivity(intent);
            }
        });

        add_meal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NutritionNavigate.this, AddMeal.class);
                startActivity(intent);
            }
        });

        update_meal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NutritionNavigate.this, UpdateMeal.class);
                startActivity(intent);
            }
        });

        view_macros.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NutritionNavigate.this, macros.class);
                startActivity(intent);
            }
        });
    }
}