package com.example.slaby.android_3;

public class Calculator {

    Integer number0;
    Integer number1;
    Double resultValue;
    String operation;

    public void inputNumber(int number) {
        if (number0 == null) {
            number0 = number;
            return;
        }
        System.out.println(number0);
        System.out.println(operation);

        if (number0 != null && operation == null) {
            number0 = Integer.parseInt(String.valueOf(number0) + number);
            return;
        }
        if (number1 == null) {
            number1 = number;
            return;
        }
        if (number1 != null) {
            number1 = Integer.parseInt(String.valueOf(number1) + number);
            return;
        }
        System.out.println("[DEBUG] ON CLICK " + number);
    }

    public void addOperation(String op) {
        if (operation == null) {
            System.out.println("[DEBUG] ADD OPERATION " + op);
            operation = op;
        }
        return;
    }

    public String getMath() {
        String result = "";

        if (number0 == null) {
            return "";
        }
        result += number0 + " ";

        if (operation == null) {
            return result;
        }
        result += operation;
        if (number1 == null) {
            return result;
        }
        result += number1;
        if (resultValue == null) {
            return result;
        }
        result += " = " + resultValue;

        return result;
    }


    public void equal() {

        switch (operation) {
            case "+":
                resultValue = Double.valueOf(number0 + number1);
                return;
            case "-":
                resultValue = Double.valueOf(number0 - number1);
                return;
            case "*":
                resultValue = Double.valueOf(number0 * number1);
                return;
            case "/":
                resultValue = Double.valueOf(number0) / number1;
                return;
        }
    }


}
