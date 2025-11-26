package com.example.myapplicationdashboard;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText fullName, email, password, confirmPassword;
    Button registerButton, backToLoginButton;

    DatabaseHelper dbHelper; // 🔌 Database helper

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        fullName = findViewById(R.id.fullName);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        registerButton = findViewById(R.id.registerButton);
        backToLoginButton = findViewById(R.id.backToLoginButton);

        dbHelper = new DatabaseHelper(this); // ✅ Initialize database helper

        registerButton.setOnClickListener(v -> {
            String name = fullName.getText().toString().trim();
            String emailInput = email.getText().toString().trim();
            String pass = password.getText().toString().trim();
            String confirmPass = confirmPassword.getText().toString().trim();

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(emailInput) ||
                    TextUtils.isEmpty(pass) || TextUtils.isEmpty(confirmPass)) {

                Toast.makeText(this, getString(R.string.error_fill_fields), Toast.LENGTH_SHORT).show();

            } else if (!pass.equals(confirmPass)) {
                Toast.makeText(this, getString(R.string.error_password_mismatch), Toast.LENGTH_SHORT).show();

            } else {
                boolean inserted = dbHelper.insertUser(name, emailInput, pass);
                if (inserted) {
                    Toast.makeText(this, getString(R.string.registration_success), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, LoginActivity.class));
                    finish();
                } else {
                    Toast.makeText(this, getString(R.string.email_exists), Toast.LENGTH_SHORT).show();
                }
            }
        });

        backToLoginButton.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}

