package com.example.getfit.Nutrition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.getfit.R;
import com.example.getfit.Supplement.ViewSupplement;
import com.example.getfit.ToDo_List.To_Do_List;
import com.example.getfit.Workout.WorkOuts;

import java.util.ArrayList;

public class ViewMeals extends AppCompatActivity {

    Button navigate_todo,navigate_workout,navigate_nutrition,navigate_supplement;

    RecyclerView recyclerView;

    DBHelper db ;
    ArrayList<String> mealID, mealName;
    UserMealsAdapter customAdapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_meals);

        navigate_todo = findViewById(R.id.navigate_todo);
        navigate_workout = findViewById(R.id.navigate_workout);
        navigate_nutrition = findViewById(R.id.navigate_nutrition);
        navigate_supplement = findViewById(R.id.navigate_supplement);

        recyclerView = findViewById(R.id.user_meals_recycler);

        db = new DBHelper(ViewMeals.this);
        mealID = new ArrayList<>();
        mealName = new ArrayList<>();

        storeMealsInArray();

        customAdapater = new UserMealsAdapter(ViewMeals.this,mealID,mealName);
        recyclerView.setAdapter(customAdapater);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewMeals.this));

        //bottom navigation buttons on click listners
        navigate_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ViewMeals.this, To_Do_List.class);
                startActivity(intent);

            }
        });

        navigate_workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ViewMeals.this, WorkOuts.class);
                startActivity(intent);

            }
        });

        navigate_nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ViewMeals.this,ViewMeals.class);
                startActivity(intent);

            }
        });

        navigate_supplement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ViewMeals.this, ViewSupplement.class);
                startActivity(intent);

            }
        });
    }

    void storeMealsInArray(){
        Cursor cursor =  db.readMealTableData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                mealID.add(cursor.getString(0));
                mealName.add(cursor.getString(1));
            }
        }
    }
}