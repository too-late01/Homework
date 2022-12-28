package ru.otus.java;

import java.util.Scanner;
public class HWTestingSystem {
    static int correctCount = 0;
    static int wrongCount = 0;
    public static void main(String[] args) {
        for (int i = 0; i < Questions.questions.length; i++) {
            System.out.println(Questions.questions[i]);
            for (int j = 0; j < Answers.answerToQuestions.length; j++) {
                System.out.println(Answers.answerToQuestions[i][j]);
            }
            if (Answers.GetAnswer() == Answers.correctAnswers[i]) {
                System.out.println("Correct answer");
                correctCount = correctCount + 1;
            } else {
                System.out.println("Wrong answer");
                wrongCount = wrongCount + 1;
            }
        }
        System.out.println("Результат: правильно " + correctCount + ", неправильно " + wrongCount);
    }
    class Questions {
        static String[] questions = {"В файл с каким расширением компилируется java-файл?",
                "С помощью какой команды git можно получить полную копию удаленного репозитория?",
                "Какой применяется цикл, когда не известно количество итераций?"};
    }
    static class Answers {
        static String[][] answerToQuestions = {
                {"1. cs", "2. java", "3. class", "4. exe"},
                {"1. commit", "2. push", "3. clone", "4. copy"},
                {"1. while", "2. for", "3. loop"}
        };
        static int[] correctAnswers = {2, 3, 1};
        public static int GetAnswer() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ваш ответ: ");
            int answer = scanner.nextInt();
            return answer;
        }
    }
}
