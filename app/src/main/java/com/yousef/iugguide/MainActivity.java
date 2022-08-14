package com.yousef.iugguide;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yousef.iugguide.databinding.ActivityMainBinding;
import com.yousef.iugguide.helpers.DataHelper;
import com.yousef.iugguide.models.Building;
import com.yousef.iugguide.models.College;
import com.yousef.iugguide.models.Department;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    public static ArrayList<Department> departmentsArrayList;
    public static ArrayList<College> collegesArrayList;
    public static ArrayList<Building> buildingArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_guide, R.id.navigation_buildings, R.id.navigation_colleges)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        DataHelper.getInstance().readCollegesData(this);
        DataHelper.getInstance().readDepartmentsData(this);
        DataHelper.getInstance().readBuildingsData(this);
    }
}