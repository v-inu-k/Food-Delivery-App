package com.example.fakeubereats.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.fakeubereats.Fragments.LoginFragment;
import com.example.fakeubereats.R;
import com.example.fakeubereats.Fragments.RegisterFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserActivity extends AppCompatActivity {

    BottomNavigationView NavigationView;
    Fragment fragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        NavigationView = findViewById(R.id.BottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new LoginFragment()).commit();
        NavigationView.setSelectedItemId(R.id.nav_Login);

        NavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_Login:
                        selectedFragment = new LoginFragment();
                        break;
                    case R.id.nav_Register:
                        selectedFragment = new RegisterFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, selectedFragment).commit();
                return true;
            }
        });
    }
}