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
import com.irap.T_Recipies.R;

public class Sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final Button Register;
        final EditText Email,Password,Name,Phone;
        final FirebaseAuth UserAuth;
        UserAuth=FirebaseAuth.getInstance();
        Email=findViewById(R.id.Email);
        Name=findViewById(R.id.Name);
        Phone=findViewById(R.id.Phone);
        Password=findViewById(R.id.Password);
        Register=findViewById(R.id.Register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Em=Email.getText().toString();
                String ps=Password.getText().toString();
                String name=Name.getText().toString();
                String phone=Phone.getText().toString();
                if (name.isEmpty())
                {
                    Name.setError("Please Enter Your Name");
                    Name.requestFocus();
                }
                if (phone.isEmpty())
                {
                    Phone.setError("Please Enter Phone Number");
                    Phone.requestFocus();
                }
                if (Em.isEmpty())
                {
                    Email.setError("Please Enter Email");
                    Email.requestFocus();
                }

                else if (ps.isEmpty())
                {

                    Password.setError("Please Enter password");
                    Password.requestFocus();
                }
                else if (Em.isEmpty()&&ps.isEmpty()&&name.isEmpty()&&phone.isEmpty())
                {
                    Toast.makeText(Sign_up.this, "Please Enter Required Fields", Toast.LENGTH_SHORT).show();
                }
                else if(!(Em.isEmpty()&&ps.isEmpty()&&name.isEmpty()&&phone.isEmpty()))
                {
                    UserAuth.createUserWithEmailAndPassword(Em,ps).addOnCompleteListener(Sign_up.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful())
                            {
                                Toast.makeText(Sign_up.this, "SingUp Error Try Again", Toast.LENGTH_SHORT).show();

                            }
                            else
                            {
                                Toast.makeText(Sign_up.this, "Singup Successful", Toast.LENGTH_SHORT).show();

                                Intent i=new Intent(Sign_up.this,Dash_board.class);
                                startActivity(i);
                                finish();
                            }

                        }
                    });
                }

            }
        });

    }
}
