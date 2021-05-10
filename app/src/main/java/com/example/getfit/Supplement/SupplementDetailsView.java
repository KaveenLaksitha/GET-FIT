package com.example.getfit.Supplement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.getfit.Nutrition.ViewMeals;
import com.example.getfit.R;
import com.example.getfit.ToDo_List.To_Do_List;
import com.example.getfit.Workout.WorkOuts;

public class SupplementDetailsView extends AppCompatActivity {

    TextView supName,supPrice,supDescription;
    ImageView supImage;
    Button navigate_todo,navigate_workout,navigate_nutrition,navigate_supplement;

    MyDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplement_details_view);

        supName = findViewById(R.id.supName);
        supPrice = findViewById(R.id.supPrice);
        supDescription = findViewById(R.id.supDescription);
        supImage = findViewById(R.id.supImg);

        String sup_id = getIntent().getStringExtra("id");
        String sup_name = getIntent().getStringExtra("name");
        String sup_price = getIntent().getStringExtra("price");
        String sup_desc = getIntent().getStringExtra("description");

        db = new MyDatabaseHelper(getApplicationContext());

        Cursor cursor = db.retrieveimage(sup_id);
        Log.d("image<<<<<<",String.valueOf(cursor));

        if(cursor.moveToFirst()){
            supImage.setImageURI(Uri.parse(cursor.getString(4)));
        }

        supName.setText(sup_name);
        supPrice.setText(sup_price);
        supDescription.setText(sup_desc);

        //bottom navigation bar
        navigate_todo = findViewById(R.id.navigate_todo);
        navigate_workout = findViewById(R.id.navigate_workout);
        navigate_nutrition = findViewById(R.id.navigate_nutrition);
        navigate_supplement = findViewById(R.id.navigate_supplement);

        //redirects to todoList
        navigate_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SupplementDetailsView.this, To_Do_List.class);
                startActivity(intent);

            }
        });

        //redirects to workout
        navigate_workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SupplementDetailsView.this, WorkOuts.class);
                startActivity(intent);

            }
        });

        //redirects to meal list
        navigate_nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SupplementDetailsView.this, ViewMeals.class);
                startActivity(intent);

            }
        });

        //redirects to supplement list
        navigate_supplement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SupplementDetailsView.this, ViewSupplement.class);
                startActivity(intent);

            }
        });



    }

}