package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.button.MaterialButton;

public class ThemeChooseActivity extends AppCompatActivity {

    private MaterialButton dayThemeSet;
    private MaterialButton nightThemeSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_choose);

        initElements();
        setupButtons();
    }

    private void setupButtons() {
        dayThemeSet = findViewById(R.id.day_theme_choose_button);
        nightThemeSet = findViewById(R.id.night_theme_choose_button);
    }

    private void initElements() {
        dayThemeSet.setOnClickListener(v -> {

            finish();
        });
    }
}