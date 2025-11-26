package com.example.myapplicationdashboard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button loginButton;
    TextView registerLink;
    Spinner languageSpinner;

    DatabaseHelper dbHelper; // Database helper instance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale(); // Load saved language before setting layout
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        registerLink = findViewById(R.id.registerLink);
        languageSpinner = findViewById(R.id.languageSpinner);

        dbHelper = new DatabaseHelper(this); // Initialize DB helper

        // Language spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);
        languageSpinner.setSelection(getSavedLanguagePosition());

        languageSpinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, android.view.View view, int position, long id) {
                String selectedLang = parent.getItemAtPosition(position).toString();
                String langCode = "en";
                if (selectedLang.equals("हिन्दी")) langCode = "hi";
                else if (selectedLang.equals("ગુજરાતી")) langCode = "gu";
                else if (selectedLang.equals("Español")) langCode = "es";

                if (!getCurrentLanguage().equals(langCode)) {
                    setLocale(langCode);
                    recreate();
                }
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) { }
        });

        // Login button logic
        loginButton.setOnClickListener(v -> {
            String emailInput = email.getText().toString().trim();
            String passwordInput = password.getText().toString().trim();

            if (TextUtils.isEmpty(emailInput) || TextUtils.isEmpty(passwordInput)) {
                Toast.makeText(this, getString(R.string.error_fill_fields), Toast.LENGTH_SHORT).show();
            } else {
                boolean userExists = dbHelper.userExists(emailInput);

                if (!userExists) {
                    Toast.makeText(this, getString(R.string.user_not_found), Toast.LENGTH_SHORT).show();
                } else {
                    boolean valid = dbHelper.checkUser(emailInput, passwordInput);
                    if (valid) {
                        Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                        finish();
                    } else {
                        Toast.makeText(this, getString(R.string.invalid_credentials), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        registerLink.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    private void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("Settings", MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "en");
        setLocale(language);
    }

    private String getCurrentLanguage() {
        return getSharedPreferences("Settings", MODE_PRIVATE).getString("My_Lang", "en");
    }

    private int getSavedLanguagePosition() {
        String lang = getCurrentLanguage();
        if (lang.equals("hi")) return 1;
        if (lang.equals("gu")) return 2;
        if (lang.equals("es")) return 3;
        return 0;
    }
}
