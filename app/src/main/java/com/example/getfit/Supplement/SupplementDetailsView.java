package com.example.getfit.Supplement;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.getfit.R;

public class SupplementDetailsView extends AppCompatActivity {

    TextView supName,supPrice,supDescription;
    ImageView supImage;

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
    }
}