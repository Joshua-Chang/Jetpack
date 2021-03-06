package com.example.navigation;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //手动绑定
//        NavHostFragment navHostFragment = NavHostFragment.create(R.navigation.mobile_navigation);
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.nav_host_fragment,navHostFragment)
//                .setPrimaryNavigationFragment(navHostFragment)
//                .commit();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    //手动添加
//    @Override
//    public boolean onSupportNavigateUp() {
//        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.navigation_dashboard);
//        return NavHostFragment.findNavController(fragment).navigateUp();
//    }
}
