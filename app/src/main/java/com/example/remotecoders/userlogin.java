package com.example.remotecoders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class userlogin extends AppCompatActivity {


    EditText user2,password2;
    RelativeLayout login2;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);

        user2 = findViewById(R.id.useer2);
        password2 = findViewById(R.id.password2);
        login2=findViewById(R.id.login2);

        mAuth=FirebaseAuth.getInstance();



        login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateFields();
                logUser();

            }
        });

        }

    private void logUser() {
        Intent intent = new Intent(userlogin.this,userprofile.class);
        startActivity(intent);
    }

    private void validateFields() {
        String username,password;
        username=user2.getText().toString();
        password=password2.getText().toString();

        //validation
        logUser(username,password);
    }

    private void logUser(String username, String password) {
        mAuth.signInWithEmailAndPassword(username,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                logUser();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }

}
