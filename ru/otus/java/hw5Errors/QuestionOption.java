package ru.otus.java.hw5Errors;

public class QuestionOption {
    private int number;
    private String text;
    private boolean isCorrect;

    public QuestionOption(int number, String text, boolean isCorrect) {
        // добавить проверку для намбера и текста (текст должен быть не налл или пустая строка - выкинуть ошибку
      if (number<1) {
          throw new IllegalArgumentException("Number.QuestionOption should not be < 1");
      } this.number = number; // чтоб был больше нуля
        if (text==null | text.isEmpty()) {
            throw new IllegalArgumentException("text.QuestionOption should not be equal null or empty");
        } this.text = text;
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
