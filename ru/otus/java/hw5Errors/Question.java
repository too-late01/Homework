package ru.otus.java.hw5Errors;

import java.util.Scanner;

public class Question {
    private int number;
    private String text;
    private QuestionOption[] options;

    public Question(int number, String text, QuestionOption[] options) {
       if (number <1) {
           throw new IllegalArgumentException("number.Question should not be < 1");
      } this.number = number; // не налл не пустое
       if (text==null | text.isEmpty()) {
           throw new IllegalArgumentException("text.Question should not be equal null or empty");
       } this.text = text; // аналогично
        if (options==null| options.length==0) {
            throw new IllegalArgumentException("options.Question should not be equal null or empty");
        } this.options = options; // не пустой или налл - ошибка
    }

    public void print() {
        System.out.println(this.number + " " + this.text);
        for (QuestionOption option : this.options) {
            option.print();
        }
    }

    public int getAnswer() {
        //  без try-with-resources
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Ваш ответ: ");
//        if (scanner.hasNextInt()==false) {
//            throw new IllegalArgumentException("Введите номер ответа (число, а не слово)");
//        }int answer = scanner.nextInt();
//
//        return answer;
// try-with-resources (вроде бы это он?)

        System.out.print("Ваш ответ: ");
        int answer = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextInt()) {
                answer = scanner.nextInt();
            }
            else {
                throw new IllegalArgumentException("некорректный ввод ответа");
            }
        } catch (Exception NotCorrectAnswerInput) {
            NotCorrectAnswerInput.printStackTrace();
          //  System.out.println("некорректный ввод ответа");
        }
       return answer;
    }

    public boolean showCorrectAnswer() {
        int answer1 = getAnswer();
        boolean count = false;
        for (int i = 0; i < options.length; i++) {
            if (answer1 != options[i].getNumber()) {
            } else {
                if (options[i].getIsCorrect() == true) {
                    System.out.println("Это правильный ответ");
                    count = true;
                } else {
                    System.out.println("Это неправильный ответ");
                    count = false;
                }
            }
        }
        return count;
    }
}
