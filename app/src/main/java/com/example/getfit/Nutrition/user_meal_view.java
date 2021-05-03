package com.example.getfit.Nutrition;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.getfit.R;

public class user_meal_view extends AppCompatActivity {

    TextView um_bm01,um_bm02,um_bm03,um_bm04,um_lm01,um_lm02,um_lm03,um_lm04,um_dm01,um_dm02,um_dm03,um_dm04;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_meal_view);

        Log.d("mealId",(getIntent().getStringExtra("mealID")));

        String clickedRow = getIntent().getStringExtra("mealID");

        um_bm01 = findViewById(R.id.um_bm01);
        um_bm02= findViewById(R.id.um_bm02);
        um_bm03= findViewById(R.id.um_bm03);
        um_bm04= findViewById(R.id.um_bm04);
        um_lm01 = findViewById(R.id.um_lm01);
        um_lm02= findViewById(R.id.um_lm02);
        um_lm03= findViewById(R.id.um_lm03);
        um_lm04= findViewById(R.id.um_lm04);
        um_dm01 = findViewById(R.id.um_dm01);
        um_dm02= findViewById(R.id.um_dm02);
        um_dm03= findViewById(R.id.um_dm03);
        um_dm04= findViewById(R.id.um_dm04);

        dbHelper = new DBHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = dbHelper.SearchMeal(clickedRow);

        if(cursor.moveToFirst()){

            um_bm01.setText(cursor.getString(2));
            um_bm02.setText(cursor.getString(3));
            um_bm03.setText(cursor.getString(4));
            um_bm04.setText(cursor.getString(5));
            um_lm01.setText(cursor.getString(6));
            um_lm02.setText(cursor.getString(7));
            um_lm03.setText(cursor.getString(8));
            um_lm04.setText(cursor.getString(9));
            um_dm01.setText(cursor.getString(10));
            um_dm02.setText(cursor.getString(11));
            um_dm03.setText(cursor.getString(12));
            um_dm04.setText(cursor.getString(13));

        }
    }
}