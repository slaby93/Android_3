package com.example.slaby.android_3;

import android.widget.TextView;

import org.w3c.dom.Text;

public class Calculator {

    Integer number0;
    Integer number1;
    Double resultValue;
    String operation;
    TextView result0;
    TextView result1;
    TextView result2;
    TextView result3;
    boolean finished;

    Calculator() {
        finished = false;
    }

    public void setViews(TextView re0, TextView re1, TextView re2, TextView re3) {

        this.result0 = re0;
        this.result1 = re1;
        this.result2 = re2;
        this.result3 = re3;
    }


    public void inputNumber(int number) {
        if (finished) {
            onAfterFinised();
            return;
        }
        if (number0 == null) {
            number0 = number;
            result2.setText(String.valueOf(number0));
            return;
        }
        System.out.println(number0);
        System.out.println(operation);

        if (number0 != null && operation == null) {
            number0 = Integer.parseInt(String.valueOf(number0) + number);
            result2.setText(String.valueOf(number0));
            return;
        }
        if (number1 == null) {
            number1 = number;
            result0.setText(String.valueOf(number0));
            result1.setText(String.valueOf(operation));
            result2.setText(String.valueOf(number1));

            return;
        }
        if (number1 != null) {
            number1 = Integer.parseInt(String.valueOf(number1) + number);

            result0.setText(String.valueOf(number0));
            result1.setText(String.valueOf(operation));
            result2.setText(String.valueOf(number1));
            return;
        }
        System.out.println("[DEBUG] ON CLICK " + number);
    }

    public void addOperation(String op) {
        if (finished) {
            onAfterFinised();
            return;
        }
        if (operation == null) {
            System.out.println("[DEBUG] ADD OPERATION " + op);
            operation = op;
            result1.setText(String.valueOf(number0));
            result2.setText(op);
        }
        return;
    }

    public void onAfterFinised() {

    }

    public void equal() {
        if (finished) {
            onAfterFinised();
            return;
        }
        switch (operation) {
            case "+":
                resultValue = (double) (number0 + number1);
                break;
            case "-":
                resultValue = (double) (number0 - number1);
                break;
            case "*":
                resultValue = (double) (number0 * number1);
                break;
            case "/":
                resultValue = Double.valueOf(number0) / number1;
                break;
        }

        result3.setText(" = " + String.valueOf(resultValue));
        finished = true;
    }

}
