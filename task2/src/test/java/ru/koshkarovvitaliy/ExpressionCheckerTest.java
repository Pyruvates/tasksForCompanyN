package ru.koshkarovvitaliy;
/*
 * Created by Koshkarov Vitaliy on 24.01.2020
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

public class ExpressionCheckerTest {
    private ExpressionChecker expressionChecker;

    @BeforeEach
    void initMain() {
        expressionChecker = new ExpressionChecker();
    }

    @Test
    void whenExpressionIsNull() {
        boolean expression = expressionChecker.checkExpression(null);
        Assertions.assertFalse(expression);
    }

    @Test
    void whenExpressionHasOnlyDifferentBrackets() {
        boolean expression = expressionChecker.checkExpression("(]");
        Assertions.assertFalse(expression);
    }

    @Test
    void whenExpressionHasOnlySameBrackets() {
        boolean expression = expressionChecker.checkExpression("((");
        Assertions.assertFalse(expression);
    }

    @Test
    void whenExpressionHasOneOpenedBracket() {
        boolean expression = expressionChecker.checkExpression("[");
        Assertions.assertFalse(expression);
    }

    @Test
    void whenExpressionHasOneClosedBracket() {
        boolean expression = expressionChecker.checkExpression(")");
        Assertions.assertFalse(expression);
    }

    @Test
    void whenOpenedBracketsMoreThanClosed() {
        boolean expression = expressionChecker.checkExpression("(()([(]))");
        Assertions.assertFalse(expression);
    }

    @Test
    void whenOpenedBracketsLessThanClosed() {
        boolean expression = expressionChecker.checkExpression("((])([]))");
        Assertions.assertFalse(expression);
    }

    @Test
    void whenOpenedBracketsEqualsClosed() {
        boolean expression = expressionChecker.checkExpression("([][[]()])");
        Assertions.assertTrue(expression);
    }
}
