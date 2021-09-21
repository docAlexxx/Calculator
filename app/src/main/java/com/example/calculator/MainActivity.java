package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText numbersEditText;
    private EditText actionEditText;
    private AppCompatImageView number0Button;
    private AppCompatImageView number1Button;
    private AppCompatImageView number2Button;
    private AppCompatImageView number3Button;
    private AppCompatImageView number4Button;
    private AppCompatImageView number5Button;
    private AppCompatImageView number6Button;
    private AppCompatImageView number7Button;
    private AppCompatImageView number8Button;
    private AppCompatImageView number9Button;
    private Button plusButton;
    private Button minusButton;
    private Button multiplyButton;
    private Button devideButton;
    private Button dotButton;
    private Button plusMinusChangeButton;
    private Button resultButton;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calculator calculator= new Calculator();
        initElements();
        setupButtons();

    }

    private void initElements() {
        numbersEditText = findViewById(R.id.numbers_edit_text);
        actionEditText = findViewById(R.id.action_edit_text);
        number0Button = findViewById(R.id.number0_button);
        number1Button = findViewById(R.id.number1_button);
        number2Button = findViewById(R.id.number2_button);
        number3Button = findViewById(R.id.number3_button);
        number4Button = findViewById(R.id.number4_button);
        number5Button = findViewById(R.id.number5_button);
        number6Button = findViewById(R.id.number6_button);
        number7Button = findViewById(R.id.number7_button);
        number8Button = findViewById(R.id.number8_button);
        number9Button = findViewById(R.id.number9_button);
        plusButton = findViewById(R.id.plus_button);
        minusButton = findViewById(R.id.minus_button);
        multiplyButton = findViewById(R.id.minus_button);
        devideButton = findViewById(R.id.devide_button);
        dotButton = findViewById(R.id.dot_button);
        plusMinusChangeButton = findViewById(R.id.plus_minus_change_button);
        resultButton = findViewById(R.id.result_button);
    }

    private void setupButtons() {
        plusButton.setOnClickListener(v->{

        });
        minusButton.setOnClickListener(v->{

        });
        multiplyButton.setOnClickListener(v->{

        });
        devideButton.setOnClickListener(v->{

        });
        dotButton.setOnClickListener(v->{

        });
        plusMinusChangeButton.setOnClickListener(v->{

        });
        resultButton.setOnClickListener(v->{

        });
        number0Button.setOnClickListener(v->{

        });
        number1Button.setOnClickListener(v->{

        });
        number2Button.setOnClickListener(v->{

        });
        number3Button.setOnClickListener(v->{

        });
        number4Button.setOnClickListener(v->{

        });
        number5Button.setOnClickListener(v->{

        });
        number6Button.setOnClickListener(v->{

        });
        number7Button.setOnClickListener(v->{

        });
        number8Button.setOnClickListener(v->{

        });
        number9Button.setOnClickListener(v->{

        });
    }

}