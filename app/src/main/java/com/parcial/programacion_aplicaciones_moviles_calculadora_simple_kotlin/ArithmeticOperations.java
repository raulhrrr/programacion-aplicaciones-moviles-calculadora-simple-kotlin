package com.parcial.programacion_aplicaciones_moviles_calculadora_simple_kotlin;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticOperations {

    private static final List<String> history = new ArrayList<>();

    private Float num1, num2;

    public Float getNum1() {
        return num1;
    }

    public void setNum1(Float num1) {
        this.num1 = num1;
    }

    public Float getNum2() {
        return num2;
    }

    public void setNum2(Float num2) {
        this.num2 = num2;
    }

    public static void clearHistory() {
        history.clear();
    }

    public static List<String> getHistory() {
        return history;
    }

    public static void addCalculation(String operation) {
        history.add(operation);
    }

    public Float sum() {
        return num1 + num2;
    }

    public Float subtract() {
        return num1 - num2;
    }

    public Float multiply() {
        return num1 * num2;
    }

    public float multiplyRecursively(float multiplying, float multiplier) {
        if (multiplier > 0) return multiplying + multiplyRecursively(multiplying, multiplier - 1);
        if (multiplier < 0) return -multiplyRecursively(multiplying, -multiplier);
        return 0;
    }

    public int factorial(int factorialNumber, int limit) {
        if (factorialNumber == 0) return 1;
        return limit <= factorialNumber ? factorialNumber * factorial(factorialNumber - 1, limit) : 1;
    }

    public String fibonacci(int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) result.append(fibonacciRecursively(i)).append(i < end ? ", " : "");
        return result.toString();
    }

    private int fibonacciRecursively(int n) {
        return n <= 1 ? n : fibonacciRecursively(n - 1) + fibonacciRecursively(n - 2);
    }

    public Float divide() {
        return num1 / num2;
    }

}
