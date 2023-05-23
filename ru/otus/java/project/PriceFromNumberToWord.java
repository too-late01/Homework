package ru.otus.java.project;

import java.util.Scanner;

public class PriceFromNumberToWord {
    public static void main(String[] args) {

       int price = getPrice();
       String currency = addCurrency();
       String priceToOutput;
       priceToOutput = convertNumberToWord(price)+currency;
       System.out.println(priceToOutput);
    }

    public static String addCurrency () {
        String CURRENCY = " руб.";
        return CURRENCY;
    }
    public static int getPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите цену: ");
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException("ОШибка - введено не число!");}
        int price = scanner.nextInt();
        return price;
    }

    public static String convertNumberToWord(int price) {
        String[] BELOW_TWENTY = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
        String[] TENS = {"сто", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
        String[] THOUSANDS = {"тысяча", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
        while (true) {
            if ( price < 0 || price > 1000 ) {
                throw new IllegalArgumentException("Цена не может быть меньше ноля и больше тысяч");
            }

            if ( price < 20 )
                return BELOW_TWENTY[price];
            if (price > 10 && price < 100 ) {
                int high = price / 10;
                int low = price % 10;
                String text = TENS[high];
                if ( low != 0 )
                    text = text + " " + BELOW_TWENTY[low];
                return text;
            }
            else if (price > 100 && price < 1000) {
                int high = price / 100;
                int low = price % 10;
                String text = THOUSANDS[high];
                if ( low != 0 )
                    text = text + " " +TENS[low] + " " +BELOW_TWENTY[low] ;
                return text;
            }
            else if (price == 100) {
                return (TENS[0]); }
        }
    }
}