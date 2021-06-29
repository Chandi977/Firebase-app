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

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText edt1, edt2, edt3;
    TextView txt;
    private String emailid, password, username;

    private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt1 = findViewById(R.id.username);
        edt2 = findViewById(R.id.mailid);
        edt3 = findViewById(R.id.pwd);
        txt = findViewById(R.id.login);

        mauth = FirebaseAuth.getInstance();

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    @override
    protected void onStart()
    {
        super.onStart();
        if (mauth.getCurrentUser()!=null)
        {
            Intent intent = new Intent(Login.this,MainActivity.class);
            startActivity(intent);
        }
    }
    public void validateUser()
    {
        emailid=edt1.getText().toString();
        password=edt2.getText().toString();
        if (emailid.isEmpty()||password.isEmpty())
        {
            Toast.makeText(Login.this,"Please fill all th fields",Toast.LENGTH_LONG).show();
        }
        else
        {

        }
    }
    public void loginuser()
    {
//        mauth.signInWithEmailAndPassword(emailid,password).addOnCompleteListener< AuthResult >()
    {
//     @Override
//     public void onComplete(@NonNull Task<AuthResult>task)
    }
    }
}