package com.example.myapplicationdashboard;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class EventsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events); // Changed to the correct layout

        // Set up back button on the top app bar
        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);
        topAppBar.setTitle("Events");
        topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Handle back press
            }
        });
    }
}
