package com.example.getfit.Supplement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.getfit.R;

public class UpdateSupplement extends AppCompatActivity {

    EditText name_input, price_input, description_input;
    Button update_button, delete_button;

    String id ,name , price, description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_supplement);

        name_input = findViewById(R.id.name_input2);
        price_input = findViewById(R.id.price_input2);
        description_input = findViewById(R.id.description_input);
        update_button = findViewById(R.id.update_button);

        //First we call this
        getAndSetIntentData();
        update_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //And only we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateSupplement.this);
                myDB.updateData(id,name,price,description);

            }
        });



    }
    void getAndSetIntentData(){
        if (getIntent().hasExtra("id") && getIntent().hasExtra("name") &&
        getIntent().hasExtra("price") && getIntent().hasExtra("description")){
            //getting data from intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            price = getIntent().getStringExtra("price");
            description = getIntent().getStringExtra("description");

            //setting intent data
            name_input.setText(name);
            price_input.setText(price);
            description_input.setText(description);


        }else{
            Toast.makeText(this,"No data.", Toast.LENGTH_SHORT).show();
        }
    }
}