package com.example.firebaselogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText edt1, edt2, edt3;
    Button txt;
    private String emailid, password, username;

    private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edt1 = findViewById(R.id.name);
        edt2 = findViewById(R.id.email);
        edt3 = findViewById(R.id.password);
        txt = findViewById(R.id.register);

        mauth = FirebaseAuth.getInstance();
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateuser();
            }
        });
    }

//    To check whether user exist or not
    @Override
    protected void onStart() {
        super.onStart();
        if(mauth.getCurrentUser() != null){      //like fb start, already logged in if logged in previously
            startActivity(new Intent(this,Login.class));
            finish();
        }
    }
    private void validateuser(){
        username=edt1.getText().toString();
        emailid=edt2.getText().toString();
        password=edt3.getText().toString();

        if(username.isEmpty()||password.isEmpty()||emailid.isEmpty()){
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }
        else
            registerUser();
    }
    private void registerUser(){
        mauth.createUserWithEmailAndPassword(emailid,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {    //signinUserWithEmailAndPassword for login
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Register.this, "User have registered", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Register.this,Login.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(Register.this, "Failed to registered. Try again", Toast.LENGTH_SHORT).show();
            }
        });
    }
}