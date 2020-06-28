package com.irap.T_Recipies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.irap.T_Recipies.R;

public class Recipie extends AppCompatActivity  {

    ImageView main;
    TabLayout tabLayout;
    ViewPager pager;
    TabItem descrp, inger, direc;
    PagerAdapter adapter;
    FirebaseAuth USERAUTH;
    FirebaseAuth.AuthStateListener AuthListener;
    DrawerLayout mdrawerlayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__recipie2);

        mdrawerlayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        pager = findViewById(R.id.viewpager1);
        tabLayout = findViewById(R.id.tab_layout);
        adapter = new pagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, tabLayout.getTabCount());
        pager.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

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
                Intent intent=new Intent(Recipie.this,Login.class);
                startActivity(intent);
            case R.id.share:
                Toast.makeText(getApplicationContext(), "share", Toast.LENGTH_SHORT).show();

            default:
                break;
        }
        return true;
    }

}

