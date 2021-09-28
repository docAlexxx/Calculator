package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private EditText numbersEditText;
    private EditText actionEditText;
    private MaterialButton number0Button;
    private MaterialButton number1Button;
    private MaterialButton number2Button;
    private MaterialButton number3Button;
    private MaterialButton number4Button;
    private MaterialButton number5Button;
    private MaterialButton number6Button;
    private MaterialButton number7Button;
    private MaterialButton number8Button;
    private MaterialButton number9Button;
    private MaterialButton plusButton;
    private MaterialButton minusButton;
    private MaterialButton multiplyButton;
    private MaterialButton devideButton;
    private MaterialButton dotButton;
    private MaterialButton plusMinusChangeButton;
    private MaterialButton resultButton;
    private MaterialButton deleteButton;
    private MaterialButton resetButton;
    Calculator calculator = new Calculator();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initElements();
        setupButtons();

    }

    private void initElements() {
        numbersEditText = findViewById(R.id.numbers_edit_text);
        actionEditText = findViewById(R.id.action_edit_text);
        number0Button = findViewById(R.id.number_zero_button);
        number1Button = findViewById(R.id.number_one_button);
        number2Button = findViewById(R.id.number_two_button);
        number3Button = findViewById(R.id.number_three_button);
        number4Button = findViewById(R.id.number_four_button);
        number5Button = findViewById(R.id.number_five_button);
        number6Button = findViewById(R.id.number_six_button);
        number7Button = findViewById(R.id.number_seven_button);
        number8Button = findViewById(R.id.number_eight_button);
        number9Button = findViewById(R.id.number_nine_button);
        plusButton = findViewById(R.id.plus_button);
        minusButton = findViewById(R.id.minus_button);
        multiplyButton = findViewById(R.id.multiply_button);
        devideButton = findViewById(R.id.divide_button);
        dotButton = findViewById(R.id.dot_button);
        plusMinusChangeButton = findViewById(R.id.change_number_sign_button);
        resultButton = findViewById(R.id.result_button);
        deleteButton = findViewById(R.id.delete_button);
        resetButton = findViewById(R.id.reset_button);
    }

    private void setupButtons() {
        resetButton.setOnClickListener(v -> {
            calculator.resetButtonPress();
            currentNumberToScreen();
            actionEditText.setText(calculator.operation);
        });
        deleteButton.setOnClickListener(v -> {
            calculator.deleteButtonPress();
            currentNumberToScreen();
        });
        plusButton.setOnClickListener(v -> {
            calculator.operationType(calculator.operation,"plus",  calculator.currentNumber);
            resulttNumberToScreen();
            actionEditText.setText(calculator.operation);
            calculator.setEnter=false;
        });
        minusButton.setOnClickListener(v -> {
            calculator.operationType(calculator.operation,"minus",  calculator.currentNumber);
            resulttNumberToScreen();
            actionEditText.setText(calculator.operation);
            calculator.setEnter=false;
        });
        multiplyButton.setOnClickListener(v -> {
            calculator.operationType(calculator.operation,"multiply",  calculator.currentNumber);
            resulttNumberToScreen();
            actionEditText.setText(calculator.operation);
            calculator.setEnter=false;
        });
        devideButton.setOnClickListener(v -> {
            calculator.operationType(calculator.operation,"divide",  calculator.currentNumber);
            resulttNumberToScreen();
            actionEditText.setText(calculator.operation);
            calculator.setEnter=false;
        });
        dotButton.setOnClickListener(v -> {
            calculator.dotButton();
            currentNumberToScreen();
        });
        plusMinusChangeButton.setOnClickListener(v -> {
            calculator.changeNumberSignPush();
            currentNumberToScreen();
        });
        resultButton.setOnClickListener(v -> {
            calculator.resultButtonPress();
            resulttNumberToScreen();
            actionEditText.setText(calculator.lastOperation);
        });
        number0Button.setOnClickListener(v -> {
            calculator.numberButtonPress("0");
            currentNumberToScreen();
        });
        number1Button.setOnClickListener(v -> {
            calculator.numberButtonPress("1");
            currentNumberToScreen();
        });
        number2Button.setOnClickListener(v -> {
            calculator.numberButtonPress("2");
            currentNumberToScreen();
        });
        number3Button.setOnClickListener(v -> {
            calculator.numberButtonPress("3");
            currentNumberToScreen();
        });
        number4Button.setOnClickListener(v -> {
            calculator.numberButtonPress("4");
            currentNumberToScreen();
        });
        number5Button.setOnClickListener(v -> {
            calculator.numberButtonPress("5");
            currentNumberToScreen();
        });
        number6Button.setOnClickListener(v -> {
            calculator.numberButtonPress("6");
            currentNumberToScreen();
        });
        number7Button.setOnClickListener(v -> {
            calculator.numberButtonPress("7");
            currentNumberToScreen();
        });
        number8Button.setOnClickListener(v -> {
            calculator.numberButtonPress("8");
            currentNumberToScreen();
        });
        number9Button.setOnClickListener(v -> {
            calculator.numberButtonPress("9");
            currentNumberToScreen();
        });
    }

    public void currentNumberToScreen() {
        if (calculator.isError) {
            numbersEditText.setText("ERROR");
        } else {
            numbersEditText.setText(calculator.currentNumber);
        }
    }

    public void resulttNumberToScreen() {
        if (calculator.isError) {
            numbersEditText.setText("ERROR");
        } else {
            numbersEditText.setText(calculator.resultToScreen);
        }
    }


}