package com.example.remotecoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.InputStream;

public class MainActivity5 extends AppCompatActivity {

    EditText edit_category,edit_name,edit_price,edit_description,edit_imgurl;
    Button btn_add,btn_upload,btn_browse;
    ImageView img;
    Uri filepath;
    Bitmap bitmap;
    Food foodobj;//reference for food class
    DatabaseReference dbRef;//database reference


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        edit_category=findViewById(R.id.et_category);
        edit_name=findViewById(R.id.et_foodname);
        edit_price=findViewById(R.id.et_price);
        edit_description=findViewById(R.id.et_fooddescription);
        edit_imgurl=findViewById(R.id.et_imgurl);
        btn_add=findViewById(R.id.btn_browse);
        img=(ImageView)findViewById(R.id.imgview_image);
        btn_upload=(Button)findViewById(R.id.btn_upload);
        btn_browse=(Button)findViewById(R.id.btn_browse);

        foodobj=new Food();

                btn_browse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Dexter.withActivity(MainActivity5.this)
                                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                                .withListener(new PermissionListener() {
                                    @Override
                                    public void onPermissionGranted(PermissionGrantedResponse response) {
                                        Intent intent=new Intent(Intent.ACTION_PICK);
                                        intent.setType("image/*");
                                        startActivityForResult(Intent.createChooser(intent,"Please select image"),1);
                                    }

                                    @Override
                                    public void onPermissionDenied(PermissionDeniedResponse response) {

                                    }

                                    @Override
                                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                        token.continuePermissionRequest();
                                    }
                                }).check();

                    }
                });
                btn_upload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        uploadtofirebase();
                    }
                });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1 && resultCode==RESULT_OK){
            filepath=data.getData();
            try{
                InputStream inputStream= getContentResolver().openInputStream(filepath);
                bitmap= BitmapFactory.decodeStream(inputStream);
                img.setImageBitmap(bitmap);
            }catch(Exception ex){

            }
        }

        super.onActivityResult(requestCode, resultCode, data);

    }


    //Method to clear all user inputs
    public void clearControls(){
        edit_category.setText("");
        edit_name.setText("");
        edit_price.setText("");
        edit_description.setText("");
        edit_imgurl.setText("");
    }
    public void CreateData(View view){
        dbRef = FirebaseDatabase.getInstance().getReference().child("Food");

        if(TextUtils.isEmpty(edit_category.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please enter a category",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(edit_name.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please enter a name",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(edit_price.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please enter a price",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(edit_description.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please enter a description",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(edit_imgurl.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please enter a image url",Toast.LENGTH_SHORT).show();
        }else{
            foodobj.setCategory(edit_category.getText().toString().trim());
            foodobj.setName(edit_name.getText().toString().trim());
            foodobj.setPrice(Integer.parseInt(edit_price.getText().toString().trim()));
            foodobj.setDescription(edit_description.getText().toString().trim());
            foodobj.setImgurl(edit_imgurl.getText().toString().trim());

            dbRef.push().setValue(foodobj);

            Toast.makeText(getApplicationContext(),"Data inserted successfully!",Toast.LENGTH_SHORT).show();
            clearControls();
        }
    }

    private void uploadtofirebase() {
        ProgressDialog dialog=new ProgressDialog(this);
        dialog.setTitle("File Uploader");
        dialog.show();

        FirebaseStorage storage=FirebaseStorage.getInstance();
        StorageReference uploader=storage.getReference().child("image1");
        uploader.putFile(filepath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(),"File uploaded",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        float percent=(100*snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
                        dialog.setMessage("Uploaded :"+(int)percent+" %");
                    }
                });
    }
}