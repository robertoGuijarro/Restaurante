package com.example.a1tutorial.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1tutorial.R;
import com.example.a1tutorial.models.Users;
import com.example.a1tutorial.providers.AuthProvider;
import com.example.a1tutorial.providers.UserDatabaseProvider;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {

    TextView txtEmail, txtPassword, txtName;
    Spinner spinnerOficio;
    Button btnResgistrar;
    private UserDatabaseProvider mUserProvider;
    private Users user;
    String idUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mUserProvider = new UserDatabaseProvider();
        user = new Users();
        
        txtEmail = findViewById(R.id.registerEmail);
        txtPassword = findViewById(R.id.registerPassword);
        txtName = findViewById(R.id.resgisterName);
        
        spinnerOficio = findViewById(R.id.registerOficio);
        
        btnResgistrar = findViewById(R.id.registerBtn);
        btnResgistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearUsuario();
            }
        });
        
    }

    private void crearUsuario() {
        final String name = txtName.getText().toString();
        final String pass = txtPassword.getText().toString();
        final String email = txtEmail.getText().toString();
        final String oficio = spinnerOficio.getSelectedItem().toString();

        final Users userAuth = new Users(email, pass);


        final AuthProvider authFirebase = new AuthProvider();
        authFirebase.getAuth().createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "se ha registrado correctamente ", Toast.LENGTH_SHORT).show();
                    idUser = task.getResult().getUser().getUid();
                    Users userNew = new Users(name, email, oficio, pass);

                    mUserProvider.getMyRef().child(idUser).setValue(userNew);

                    userNew.setId(idUser);

                    Intent intento = new Intent(RegisterActivity.this, HomeActivity.class);
                    intento.putExtra("user", userNew);

                    startActivity(intento);
                }else{
                    Toast.makeText(RegisterActivity.this, "No se ha registrado correctamente ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}

/*
        mUserProvider.getMyRef().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                txtEmail.setText(snapshot.child(idUser).child("name").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/