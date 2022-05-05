package com.example.remotecoders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Register extends AppCompatActivity {


    EditText userName,email,pwUser,newPw,mobile;
    RelativeLayout register;
    private String EmailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    FirebaseAuth mAuth;
    FirebaseFirestore fstore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        userName = findViewById(R.id.userName);
        email = findViewById(R.id.email);
        pwUser = findViewById(R.id.pwUser);
        newPw = findViewById(R.id.newPw);
        mobile = findViewById(R.id.mobile);
        register = findViewById(R.id.register);

        mAuth = FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                validateFields();
                LogUser();
            }
        });

    }

    private void LogUser() {
        Intent intent = new Intent(Register.this,userlogin.class);
        startActivity(intent);

    }

    private void validateFields() {

        String username,emailUser,password,nPassword,mobileUser;
        username=userName.getText().toString();
        emailUser=email.getText().toString();
        password=pwUser.getText().toString();
        nPassword=newPw.getText().toString();
        mobileUser=mobile.getText().toString();


        if(!(username.isEmpty())){

            if(!(emailUser.isEmpty())){
                if(!(password.isEmpty())){
                    if (!(nPassword.isEmpty())){
                        if(!(mobileUser.isEmpty())){


                            if(emailUser.matches(EmailPattern)){

                                String passwordPattern = "[a-zA-Z0-9\\\\!\\\\@\\\\#\\\\$]{8,24}";
                                if(password.matches(passwordPattern)){
                                    if (nPassword.matches(passwordPattern)){

                                        LogUser();
                                        Toast.makeText(Register.this,"Hello User " + username,Toast.LENGTH_SHORT).show();
                                    }else{
                                        newPw.setError("password length should 8-24");
                                    }


                                }else{
                                    pwUser.setError("password length should 8-24");
                                }
                            }else{
                                email.setError("Invalid Email");
                            }

                        }else{
                            mobile.setError("Please fill this");
                        }

                    }else{
                        newPw.setError("Please fill this");
                    }

                }else{
                    pwUser.setError("Please fill this");
                }

            }else{
                email.setError("Plase fill this");
            }

        }else{
            userName.setError("Please fill this");
        }

        RegisterUser(username,emailUser,password,mobileUser);



//        Toast.makeText(MainActivity.this,"Hello User " + username,Toast.LENGTH_SHORT).show();
    }

    private void RegisterUser(String username, String emailUser, String password, String mobileUser) {

        mAuth.createUserWithEmailAndPassword(emailUser,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //success
                if(task.isSuccessful()){

                    //save user in the firestore
                }else{

                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                //not success
            }
        });
    }

}