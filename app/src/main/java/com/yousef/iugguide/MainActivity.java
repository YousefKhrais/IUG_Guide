package com.yousef.iugguide;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yousef.iugguide.databinding.ActivityMainBinding;
import com.yousef.iugguide.models.College;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_guide, R.id.navigation_buildings, R.id.navigation_colleges)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        try {
            Context context = this;
            InputStream inputStream = context.getResources().openRawResource(R.raw.col);
            String jsonString = new Scanner(inputStream).useDelimiter("\\A").next();

//            List<String> items = new ArrayList<>();
            JSONObject root = new JSONObject(jsonString);
            System.out.println("okokoko");
//            System.out.println(root.toString());            System.out.println("okokoko");

            JSONArray array = root.getJSONArray("Sheet1");

//            this.setTitle(root.getString("title"));

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                College college = new College();
                college.setId(i);
                college.setStudentsCount(object.getInt("num_of_student"));
                college.setLocation(object.getString("location"));
                college.setImageUrl(object.getString("image"));
                college.setFacebookPageLink(object.getString("facebookLink"));
                college.setDescription(object.getString("basic_info"));
                college.setName(object.getString("name"));


                System.out.println(college.toString());
//                items.add(object.getString("company"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}