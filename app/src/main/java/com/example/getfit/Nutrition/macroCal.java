package com.example.getfit.Nutrition;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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
                dbHelper = new DBHelper(getApplicationContext());
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                /*Cursor cursor = ;
                if(cursor.moveToFirst())
                {
                    String MOBILE=cursor.getString(0);
                    String EMALL=cursor.getString(1);
                    txtViewEnergy.setText();
                    txtViewFat.setText();
                    txtViewCarbs.setText();
                    txtViewFiber.setText();
                    txtViewProtein.setText();
                    txtViewSodium.setText();
                    txtViewCholesterol.setText();
                    txtViewPotasium.setText();
                    txtViewCalories.setText();

                }*/

            }
        });
    }
}