package ru.otus.java.project.tests;

public class AllTests {
    public static void main(String[] args) {
        new PriceFromNumbertoWordNegativePrice().testPositiveNumberInput();
        new PriceFromNumberToWordNonNumericalTest().testNonNumericInput();
    }
}
