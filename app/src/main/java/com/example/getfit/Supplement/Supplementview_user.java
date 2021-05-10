package com.example.getfit.Supplement;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.getfit.Nutrition.ViewMeals;
import com.example.getfit.R;
import com.example.getfit.ToDo_List.To_Do_List;
import com.example.getfit.Workout.WorkOuts;

import java.util.ArrayList;

public class Supplementview_user extends AppCompatActivity {

    ArrayList<String> sup_id,sup_name, sup_price, sup_description;
    SupplementAdapter customAdapter;
    RecyclerView recycler;
    Button navigate_todo,navigate_workout,navigate_nutrition,navigate_supplement;

    MyDatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplementview_user);

        recycler = findViewById(R.id.userSupView);


        myDB = new MyDatabaseHelper(Supplementview_user.this);

        sup_id = new ArrayList<>();
        sup_name = new ArrayList<>();
        sup_price = new ArrayList<>();
        sup_description = new ArrayList<>();

        storeDataInArray();

        customAdapter = new SupplementAdapter(Supplementview_user.this, this,sup_id, sup_name, sup_price, sup_description);
        recycler.setAdapter(customAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(Supplementview_user.this));



        //bottom navigation bar
        navigate_todo = findViewById(R.id.navigate_todo);
        navigate_workout = findViewById(R.id.navigate_workout);
        navigate_nutrition = findViewById(R.id.navigate_nutrition);
        navigate_supplement = findViewById(R.id.navigate_supplement);

        //redirects to todoList
        navigate_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Supplementview_user.this, To_Do_List.class);
                startActivity(intent);

            }
        });

        //redirects to workout
        navigate_workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Supplementview_user.this, WorkOuts.class);
                startActivity(intent);

            }
        });

        //redirects to meal list
        navigate_nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Supplementview_user.this, ViewMeals.class);
                startActivity(intent);

            }
        });

        //redirects to supplement list
        navigate_supplement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Supplementview_user.this, ViewSupplement.class);
                startActivity(intent);

            }
        });




    }


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            recreate();
        }
    }

    void storeDataInArray(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                sup_id.add(cursor.getString(0));
                sup_name.add(cursor.getString(1));
                sup_price.add(cursor.getString(2));
                sup_description.add(cursor.getString(3));
            }
        }


    }
}