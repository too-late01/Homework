package ru.otus.java;

import java.lang.reflect.Array;
import java.util.Scanner;
public class HomeworkThreeQuestions {

    public static void main(String[] args) {
        // Переменные для хранения количества правильных и неправильных ответов
        int correctCount = 0, wrongCount = 0;

        String[] questions = {"В файл с каким расширением компилируется java-файл?", "С помощью какой команды git можно получить полную копию удаленного репозитория?", "Какой применяется цикл, когда не известно количество итераций?"};

        String[][] answerOptions = {
                {"1. cs", "2. java", "3. class", "4. exe"},
                {"1. commit", "2. push", "3. clone", "4. copy"},
                {"1. while", "2. for", "3. loop"}
        };

        // Массив правильных ответов
        int[] correctAnswers = {2, 3, 1};

        // Примечание - можете придумать как хранить всю информацию в одном массиве

        Scanner scanner = new Scanner(System.in);
        // Цикл по всем вопросам - исправить, написать правильно
        for (int i = 0; i < questions.length; i++) {
            // Вывод вопроса на экран
            System.out.println(questions[i]);

            for (int j = 0; j < answerOptions.length; j++) {
                // Вывод вариантов ответов на экран
                System.out.println(answerOptions[i][j]);

            }
            System.out.print("Ваш ответ: ");
            Scanner var1 = new Scanner(System.in);
            int var2 = Integer.parseInt(var1.nextLine());
            //Считываем с консоли ответ пользователя

            if (var2 == correctAnswers[i]) {
                System.out.println("Correct answer");
            } else {
                System.out.println("Wrong answer");
            }
            if (var2 == correctAnswers[i]) {
                correctCount = correctCount + 1;
            } else {
                wrongCount = wrongCount + 1;
            }
            //Проверяем ответ и выводим результат
            // а также увеличиваем счетчики правильных и неправильных ответов


        }
        //Выводим общий результат
        System.out.println("Результат: правильно " + correctCount + ", неправильно " + wrongCount);
    }
}



