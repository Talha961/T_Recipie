package com.irap.T_Recipies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.irap.T_Recipies.R;

public class Dash_board extends AppCompatActivity  {
    ImageView biryani;
    TextView biryanii;
    FirebaseAuth Listener;
    private FirebaseAuth.AuthStateListener AuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        biryani = findViewById(R.id.biryani_click);
        biryanii = findViewById(R.id.biryani);
        biryani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dash_board.this, Recipie.class);
                startActivity(i);

            }
        });
        biryanii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dash_board.this, Recipie.class);
                startActivity(i);

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_drawer, menu);
        return true;
    }
    @Override
    public  boolean  onOptionsItemSelected (@NonNull MenuItem item)
    {
        int id = item.getItemId();
        switch (id) {
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(Dash_board.this,Login.class);
                startActivity(intent);
            case R.id.share:
                Toast.makeText(getApplicationContext(), "share", Toast.LENGTH_SHORT).show();

            default:
                break;
        }
        return true;
    }

}
