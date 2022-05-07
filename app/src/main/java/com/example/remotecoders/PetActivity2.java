package com.example.remotecoders;

import androidx.annotation.NonNull;
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
import android.webkit.PermissionRequest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.InputStream;


public class PetActivity2 extends AppCompatActivity {

    EditText petname,petage,petgender,petcol,petloc,pettel,petprice;
    Button addbtn,brsbtn,upbtn;
    Pet petobj;//reference for pet class
    DatabaseReference dbRef;//dabase refrence
    ImageView dogview;
    Uri filepath;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet2);

        petname = findViewById(R.id.petname);
        petage = findViewById(R.id.petage);
        petgender = findViewById(R.id.petgender);
        petcol = findViewById(R.id.petcol);
        petloc = findViewById(R.id.petloc);
        pettel = findViewById(R.id.pettel);
        petprice = findViewById(R.id.petprice);
        addbtn = findViewById(R.id.addbtn);
        dogview = findViewById(R.id.dogview);
        brsbtn = findViewById(R.id.brsbtn);
        upbtn = findViewById(R.id.upbtn);
        petobj = new Pet();


        brsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withActivity(PetActivity2.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response) {
                                Intent intent = new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent, "Please select image"), 1);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(com.karumi.dexter.listener.PermissionRequest permission, PermissionToken token) {

                            }


                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                token.continuePermissionRequest();
                            }
                        }).check();

            }
        });
        upbtn.setOnClickListener(new View.OnClickListener() {
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
                dogview.setImageBitmap(bitmap);
            }catch(Exception ex){

            }
        }

        super.onActivityResult(requestCode, resultCode, data);

    }

    //Method to clear all user inputs
    public void clearControls(){
        petname.setText("");
        petage.setText("");
        petgender.setText("");
        petcol.setText("");
        petloc.setText("");
        pettel.setText("");
        petprice.setText("");
    }
    public void CreateData(View view) {
        dbRef = FirebaseDatabase.getInstance().getReference().child("Pet");

        if (TextUtils.isEmpty(petname.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please enter a name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(petage.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please enter a age", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(petgender.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please enter a price", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(petcol.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please enter a color", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(petloc.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please enter a location", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(pettel.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please enter a tele", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(petprice.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please enter a price", Toast.LENGTH_SHORT).show();
        } else {
            petobj.setName(petname.getText().toString().trim());
            petobj.setAge(petage.getText().toString().trim());
            petobj.setGender(petgender.getText().toString().trim());
            petobj.setColor(petcol.getText().toString().trim());
            petobj.setLocation(petloc.getText().toString().trim());
            petobj.setTele(pettel.getText().toString().trim());
            petobj.setPrice(petprice.getText().toString().trim());

            dbRef.push().setValue(petobj);

            Toast.makeText(getApplicationContext(), "Data inserted successfully!", Toast.LENGTH_SHORT).show();
            clearControls();
        }
    }

        private void uploadtofirebase(){
            ProgressDialog dialog=new ProgressDialog(this);
            dialog.setTitle("File Uploader");
            dialog.show();

            FirebaseStorage storage=FirebaseStorage.getInstance();
            StorageReference uploader=storage.getReference().child("imagepet");
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
