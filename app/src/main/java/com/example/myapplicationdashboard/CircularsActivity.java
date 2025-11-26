package com.example.myapplicationdashboard;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class CircularsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulars); // Set correct layout

        // Handle top app bar back button
        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);
        topAppBar.setTitle("Circulars");
        topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Navigate back when arrow is clicked
            }
        });
    }
}
