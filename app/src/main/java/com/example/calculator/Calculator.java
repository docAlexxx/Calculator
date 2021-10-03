package com.example.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator {
    public double result;
    public String currentNumber;
    public String lastNumber;
    public String operation;
    public String lastOperation;
    public String resultToScreen;
    public boolean isDecimal;
    public boolean isNegative;
    public boolean inProcess;
    public boolean isError;
    public boolean setEnter;
    public boolean nextIsDigital;
    private final int MAX_LENGTH = 10;
    private int numberLength;

    public Calculator() {
        result = 0;
        currentNumber = "";
        lastNumber = "";
        operation = "";
        lastOperation = "";
        resultToScreen = "";
        isDecimal = false;
        isNegative = false;
        isError = false;
        setEnter = false;
        nextIsDigital = false;
        numberLength = 0;
        inProcess = false;
    }

    public void numberButtonPress(String digit) {
        if (nextIsDigital) {
            currentNumber = "";
            numberLength = 0;
            isDecimal = false;
            isNegative = false;
            isError = false;
            nextIsDigital = false;
        }

        if (setEnter) {
            resetButtonPress();
        }

        if (currentNumber.equals("0")) {
            currentNumber = "";
            numberLength--;
        }
        if (currentNumber.equals("-0")) {
            currentNumber = "-";
            numberLength--;
        }

        if (numberLength < MAX_LENGTH) {
            currentNumber = currentNumber + digit;
            numberLength++;
        } else {
            isError = true;
        }
    }

    public void resetButtonPress() {
        result = 0;
        currentNumber = "";
        lastNumber = "";
        operation = "";
        lastOperation = "";
        resultToScreen = "";
        isDecimal = false;
        isNegative = false;
        isError = false;
        setEnter = false;
        numberLength = 0;
        inProcess = false;
        nextIsDigital = false;
    }

    public void deleteButtonPress() {
        if (nextIsDigital) {
            currentNumber = "";
            numberLength = 0;
            isDecimal = false;
            isNegative = false;
            isError = false;
            nextIsDigital = false;
        }

        if (currentNumber != "") {
            Character lastSymbol = currentNumber.charAt(currentNumber.length() - 1);
            if (lastSymbol.equals('.')) {
                isDecimal = false;
            }
            if (lastSymbol.equals('-')) {
                isNegative = false;
            }
            if (currentNumber.length() == 1) {
                currentNumber = "";
            } else {
                currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
            }
            if (!lastSymbol.equals('.') && !lastSymbol.equals('-')) {
                numberLength--;
            }
        }
    }

    public void changeNumberSignPush() {
        if (nextIsDigital) {
            currentNumber = "";
            numberLength = 0;
            isDecimal = false;
            isNegative = false;
            isError = false;
            nextIsDigital = false;
        }

        if (currentNumber == "") {
            currentNumber = "-";
            isNegative = true;
        } else {
            if (Double.valueOf(currentNumber) < 0) {
                currentNumber = currentNumber.substring(1);
                isNegative = false;
            } else {
                currentNumber = "-" + currentNumber;
                isNegative = true;
            }
        }
    }

    public void dotButton() {
        if (nextIsDigital) {
            currentNumber = "";
            numberLength = 0;
            isDecimal = false;
            isNegative = false;
            isError = false;
            nextIsDigital = false;
        }

        if (!isDecimal) {
            if (currentNumber == "") {
                currentNumber = "0.";
                numberLength++;
            } else if (currentNumber == "-") {
                currentNumber = "-0.";
                numberLength++;
            } else {
                currentNumber = currentNumber + ".";
            }
            isDecimal = true;
        }
    }

    public double currentNumberToDouble(String number) {
        int intgerPart = 0;
        int decimalPart = 0;
        int afterpoint = 0;
        Character currentDigit;

        if (isDecimal) {
            int dotIndex = number.indexOf(".");
            intgerPart = Integer.parseInt(number.substring(0, dotIndex));
            decimalPart = Integer.parseInt(number.substring(dotIndex + 1));
            afterpoint = number.length() - 1 - dotIndex;
        } else {
            intgerPart = Integer.parseInt(number);
        }
        return intgerPart + decimalPart / Math.pow(10, afterpoint);
    }

    public void operationType(String currentOperation, String operator, String number) {
        if (!nextIsDigital || setEnter) {
            double operationNumber = 0.0;
            if (number.length() != 0) {
                operationNumber = currentNumberToDouble(number);
            }
            switch (currentOperation) {
                case ("plus"):
                    result = result + operationNumber;
                    break;
                case ("minus"):
                    result = result - operationNumber;
                    break;
                case ("multiply"):
                    result = result * operationNumber;
                    break;
                case ("divide"): {
                    if (operationNumber == 0) {
                        isError = true;
                    } else {
                        result = result / operationNumber;
                    }
                }
                break;
                default:
                    if (!inProcess) {
                        result = operationNumber;
                    }
                    inProcess = true;
            }
            checkResult();
            operation = operator;
            nextIsDigital = true;
        }
    }

    private void checkResult() {
        int intLength = 0;
        result = Math.round(result * Math.pow(10, MAX_LENGTH - 1)) / Math.pow(10, MAX_LENGTH - 1);
        int checkRes = (int) result;

        while (checkRes != 0) {
            checkRes = checkRes / 10;
            intLength++;
        }

        if (isNegative) {
            intLength++;
        }

        if (intLength > MAX_LENGTH) {
            isError = true;
        } else {
            result = Math.round(result * Math.pow(10, MAX_LENGTH - intLength)) / Math.pow(10, MAX_LENGTH - intLength);
            resultToScreen = String.valueOf(result);
            int i = resultToScreen.length() - 1;
            Character lastSymbol = resultToScreen.charAt(i);
            while (lastSymbol.equals('0') || lastSymbol.equals('.')) {
                resultToScreen = resultToScreen.substring(0, i);
                if (lastSymbol.equals('.')) {
                    break;
                }
                i--;
                lastSymbol = resultToScreen.charAt(i);
            }
        }
    }

    public void resultButtonPress() {
        if (setEnter) {
            operationType(lastOperation, lastOperation, lastNumber);
            operation = "";
        } else {
            operationType(operation, operation, currentNumber);
            lastOperation = operation;
            operation = "";
            lastNumber = currentNumber;
            currentNumber = "";
        }
        setEnter = true;
    }


}
