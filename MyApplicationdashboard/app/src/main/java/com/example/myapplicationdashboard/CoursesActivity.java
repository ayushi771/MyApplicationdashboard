package com.example.myapplicationdashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class CoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);
        topAppBar.setTitle("Courses");
        topAppBar.setNavigationOnClickListener(v -> onBackPressed());

        // Set up click listeners
        Button csButton = findViewById(R.id.btnViewDetailsCS);
        Button mathButton = findViewById(R.id.btnViewDetailsMath);

        csButton.setOnClickListener(view -> {
            Intent intent = new Intent(CoursesActivity.this, ComputerScienceActivity.class);
            startActivity(intent);
        });

        mathButton.setOnClickListener(view -> {
            Intent intent = new Intent(CoursesActivity.this, MathematicsActivity.class);
            startActivity(intent);
        });
    }
}


