package com.example.tourapp2.ui;

import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.tourapp2.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // To enable window content transitions
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            // set an exit transition
            getWindow().setExitTransition(new Explode());
        }
        setContentView(R.layout.activity_main);
        //reference to drawer layout
        drawer = findViewById(R.id.drawerLayout);
        //reference to nav view
        NavigationView navigationView = findViewById(R.id.navView);
        //reference to nav controller
        navController = Navigation.findNavController(this, R.id.MyNavHostFragment);
        //reference to toolBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        //set toolbar as default action bar
        setSupportActionBar(toolbar);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.placesFragment, R.id.hotelsFragment, R.id.restaurantsFragment,R.id.beachesFragment)
                .setDrawerLayout(drawer)
                .build();
        //setup the drawer layout and its configuration with the action bar
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        //set up the nav view with nave controller
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    //to provide up button when we are not in top level destination
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
