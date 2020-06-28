package com.irap.T_Recipies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.irap.T_Recipies.R;

public class SignIn extends AppCompatActivity {
    private  FirebaseAuth.AuthStateListener AuthListener;
    final FirebaseAuth Auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        AuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser User = Auth.getCurrentUser();
                if (User != null) {
                    Toast.makeText(SignIn.this, "You are Logged In", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignIn.this,Dash_board.class);
                    startActivity(i);
                    finish();

                } else {
                    Toast.makeText(SignIn.this, "Please Login", Toast.LENGTH_SHORT).show();

                }
            }
        };
        final Button SignIn;
        final EditText Email, Password;
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        SignIn = findViewById(R.id.signin);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Em = Email.getText().toString();
                String ps = Password.getText().toString();
                if (Em.isEmpty()) {
                    Email.setError("Please Enter Email");
                    Email.requestFocus();
                } else if (ps.isEmpty()) {

                    Password.setError("Please Enter Email");
                    Password.requestFocus();
                } else if (Em.isEmpty() && ps.isEmpty()) {
                    Toast.makeText(SignIn.this, "Please Enter Required Fields", Toast.LENGTH_SHORT).show();
                } else if (!(Em.isEmpty() && ps.isEmpty())) {
                    Auth.signInWithEmailAndPassword(Em, ps).addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignIn.this, "SignIn Error", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(SignIn.this, "SignIn Successful", Toast.LENGTH_SHORT).show();

                                Intent i = new Intent(SignIn.this, Dash_board.class);
                            }

                        }
                    });
                }

            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
        Auth.addAuthStateListener(AuthListener);

    }
}