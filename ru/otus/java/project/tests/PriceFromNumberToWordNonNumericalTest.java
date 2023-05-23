package ru.otus.java.project.tests;

import ru.otus.java.project.PriceFromNumberToWord;

import java.io.ByteArrayInputStream;

import static ru.otus.java.HW6_UnitTests.Assertions.Assertions.assertThrows;

public class PriceFromNumberToWordNonNumericalTest {
    static String INPUT = "abc";

    public static void testNonNumericInput() {
        String scenario = "Проверка, что при вводе цены буквами выдается исключение";
        try {
            String input = "abc";
            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assertThrows(IllegalArgumentException.class, PriceFromNumberToWord::getPrice);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (IllegalArgumentException e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());

        }
    }

}
