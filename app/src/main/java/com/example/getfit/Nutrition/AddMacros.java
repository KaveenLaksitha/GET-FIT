package com.example.getfit.Nutrition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.getfit.R;

public class AddMacros extends AppCompatActivity {

    EditText title_foodName,title_energy,title_fat,title_carb,title_fiber,title_protein,title_sodium,title_cholesterol,title_potasium;
    Button button_add_macros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_macros);

        title_foodName = findViewById(R.id.title_foodName);
        title_energy = findViewById(R.id.title_energy);
        title_fat = findViewById(R.id.title_fat);
        title_carb = findViewById(R.id.title_carb);
        title_fiber = findViewById(R.id.title_fiber);
        title_protein = findViewById(R.id.title_protein);
        title_sodium = findViewById(R.id.title_sodium);
        title_cholesterol = findViewById(R.id.title_cholesterol);
        title_potasium = findViewById(R.id.title_potasium);

        button_add_macros = findViewById(R.id.button_add_macros);

        button_add_macros.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                DBHelper dbHelper = new DBHelper(AddMacros.this);
                dbHelper.addMacro(title_foodName.getText().toString().trim(),
                        title_energy.getText().toString().trim(),
                        title_fat.getText().toString().trim(),
                        title_carb.getText().toString().trim(),
                        title_fiber.getText().toString().trim(),
                        title_protein.getText().toString().trim(),
                        title_sodium.getText().toString().trim(),
                        title_cholesterol.getText().toString().trim(),
                        title_potasium.getText().toString().trim());

                Intent intent = new Intent(AddMacros.this, macros.class);
                startActivity(intent);
                finish();
            }
        });

    }
}