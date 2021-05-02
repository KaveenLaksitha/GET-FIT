package com.example.getfit.Nutrition;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.getfit.R;

public class macroCal extends AppCompatActivity {

    EditText txtInFood,numInServSize;
    TextView txtViewEnergy,txtViewFat,txtViewCarbs,txtViewFiber,txtViewProtein,txtViewSodium,txtViewCholesterol,txtViewPotasium,txtViewCalories;
    Button btnFindMacro;
    DBHelper dbHelper;
    String foodName;
    Float servings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macro_cal);

        txtInFood = findViewById(R.id.txtInFood);
        numInServSize = findViewById(R.id.numInServSize);

        txtViewEnergy = findViewById(R.id.txtViewEnergy);
        txtViewFat = findViewById(R.id.txtViewFat);
        txtViewCarbs = findViewById(R.id.txtViewCarbs);
        txtViewFiber = findViewById(R.id.txtViewFiber);
        txtViewProtein = findViewById(R.id.txtViewProtein);
        txtViewSodium = findViewById(R.id.txtViewSodium);
        txtViewCholesterol = findViewById(R.id.txtViewCholesterol);
        txtViewPotasium = findViewById(R.id.txtViewPotasium);
        txtViewCalories = findViewById(R.id.txtViewCalories);

        btnFindMacro = findViewById(R.id.btnFindMacro);

        btnFindMacro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                foodName = txtInFood.getText().toString().trim();
                servings = Float.valueOf(numInServSize.getText().toString().trim());
                Log.d("inputed string", foodName);
                dbHelper = new DBHelper(getApplicationContext());
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                Cursor cursor = dbHelper.SearchMacro(foodName);
                if(cursor.moveToFirst())
                {

                    Float energyVal = Float.valueOf(cursor.getString(2))/150 * servings;
                    Float fatVal = Float.valueOf(cursor.getString(3))/150 * servings;
                    Float carbyVal = Float.valueOf(cursor.getString(4))/150 * servings;
                    Float fiberVal = Float.valueOf(cursor.getString(5))/150 * servings;
                    Float proteinVal = Float.valueOf(cursor.getString(6))/150 * servings;
                    Float sodiumVal = Float.valueOf(cursor.getString(7))/150 * servings;
                    Float cholesterolVal = Float.valueOf(cursor.getString(8))/150 * servings;
                    Float potasiumVal = Float.valueOf(cursor.getString(9))/150 * servings;
                    Float caloriesVal = Float.valueOf(cursor.getString(10))/150 * servings;

                    txtViewEnergy.setText(String.valueOf(energyVal));
                    txtViewFat.setText(String.valueOf(fatVal));
                    txtViewCarbs.setText(String.valueOf(carbyVal));
                    txtViewFiber.setText(String.valueOf(fiberVal));
                    txtViewProtein.setText(String.valueOf(proteinVal));
                    txtViewSodium.setText(String.valueOf(sodiumVal));
                    txtViewCholesterol.setText(String.valueOf(cholesterolVal));
                    txtViewPotasium.setText(String.valueOf(potasiumVal));
                    txtViewCalories.setText(String.valueOf(caloriesVal));

                }

            }
        });
    }
}