package ru.otus.java;

import java.util.Scanner;

class Question {
    private int number;
    private String text;
    private QuestionOption[] options; //связь с классом ответов

    // cmd+N - вызов конструктора
    public Question(int number, String text, QuestionOption[] options) {
        this.number = number;
        this.text = text;
        this.options = options;
    }

    public void print() {
        System.out.println(this.number + " " + this.text);
        for (QuestionOption option : this.options) {
            option.print();
        }
    }

    public int getAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ваш ответ: ");
        int answer = scanner.nextInt();
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
        /* почему нельзя так?
         if (answer1 = options[0]) System.out.println("Right");
        выдает такие ошибки:
        java: incompatible types: ru.otus.java.QuestionOption cannot be converted to int
        java: incompatible types: int cannot be converted to boolean
        */
    }
}




class QuestionOption {
    private int number;
    private String text;
    private boolean isCorrect;

    public QuestionOption(int number, String text, boolean isCorrect) {
        this.number = number;
        this.text = text;
        this.isCorrect = isCorrect; //отмечаем правильный или неправильный
    }
    public void print() {
        System.out.println(this.number + " " + this.text);
    }
    public int getNumber() {
        number = this.number;
        return number;
    }
    public boolean getIsCorrect () {
        isCorrect = this.isCorrect;
        return isCorrect;
    }
}

public class HWTestingSystem {
    static int correctCount =0;
    static int wrongCount = 0;
    static boolean count = false;
    public static void main(String[] args) {
        Question[] questions = new Question[4];
        questions[0] = new Question(1,
                "В файл с каким расширением компилируется java-файл?",
                new QuestionOption[]{
                        //        "1. cs", "2. java", "3. class", "4. exe"
                        new QuestionOption(1, "cs", false),
                        new QuestionOption(2, "java", true),//cmdD
                        new QuestionOption(3, "class", false),
                        new QuestionOption(4, "exe", false)
                });
        questions[1] = new Question(2,
                "С помощью какой команды git можно получить полную копию удаленного репозитория?",
                new QuestionOption[]{
                        //"1. commit", "2. push", "3. clone", "4. copy"
                        new QuestionOption(1, "commit", false),
                        new QuestionOption(2, "push", false),
                        new QuestionOption(3, "clone", true),
                        new QuestionOption(4, "copy", false),
                });
        questions[2] = new Question(3,
                "Какой применяется цикл, когда не известно количество итераций?",
                new QuestionOption[]{
                        //1. while", "2. for", "3. loop"
                        new QuestionOption(1, "while", true),
                        new QuestionOption(2, "for", false),
                        new QuestionOption(3, "loop", false),

                });
        questions[3] = new Question(4,
                "Где больше всего проблем при написании кода?",
                new QuestionOption[]{
                        new QuestionOption(1, "объявление переменных", false),
                        new QuestionOption(2, "написание методов", false),
                        new QuestionOption(3, "все вместе", true),

                });


        for (int i = 0; i < questions.length; i++) {
            questions[i].print();
            count =questions[i].showCorrectAnswer();
     if (count == true) correctCount = correctCount + 1;
            else wrongCount = wrongCount + 1;
        }
        System.out.println("Правильных ответов=" + " " + correctCount +" "+
                "Неправильных ответов=" + " " + wrongCount);
    }
}

