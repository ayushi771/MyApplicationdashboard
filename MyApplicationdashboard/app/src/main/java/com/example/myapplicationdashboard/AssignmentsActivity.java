package com.example.myapplicationdashboard;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

public class AssignmentsActivity extends AppCompatActivity {

    private CheckBox checkboxDone;
    private Button btnAttachFile;

    // For file picker intent
    ActivityResultLauncher<Intent> filePickerLauncher;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);

        // Top App Bar
        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);
        topAppBar.setTitle("Assignment");
        topAppBar.setNavigationOnClickListener(v -> onBackPressed());

        // Initialize views
        checkboxDone = findViewById(R.id.checkboxDone);
        btnAttachFile = findViewById(R.id.btnAttachFile);

        // Checkbox listener
        checkboxDone.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(this, "Marked as done!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Marked as not done!", Toast.LENGTH_SHORT).show();
            }
        });

        // Register file picker launcher
        filePickerLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Uri fileUri = result.getData().getData();
                        Toast.makeText(this, "File attached: " + fileUri.getLastPathSegment(), Toast.LENGTH_SHORT).show();
                        // You can store/use fileUri further here
                    }
                });

        // Button click to open file picker
        btnAttachFile.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            filePickerLauncher.launch(Intent.createChooser(intent, "Select a file"));
        });
    }
}
