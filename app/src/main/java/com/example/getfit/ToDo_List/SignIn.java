package com.example.getfit.ToDo_List;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.getfit.Nutrition.MainActivity;
import com.example.getfit.Nutrition.NutritionNavigate;
import com.example.getfit.R;
import com.example.getfit.Supplement.SupDashboard;
import com.example.getfit.ToDo_List.Database.UserManagementDBHelper;
import com.example.getfit.Workout.WorkoutDashBoard;

public class SignIn extends AppCompatActivity {

    EditText username,password;
    Button SignIn;

    UserManagementDBHelper userManagementDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_sign_in);

        username = findViewById(R.id.SignInUserName);
        password = findViewById(R.id.SignInPassword);
        SignIn =findViewById(R.id.SignIn);

        userManagementDBHelper = new UserManagementDBHelper(this);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                String work_username,work_password,nutrition_username,nutrition_password,sup_username,sup_password;

                work_username = "hasani";
                work_password = "hasani";

                nutrition_username = "kaveen";
                nutrition_password = "kaveen";

                sup_username = "nalini";
                sup_password = "nalini";

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(SignIn.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkuserPassword = userManagementDBHelper.checkpassword(user,pass);
                    if(checkuserPassword == true){

                        Toast.makeText(SignIn.this, "Login to the GET FIT", Toast.LENGTH_SHORT).show();

                        if((user.equals(work_username) && (pass.equals(work_password) ))){
                            Intent intent = new Intent(getApplicationContext(), WorkoutDashBoard.class);
                            startActivity(intent);
                        }
                        else if((user.equals(nutrition_username) && (pass.equals(nutrition_password) ))){
                            Intent intent = new Intent(getApplicationContext(), NutritionNavigate.class);
                            startActivity(intent);
                        }
                        else if((user.equals(sup_username) && (pass.equals(sup_password) ))){
                            Intent intent = new Intent(getApplicationContext(), SupDashboard.class);
                            startActivity(intent);
                        }
                        else {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }
                    }else{
                        Toast.makeText(SignIn.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}