package ru.otus.java.hw5Errors;

import java.io.IOException;
import java.util.Scanner;

public class HW5Errors {
    static int correctCount =0;
    static int wrongCount = 0;
    static boolean count = false;
    public static void main (String [] args) {
        try {
            try {
                Question[] questions = new Question[4];
                questions[0] = new Question(1,
                        "Вопрос",
                        new QuestionOption[]{

                                new QuestionOption(1, "cs", false),
                                new QuestionOption(2, "java", true),
                                new QuestionOption(3, "class", false),
                                new QuestionOption(4, "exe", false)
                        });
                questions[1] = new Question(2,
                        "С помощью какой команды git можно получить полную копию удаленного репозитория?",
                        new QuestionOption[]{

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
                    count = questions[i].showCorrectAnswer();
                    if (count == true) correctCount = correctCount + 1;
                    else wrongCount = wrongCount + 1;
                }
                System.out.println("Правильных ответов=" + " " + correctCount + " " +
                        "Неправильных ответов=" + " " + wrongCount);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }catch (Exception notCorrectAnswerInput) {
            System.out.println(notCorrectAnswerInput.getMessage());
        }
    }
}

