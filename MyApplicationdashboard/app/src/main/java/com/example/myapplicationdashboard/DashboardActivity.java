package com.example.myapplicationdashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private DashboardAdapter dashboardAdapter;
    private List<DashboardItem> dashboardItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure this layout file exists

        // Set up top app bar
        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(toolbar);

        // Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        // Dashboard items
        dashboardItems = new ArrayList<>();
        dashboardItems.add(new DashboardItem("My Courses", R.drawable.img_1, "#D32F2F"));
        dashboardItems.add(new DashboardItem("Attendance", R.drawable.img_2, "#FBC02D"));
        dashboardItems.add(new DashboardItem("Fees", R.drawable.img_3, "#303F9F"));
        dashboardItems.add(new DashboardItem("Assignments", R.drawable.img_4, "#D32F2F"));
        dashboardItems.add(new DashboardItem("Event", R.drawable.img_5, "#303F9F"));
        dashboardItems.add(new DashboardItem("Timetable", R.drawable.img_6, "#FBC02D"));
        dashboardItems.add(new DashboardItem("Circulars", R.drawable.img_7, "#29B6F6"));

        dashboardAdapter = new DashboardAdapter(this, dashboardItems, item -> {
            String title = item.getTitle();

            if (title.equals("My Courses")) {
                startActivity(new Intent(this, CoursesActivity.class));
            } else if (title.equals("Attendance")) {
                startActivity(new Intent(this, AttendanceActivity.class));
            } else if (title.equals("Fees")) {
                startActivity(new Intent(this, FeesActivity.class));
            } else if (title.equals("Assignments")) {
                startActivity(new Intent(this, AssignmentsActivity.class));
            } else if (title.equals("Event")) {
                startActivity(new Intent(this, EventsActivity.class));
            } else if (title.equals("Timetable")) {
                startActivity(new Intent(this, TimetableActivity.class));
            } else if (title.equals("Circulars")) {
                startActivity(new Intent(this, CircularsActivity.class));
            } else {
                Toast.makeText(this, "Feature not available!", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(dashboardAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.menu_profile) {
            Toast.makeText(this, "Profile selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.menu_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        } else if (itemId == R.id.menu_logout) {
            Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
