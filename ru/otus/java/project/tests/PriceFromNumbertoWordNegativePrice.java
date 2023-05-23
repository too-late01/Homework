package ru.otus.java.project.tests;

import ru.otus.java.project.PriceFromNumberToWord;

import static ru.otus.java.HW6_UnitTests.Assertions.Assertions.assertThrows;

public class PriceFromNumbertoWordNegativePrice {
    static int TEST_NEGATIVE_PRICE = -1;

    public static void testPositiveNumberInput() {
        String scenario = "Проверка, что выдается исключение при вводе отрицательной цены";
        try {

            assertThrows(IllegalArgumentException.class,() -> PriceFromNumberToWord.convertNumberToWord(TEST_NEGATIVE_PRICE).getClass());
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());

        }
    }
}

