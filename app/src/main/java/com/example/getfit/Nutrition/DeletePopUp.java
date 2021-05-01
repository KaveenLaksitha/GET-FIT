package com.example.getfit.Nutrition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.getfit.R;

public class DeletePopUp extends AppCompatActivity {

    TextView mealID,mealName;
    Button delete,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_pop_up);

        mealID = findViewById(R.id.textView_MealId);
        mealName = findViewById(R.id.textView_MealName);

        delete = findViewById(R.id.nutrition_button_delete);
        cancel = findViewById(R.id.nutrition_button_cancel);

        Log.d("mealId",(getIntent().getStringExtra("mealID")));

        mealID.setText(getIntent().getStringExtra("mealID"));
        mealName.setText(getIntent().getStringExtra("mealName"));

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper dbHelper = new DBHelper(DeletePopUp.this);

                dbHelper.deleteMealRow((getIntent().getStringExtra("mealID")));

                Intent intent = new Intent(DeletePopUp.this,MealList.class);
                startActivity(intent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}