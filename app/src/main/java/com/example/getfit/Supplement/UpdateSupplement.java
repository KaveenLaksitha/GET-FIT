package com.example.getfit.Supplement;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.getfit.R;

public class UpdateSupplement extends AppCompatActivity {

    EditText name_input, price_input, description_input;
    Button update_button, delete_button;

    String id, name, price, description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_supplement);

        name_input = findViewById(R.id.name_input2);
        price_input = findViewById(R.id.price_input2);
        description_input = findViewById(R.id.description_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //setActionBar name
        ActionBar ab = getSupportActionBar();
        if (ab != null) {

        }

        update_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //And only we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateSupplement.this);
                name = name_input.getText().toString().trim();
                price = price_input.getText().toString().trim();
                description = description_input.getText().toString().trim();
                myDB.updateData(id, name, price, description);

            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();

            }
        });

    }


    void getAndSetIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("name") &&
                getIntent().hasExtra("price") && getIntent().hasExtra("description")) {
            //getting data from intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            price = getIntent().getStringExtra("price");
            description = getIntent().getStringExtra("description");

            //setting intent data
            name_input.setText(name);
            price_input.setText(price);
            description_input.setText(description);
            Log.d("stev", name + " " + price + " " + description);


        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete" + name + " ?");
        builder.setMessage("Are you sure want to delete " + name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateSupplement.this);
                myDB.deleteOneRow(id);
                finish();

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();

    }


}
