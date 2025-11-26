package com.example.myapplicationdashboard;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class NotificationSettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_settings);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(v -> finish());

        // Initialize switches
        SwitchMaterial switchNotifications = findViewById(R.id.switch_notifications);
        SwitchMaterial switchVibration = findViewById(R.id.switch_vibration);
        SwitchMaterial switchSound = findViewById(R.id.switch_sound);
        SwitchMaterial switchDailyReminder = findViewById(R.id.switch_daily_reminder);

        // Example: Add listeners
        switchNotifications.setOnCheckedChangeListener((buttonView, isChecked) ->
                Toast.makeText(this, "Notifications " + (isChecked ? "enabled" : "disabled"), Toast.LENGTH_SHORT).show()
        );

        switchVibration.setOnCheckedChangeListener((buttonView, isChecked) ->
                Toast.makeText(this, "Vibration " + (isChecked ? "on" : "off"), Toast.LENGTH_SHORT).show()
        );

        switchSound.setOnCheckedChangeListener((buttonView, isChecked) ->
                Toast.makeText(this, "Sound " + (isChecked ? "on" : "off"), Toast.LENGTH_SHORT).show()
        );

        switchDailyReminder.setOnCheckedChangeListener((buttonView, isChecked) ->
                Toast.makeText(this, "Daily Reminder " + (isChecked ? "enabled" : "disabled"), Toast.LENGTH_SHORT).show()
        );
    }
}
