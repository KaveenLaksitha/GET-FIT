package com.example.getfit.Supplement;

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
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.getfit.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class AddSupplement extends AppCompatActivity {

    EditText name_input, price_input, description_input;
    Button add_button;
    ImageView supImage;
    private String name,price,description;

    //permission constants
    private static final int CAMERA_REQUEST_CODE = 100;
    private static final int STORAGE_REQUEST_CODE = 101;

    //image pick constants
    private static final int IMAGE_PICK_CAMERA_CODE = 102;
    private static final int IMAGE_PICK_GALLERY_CODE = 103;

    //array of permission
    private String[] cameraPermission;//camera and storage
    private String[] storagePermission;//only storage

    //variable (will contains data to save)
    private Uri supImageUri;

    MyDatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_supplement);

        name_input = findViewById(R.id.name_input);
        price_input = findViewById(R.id.price_input);
        description_input = findViewById(R.id.description_input);
        supImage = findViewById(R.id.supImage);


        add_button = findViewById(R.id.add_button);
        myDB = new MyDatabaseHelper(this);

        //init permission array
        cameraPermission = new String[] {Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermission = new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE};

        supImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imagePickDialog();

            }
        });

        add_button.setOnClickListener(new View.OnClickListener() {
            

            @Override
            public void onClick(View view) {
               /*MyDatabaseHelper myDB = new MyDatabaseHelper(AddSupplement.this);
                myDB.addSupplement(name_input.getText().toString().trim(),
                        price_input.getText().toString().trim(),
                        description_input.getText().toString().trim());

         
                Intent intent  = new Intent(AddSupplement.this,SupDashboard.class);
                startActivity(intent);*/
                inputSupplementData();
            }

        });
    }

    private void inputSupplementData() {
        name = name_input.getText().toString();
        price = price_input.getText().toString();
        description = description_input.getText().toString();

        if(name.isEmpty() || price.isEmpty() || description.isEmpty()){
            Toast.makeText(getApplicationContext(),"please fill the all the fields!",Toast.LENGTH_SHORT).show();
        }else {

            myDB.addSupplement(name, price, description,"" + supImageUri);

            Intent intent = new Intent(AddSupplement.this,ViewSupplement.class);
            startActivity(intent);


        }

    }



    private  void imagePickDialog(){
        String[] options = {"Camera" , "Gallery"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Pick Image From");

        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0){
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

        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "Image title");
        values.put(MediaStore.Images.Media.DESCRIPTION, "Image title");

        supImageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, supImageUri);
        startActivityForResult(cameraIntent, IMAGE_PICK_CAMERA_CODE);
    }

    private void pickFromGallery(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_GALLERY_CODE );
    }

    private  boolean checkStoragePermission(){
        //check if storage permission is enable or not
        boolean result = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)==(PackageManager.PERMISSION_GRANTED);
        return result;
    }

    private void requeststoragepermission(){
        ActivityCompat.requestPermissions(this,
                storagePermission,STORAGE_REQUEST_CODE);

    }

    private boolean checkcamerapeemission(){
        boolean result = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)==(PackageManager.PERMISSION_GRANTED);
        boolean result1 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)==(PackageManager.PERMISSION_GRANTED);

        return result && result1;

    }

    private void requestCamerapermission(){
        ActivityCompat.requestPermissions(this,cameraPermission,CAMERA_REQUEST_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //result of permission allowed/denied
        switch (requestCode){
            case CAMERA_REQUEST_CODE:{
                if(grantResults.length>0){
                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean storageAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if(cameraAccepted && storageAccepted){
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
        if (resultCode == RESULT_OK){
            if (requestCode == IMAGE_PICK_GALLERY_CODE){
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
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                if(resultCode == RESULT_OK){
                    Uri resultUri = result.getUri();

                    supImageUri = resultUri;

                    supImage.setImageURI(resultUri);
                }
                else if(resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                    Exception error = result.getError();
                    Toast.makeText(this, "" + error, Toast.LENGTH_SHORT).show();

                }

            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}