package com.example.getfit.ToDo_List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.circularimageview.CircularImageView;
import com.example.getfit.Nutrition.ViewMeals;
import com.example.getfit.R;
import com.example.getfit.Supplement.ViewSupplement;
import com.example.getfit.ToDo_List.Database.UserManagementDBHelper;
import com.example.getfit.Workout.WorkOuts;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;

public class UserProfile extends AppCompatActivity {

    EditText SignUpName, SignUpEmail, SignUpGender, SignUpHeight, SignUpWeight, SignUpAge;
    CircularImageView userProfilePic;
    Button UPbtnUpdate, UPtxtDelete;

    //bottom navigation button pannel
    Button navigate_todo,navigate_workout,navigate_nutrition,navigate_supplement;


    //variables
    String user,ema,gen;
    float wei,hei;
    int age;

    String userimage;

    String viewimageuser;

    //variable (will contains data to save)
    private Uri imageUri;

    //permission constants
    private static final int CAMERA_REQUEST_CODE = 100;
    private static final int STORAGE_REQUEST_CODE = 101;

    //image pick constants
    private static final int IMAGE_PICK_CAMERA_CODE = 102;
    private static final int IMAGE_PICK_GALLERY_CODE = 103;

    //array of permission
    private String[] cameraPermission;//camera and storage
    private String[] storagePermission;//only storage


    UserManagementDBHelper userManagementDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        user = getIntent().getStringExtra("username");

        SignUpName = findViewById(R.id.SignUpName);
        SignUpEmail = findViewById(R.id.SignUpEmail);
        SignUpGender = findViewById(R.id.SignUpGender);
        SignUpHeight = findViewById(R.id.SignUpHeight);
        SignUpWeight = findViewById(R.id.SignUpWeight);
        SignUpAge = findViewById(R.id.SignUpAge);
        UPbtnUpdate = findViewById(R.id.UPbtnUpdate);
        UPtxtDelete = findViewById(R.id.UPtxtDelete);
        userProfilePic = findViewById(R.id.userProfilePic);

        //bottom navigation button
        navigate_todo = findViewById(R.id.navigate_todo);
        navigate_workout = findViewById(R.id.navigate_workout);
        navigate_nutrition = findViewById(R.id.navigate_nutrition);
        navigate_supplement = findViewById(R.id.navigate_supplement);


        userManagementDBHelper = new UserManagementDBHelper(getApplicationContext());

        //init permission array
        cameraPermission = new String[] {Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermission = new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE};

        userProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imagePickDialog();

            }
        });

        Cursor cursor = userManagementDBHelper.retriveDataUserProfile(user);

        if (cursor.moveToFirst()) {
            SignUpName.setText(user);
            SignUpEmail.setText(cursor.getString(1));
            SignUpGender.setText(cursor.getString(3));
            SignUpHeight.setText(cursor.getString(4));
            SignUpWeight.setText(cursor.getString(5));
            SignUpAge.setText(cursor.getString(6));
        }

        viewimageuser = user;
        Cursor cursor1 = userManagementDBHelper.retrieveimage(viewimageuser);
        if(cursor1.moveToFirst()){
            userProfilePic.setImageURI(Uri.parse(cursor1.getString(1)));
        }

        //click to update button to update data
        UPbtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //UserManagementDBHelper userManagementDBHelper = new UserManagementDBHelper(UserProfile.this);
                user = SignUpName.getText().toString().trim();
                ema = SignUpEmail.getText().toString().trim();
                gen = SignUpGender.getText().toString().trim();
                hei = Float.valueOf(SignUpHeight.getText().toString().trim());
                wei = Float.valueOf(SignUpWeight.getText().toString().trim());
                age = Integer.valueOf(SignUpAge.getText().toString().trim());

                userManagementDBHelper.updateUserProfile(user,ema,gen,hei,wei,age);

                inputData();

                //get data
                userimage = "" + SignUpName.getText().toString().trim();
                //save to db
                userManagementDBHelper.update_photo(
                        "" + userimage,
                        "" + imageUri);

            }
        });

        UPtxtDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDeleteAccountBox();
                //Intent intent = new Intent(UserProfile.this,SignUp.class);
                confirmDeleteAccountBox();
                //startActivity(intent);
            }
        });


        //redirects to todoList
        navigate_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserProfile.this, To_Do_List.class);
                startActivity(intent);

            }
        });

        //redirects to workout
        navigate_workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserProfile.this, WorkOuts.class);
                startActivity(intent);

            }
        });

        //redirects to meal list
        navigate_nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserProfile.this, ViewMeals.class);
                startActivity(intent);

            }
        });

        //redirects to supplement list
        navigate_supplement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserProfile.this, ViewSupplement.class);
                startActivity(intent);

            }
        });


    }

    //Insert -> image relevant user
    private void inputData() {
        userimage = "" + SignUpName.getText().toString().trim();

        boolean id = userManagementDBHelper.insertimage(
                "" + userimage,
                "" + imageUri);
    }

    private void imagePickDialog() {
        //option to display in dialog
        String[] options = {"Camera" , "Gallery"};
        //dialog
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        //title
        builder.setTitle("Pick Image From");
        //set item/options
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //handle click
                if (which == 0){
                    //camera click
                    if(!checkcamerapeemission()){
                        requestCamerapermission();
                    }else{
                        //permission already granted
                        pickFromCamer();

                    }
                }
                else if(which == 1){
                    if(!checkStoragePermission()){
                        requeststoragepermission();
                    }else{
                        //permission already granted
                        pickFromGallery();

                    }
                }

            }
        });

        //create show dialog
        builder.create().show();
    }

    private void pickFromCamer(){
        //intent to pick image from camera, the image will be returned in onActivityResult method
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "Image title");
        values.put(MediaStore.Images.Media.DESCRIPTION, "Image title");

        //put image uri
        imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);

        //intent to open camera for image
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(cameraIntent, IMAGE_PICK_CAMERA_CODE);
    }

    private void pickFromGallery(){
        //intent to pick image from gallery, the image will be returned in onActivity result method
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");//we want only images
        startActivityForResult(intent, IMAGE_PICK_GALLERY_CODE );
    }

    private  boolean checkStoragePermission(){
        //check if storage permission is enable or not
        boolean result = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)==(PackageManager.PERMISSION_GRANTED);
        return result;
    }

    private void requeststoragepermission(){
        //request storage permission
        ActivityCompat.requestPermissions(this,
                storagePermission,STORAGE_REQUEST_CODE);

    }

    private boolean checkcamerapeemission(){
        //check if camera permission  is enable or not
        boolean result = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)==(PackageManager.PERMISSION_GRANTED);
        boolean result1 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)==(PackageManager.PERMISSION_GRANTED);

        return result && result1;

    }

    private void requestCamerapermission(){
        //request the camera permission
        ActivityCompat.requestPermissions(this,cameraPermission,CAMERA_REQUEST_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //result of permission allowed/denied
        switch (requestCode){
            case CAMERA_REQUEST_CODE:{
                if(grantResults.length>0){
                    //if allowed returns true otherwise false
                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean storageAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if(cameraAccepted && storageAccepted){
                        //both permission allowed
                        pickFromCamer();
                    }
                    else{
                        Toast.makeText(this, "Camera & Storage permission are required", Toast.LENGTH_SHORT).show();
                    }

                }

            }
            break;
            case STORAGE_REQUEST_CODE:{
                if(grantResults.length>0){
                    //if allowed return true otherwise false
                    boolean storageAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;

                    if(storageAccepted){
                        //storage permission allowed
                        pickFromGallery();
                    }
                    else{
                        Toast.makeText(this, "Storage permission is required..", Toast.LENGTH_SHORT).show();
                    }

                }
            }

            break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       //image picked from camera or gallery will be received here
        if (resultCode == RESULT_OK){
            //image is picked
            if (requestCode == IMAGE_PICK_GALLERY_CODE){
                //picked from gallery
                CropImage.activity(data.getData())
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .setAspectRatio(1,1)
                        .start(this);
            }else if (requestCode == IMAGE_PICK_GALLERY_CODE){
                CropImage.activity(data.getData())
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .setAspectRatio(1,1)
                        .start(this);
            }else if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
                //cropped image received
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                if(resultCode == RESULT_OK){
                    Uri resultUri = result.getUri();

                    //set image
                    imageUri = resultUri;

                    userProfilePic.setImageURI(resultUri);
                }
                else if(resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                    //error
                    Exception error = result.getError();
                    Toast.makeText(this, "" + error, Toast.LENGTH_SHORT).show();

                }

            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    void confirmDeleteAccountBox(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + user + " ?");
        builder.setMessage("Are you sure you want to delete " + user + " Account ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                UserManagementDBHelper userManagementDBHelper = new UserManagementDBHelper(UserProfile.this);
                userManagementDBHelper.deleteAccount(user);
                userManagementDBHelper.deletimage(viewimageuser);
                finish();
                Intent intent =new Intent(UserProfile.this,SignUp.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}