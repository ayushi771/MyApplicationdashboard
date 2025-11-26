package com.example.myapplicationdashboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LanguageSelectionActivity extends AppCompatActivity {

    Button btnEnglish, btnHindi, btnGujarati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);

        btnEnglish = findViewById(R.id.btnEnglish);
        btnHindi = findViewById(R.id.btnHindi);
        btnGujarati = findViewById(R.id.btnGujarati);

        btnEnglish.setOnClickListener(v -> changeLanguage("en"));
        btnHindi.setOnClickListener(v -> changeLanguage("hi"));
        btnGujarati.setOnClickListener(v -> changeLanguage("gu"));
    }

    private void changeLanguage(String langCode) {
        LocaleHelper.setLocale(LanguageSelectionActivity.this, langCode);
        Intent intent = new Intent(LanguageSelectionActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
