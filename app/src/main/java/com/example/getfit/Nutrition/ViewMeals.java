package com.example.getfit.Nutrition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.getfit.R;

import java.util.ArrayList;

public class ViewMeals extends AppCompatActivity {

    RecyclerView recyclerView;

    DBHelper db ;
    ArrayList<String> mealID, mealName;
    UserMealsAdapter customAdapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_meals);

        recyclerView = findViewById(R.id.user_meals_recycler);

        db = new DBHelper(ViewMeals.this);
        mealID = new ArrayList<>();
        mealName = new ArrayList<>();

        storeMealsInArray();

        customAdapater = new UserMealsAdapter(ViewMeals.this,mealID,mealName);
        recyclerView.setAdapter(customAdapater);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewMeals.this));
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