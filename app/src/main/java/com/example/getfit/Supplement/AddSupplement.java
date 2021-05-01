package com.example.getfit.Supplement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.getfit.R;

public class AddSupplement extends AppCompatActivity {

    EditText name_input, price_input, description_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_supplement);

        name_input = findViewById(R.id.name_input);
        price_input = findViewById(R.id.price_input);
        description_input = findViewById(R.id.description_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddSupplement.this);
                myDB.addSupplement(name_input.getText().toString().trim(),
                        price_input.getText().toString().trim(),
                        description_input.getText().toString().trim());
            }
        });
    }
}