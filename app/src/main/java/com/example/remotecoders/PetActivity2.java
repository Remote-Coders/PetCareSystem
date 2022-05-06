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


public class PetActivity2 extends AppCompatActivity {

    EditText petname,petage,petgender,petcol,petloc,pettel,petprice;
    Button addbtn;
    Pet petobj;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet2);

        petname=findViewById(R.id.petname);
        petage=findViewById(R.id.petage);
        petgender=findViewById(R.id.petgender);
        petcol=findViewById(R.id.petcol);
        petloc=findViewById(R.id.petloc);
        pettel=findViewById(R.id.pettel);
        petprice=findViewById(R.id.petprice);
        addbtn=findViewById(R.id.addbtn);
        petobj=new Pet();

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
    public void CreateData(View view){
        dbRef = FirebaseDatabase.getInstance().getReference().child("Pet");

        if(TextUtils.isEmpty(petname.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please enter a name",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(petage.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please enter a age",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(petgender.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please enter a price",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(petcol.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please enter a color",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(petloc.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please enter a location",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(pettel.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please enter a tele",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(petprice.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please enter a price",Toast.LENGTH_SHORT).show();
        }else{
            petobj.setName(petname.getText().toString().trim());
            petobj.setAge(petage.getText().toString().trim());
            petobj.setGender(petgender.getText().toString().trim());
            petobj.setColor(petcol.getText().toString().trim());
            petobj.setLocation(petloc.getText().toString().trim());
            petobj.setTele(pettel.getText().toString().trim());
            petobj.setPrice(petprice.getText().toString().trim());

            dbRef.push().setValue(petobj);

            Toast.makeText(getApplicationContext(),"Data inserted successfully!",Toast.LENGTH_SHORT).show();
            clearControls();
        }
    }
}