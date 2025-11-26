package com.example.myapplicationdashboard;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.appbar.MaterialToolbar;

public class SettingsActivity extends AppCompatActivity {

    private boolean isDarkMode = false; // Toggle flag

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(view -> finish());

        // Get layout references
        LinearLayout changeThemeOption = findViewById(R.id.changeThemeOption);
        LinearLayout notificationSettingsOption = findViewById(R.id.notificationSettingsOption);

        // Change Theme Click
        changeThemeOption.setOnClickListener(view -> {
            isDarkMode = !isDarkMode;
            AppCompatDelegate.setDefaultNightMode(
                    isDarkMode ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO
            );
            Toast.makeText(this, "Theme changed", Toast.LENGTH_SHORT).show();
        });

        notificationSettingsOption.setOnClickListener(view -> {
            Intent intent = new Intent(SettingsActivity.this, NotificationSettingsActivity.class);
            startActivity(intent);
        });

    }
}
