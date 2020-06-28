package com.irap.T_Recipies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.irap.T_Recipies.R;


public class Login extends AppCompatActivity {

    Button login,register;
    private  FirebaseAuth.AuthStateListener AuthListener;
    final FirebaseAuth Auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        AuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser User = Auth.getCurrentUser();
                if (User != null) {
                    Toast.makeText(Login.this, "You are Logged In", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this,Dash_board.class);
                    startActivity(i);
                    finish();

                } else {
                    Toast.makeText(Login.this, "Please Login Or SignUp", Toast.LENGTH_SHORT).show();

                }
            }
        };

        register=findViewById(R.id.register);
        login=findViewById(R.id.login);
         register.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i= new Intent(Login.this,Sign_up.class);
                 startActivity(i);

             }
         });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Login.this,SignIn.class);
                startActivity(i);

            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        Auth.addAuthStateListener(AuthListener);

    }

}
