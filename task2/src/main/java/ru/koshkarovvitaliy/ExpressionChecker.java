package ru.koshkarovvitaliy;
/*
 * Created by Koshkarov Vitaliy on 24.01.2020
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExpressionChecker {
    public static void main(String[] args) {
        try {
            System.out.println("Write the expression");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String expression = reader.readLine();
            reader.close();

            ExpressionChecker main = new ExpressionChecker();
            boolean result = main.checkExpression(expression);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkExpression(String expression) {
        if (expression != null) {
            if (expression.charAt(0) == ']' || expression.charAt(0) == ')') return false;

            if (expression.charAt(expression.length() - 1) == '['
                || expression.charAt(expression.length() - 1) == '(') {
                return false;
            }

            int countOfSquareBrackets = 0;
            int countOfRoundBrackets  = 0;

            char[] symbols = new char[expression.length()];

            for (int i = 0; i < expression.length(); i++) {
                symbols[i] = expression.charAt(i);
            }

            for (char symbol : symbols) {
                if (symbol == '[') countOfSquareBrackets++;
                if (symbol == '(') countOfRoundBrackets++;
                if (symbol == ']') countOfSquareBrackets--;
                if (symbol == ')') countOfRoundBrackets--;
                if (countOfSquareBrackets < 0 || countOfRoundBrackets < 0) return false;
            }

            if (countOfSquareBrackets > 0 || countOfRoundBrackets > 0) return false;

            return true;
        }
        return false;
    }
}
