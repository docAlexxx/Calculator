package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;

public class ThemeChooseActivity extends AppCompatActivity {

    private MaterialButton dayThemeSet;
    private MaterialButton nightThemeSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_choose);

        initButtons();
        setupButtons();
    }

    private void initButtons() {
        dayThemeSet = findViewById(R.id.day_theme_choose_button);
        nightThemeSet = findViewById(R.id.night_theme_choose_button);
    }

    private void setupButtons() {
        dayThemeSet.setOnClickListener(v -> {

            finish();
        });

        nightThemeSet.setOnClickListener(v -> {

            finish();
        });
    }
}