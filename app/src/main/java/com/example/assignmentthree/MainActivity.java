package com.example.assignmentthree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.assignmentthree.FragmentStudent.AboutFragment;
import com.example.assignmentthree.FragmentStudent.AddStdFragment;
import com.example.assignmentthree.FragmentStudent.HomeFragment;
import com.example.assignmentthree.Model.Student;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<Student> studentsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListner);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();


        studentsList = new ArrayList<>();
        studentsList.add(new Student("Milan","Bhaktapur","Male",23,R.drawable.boy));
        studentsList.add(new Student ("Sita","Kathmandu","Female",18,R.drawable.girl));
        studentsList.add(new Student ("james","Kathmandu","other",20,R.drawable.other));


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectFragment = null;
                    switch (item.getItemId()){

                        case R.id.nav_home:
                            selectFragment = new HomeFragment();
                            break;
                        case R.id.nav_add:
                            selectFragment = new AddStdFragment();
                            break;
                        case R.id.nav_about:
                            selectFragment = new AboutFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectFragment).commit();
                    return true;
                }
            };
}
