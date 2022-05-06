package com.example.remotecoders;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminActivityAddVet extends AppCompatActivity {

    EditText edit_vetname, edit_vetlocation, edit_vetbio, edit_vetphone, edit_vetaddress, edit_vetoffice;
    Button btn_vetadd;
    VetAds vetobj;//reference for VetAds class
    DatabaseReference dbRef;//database reference

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_vet);

        edit_vetname=findViewById(R.id.et_vetname);
        edit_vetlocation=findViewById(R.id.et_vetlocation);
        edit_vetbio=findViewById(R.id.et_vetbio);
        edit_vetphone=findViewById(R.id.et_vetphone);
        edit_vetaddress=findViewById(R.id.et_vetaddress);
        edit_vetoffice=findViewById(R.id.et_vetoffice);
        btn_vetadd=findViewById(R.id.btn_vetadd);

        vetobj=new VetAds();
    }

    //Method to clear all user inputs
    public void clearControls(){
        edit_vetname.setText("");
        edit_vetlocation.setText("");
        edit_vetbio.setText("");
        edit_vetphone.setText("");
        edit_vetaddress.setText("");
        edit_vetoffice.setText("");

    }
    public void CreateVetAds(View view){
        dbRef = FirebaseDatabase.getInstance().getReference().child("VetAds");

        if(TextUtils.isEmpty(edit_vetname.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please enter a name",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(edit_vetlocation.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please enter a location",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(edit_vetbio.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please enter a bio",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(edit_vetphone.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please enter a phone",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(edit_vetaddress.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please enter a address",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(edit_vetoffice.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please enter a office",Toast.LENGTH_SHORT).show();
        }else{

            vetobj.setName(edit_vetname.getText().toString().trim());
            vetobj.setLocation(edit_vetlocation.getText().toString().trim());
            vetobj.setBio(edit_vetbio.getText().toString().trim());
            vetobj.setPhone(Integer.parseInt(edit_vetphone.getText().toString().trim()));
            vetobj.setAddress(edit_vetaddress.getText().toString().trim());
            vetobj.setOffice(edit_vetoffice.getText().toString().trim());
            System.out.println(vetobj.getBio());
            System.out.println(vetobj.getOffice());

            dbRef.push().setValue(vetobj);

            Toast.makeText(getApplicationContext(),"Data inserted successfully!",Toast.LENGTH_SHORT).show();
            clearControls();
        }
    }
}