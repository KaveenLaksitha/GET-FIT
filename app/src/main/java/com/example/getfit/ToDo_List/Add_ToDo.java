package com.example.getfit.ToDo_List;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.getfit.R;
import com.example.getfit.ToDo_List.Database.UserManagementDBHelper;

public class Add_ToDo extends AppCompatActivity {

    EditText title_input;
    EditText description_input;
    Button add_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__to_do);

        title_input = findViewById(R.id.title_input);
        description_input = findViewById(R.id.description_input);

        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                UserManagementDBHelper userManagementDBHelper = new UserManagementDBHelper(Add_ToDo.this);
                userManagementDBHelper.addlist(title_input.getText().toString().trim(),
                        description_input.getText().toString().trim());

            }
        });

    }


}

