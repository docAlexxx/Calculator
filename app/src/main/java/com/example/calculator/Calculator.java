package com.example.calculator;

public class Calculator {
    public double result;
    public double currentNumber;
    public String operation;
    public boolean isDecimal;
    public boolean isPositive;
    private final int MAX_LENGTH = 10;
    private int numberLength;


    public Calculator() {
        result = 0;
        currentNumber = 0;
        operation = "";
        isDecimal = false;
        isPositive = true;
        numberLength = 0;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setCurrentNumber(double currentNumber) {
        this.currentNumber = currentNumber;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setPositive(boolean positive) {
        isPositive = positive;
    }

    public double getResult() {
        return result;
    }

    public double getCurrentNumber() {
        return currentNumber;
    }

    public String getOperation() {
        return operation;
    }

    public boolean isPositive() {
        return isPositive;
    }

    public boolean isDecimal() {
        return isDecimal;
    }

    public void setDecimal(boolean decimal) {
        isDecimal = decimal;
    }

    public int getNumberLength() {
        return numberLength;
    }

    public void setNumberLength(int numberLength) {
        this.numberLength = numberLength;
    }


}
