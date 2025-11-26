package com.example.myapplicationdashboard;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class AttendanceActivity extends AppCompatActivity {

    private RecyclerView attendanceRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        // Setup MaterialToolbar
        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(view -> finish());

        // Setup RecyclerView
        attendanceRecyclerView = findViewById(R.id.attendanceRecyclerView);
        attendanceRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample attendance data
        List<AttendanceRecord> attendanceList = new ArrayList<>();
        attendanceList.add(new AttendanceRecord("Mathematics", 42, 8));
        attendanceList.add(new AttendanceRecord("Physics", 38, 12));
        attendanceList.add(new AttendanceRecord("Chemistry", 40, 10));
        attendanceList.add(new AttendanceRecord("English", 45, 5));

        AttendanceAdapter attendanceAdapter = new AttendanceAdapter(attendanceList);
        attendanceRecyclerView.setAdapter(attendanceAdapter);

        // Setup CalendarView
        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
            Toast.makeText(AttendanceActivity.this, "Selected Date: " + selectedDate, Toast.LENGTH_SHORT).show();

            // TODO: Filter records by date (if needed)
        });
    }
}
