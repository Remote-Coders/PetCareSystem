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

public class MainActivity5 extends AppCompatActivity {

    EditText edit_category,edit_name,edit_price,edit_description;
    Button btn_add;
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
        btn_add=findViewById(R.id.btn_add);

        foodobj=new Food();

    }

    //Method to clear all user inputs
    public void clearControls(){
        edit_category.setText("");
        edit_name.setText("");
        edit_price.setText("");
        edit_description.setText("");
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
        }else{
            foodobj.setCategory(edit_category.getText().toString().trim());
            foodobj.setName(edit_name.getText().toString().trim());
            foodobj.setPrice(edit_price.getText().toString().trim());
            foodobj.setDescription(edit_description.getText().toString().trim());

            dbRef.push().setValue(foodobj);

            Toast.makeText(getApplicationContext(),"Data inserted successfully!",Toast.LENGTH_SHORT).show();
            clearControls();
        }
    }
}