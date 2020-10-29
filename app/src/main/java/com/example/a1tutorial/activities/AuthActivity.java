package com.example.a1tutorial.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a1tutorial.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AuthActivity extends AppCompatActivity {

    Button signUpButton, loginButton;
    TextView txtEmail, txtContraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        //Analytics event
        FirebaseAnalytics analitytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();

        bundle.putString("message", "Integracion de Firebase Completa");
        analitytics.logEvent("InitScreen", bundle);


        signUpButton = findViewById(R.id.registerBtn);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(AuthActivity.this, RegisterActivity.class);
                startActivity(intento);
            }
        });

        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        txtEmail = findViewById(R.id.registerEmail);
        txtContraseña = findViewById(R.id.registerPassword);
    }

    private void login() {
        String email = txtEmail.getText().toString();
        String pass = txtContraseña.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    System.out.println("registrado");
                }

            }
        });

    }



}
