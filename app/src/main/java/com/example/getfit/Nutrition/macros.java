package com.example.getfit.Nutrition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.getfit.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class macros extends AppCompatActivity {


    DBHelper db;
    FloatingActionButton nutrition_add_macro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macros);

        nutrition_add_macro = findViewById(R.id.nutrition_add_macro);

        nutrition_add_macro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(macros.this, AddMacros.class);
                startActivity(intent);
            }
        });
    }
}