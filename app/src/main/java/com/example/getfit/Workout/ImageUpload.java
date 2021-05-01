package com.example.getfit.Workout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.getfit.R;
import com.example.getfit.Workout.DataBase.DBHelper;
import com.example.getfit.Workout.DataBase.ModelClass;

public class ImageUpload extends AppCompatActivity {

    private EditText imageDetailsET;
    private ImageView objectImageView;
    Bitmap imageToStore;
    DBHelper dbHelper;

    private static  final int PICK_IMAGE_REQUEST = 100;//any number other than 0
    private Uri imageFilepath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_upload);


        try{
            imageDetailsET =findViewById(R.id.wo_ImageUploadEtn1);
            objectImageView =findViewById(R.id.wo_image);

            dbHelper = new DBHelper(this);

        }catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void chooseImage(View view){
        try{
            Intent objectIntent = new Intent();
            objectIntent.setType("image/*");

            objectIntent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(objectIntent,PICK_IMAGE_REQUEST);

        }catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        try{
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data!=null && data.getData() !=null){
                imageFilepath =data.getData();
                imageToStore = MediaStore.Images.Media.getBitmap(getContentResolver(),imageFilepath);

                objectImageView.setImageBitmap(imageToStore);
            }


        }catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }



    public void storeImage(View view){
        try{
            if(!imageDetailsET.getText().toString().isEmpty() && objectImageView.getDrawable() != null && imageToStore !=null)
            {
                dbHelper.storeImage(new ModelClass(imageDetailsET.getText().toString(),imageToStore));
            }
            else{
                Toast.makeText(this,"Please select image name and image" , Toast.LENGTH_SHORT).show();
            }



        }catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public void deleteImage(View view){
        try{
            if(!imageDetailsET.getText().toString().isEmpty())
            {
                dbHelper.deleteImageInfo(imageDetailsET.getText().toString());
            }
            else{
                Toast.makeText(this,"Please enter image Id to proceed " , Toast.LENGTH_SHORT).show();
            }



        }catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}