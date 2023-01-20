package ru.otus.java;

import java.util.*;

public class HWSortArrays {
private int size;
    public HWSortArrays (){
    }
    public int getSize () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("размер массива =");
        size = scanner.nextInt();
        return (size);
    }
    public ArrayList<Integer> createArray () {
        ArrayList<Integer> exampleArray = new ArrayList<>();
        for (int i = 0; i<size; i++) {
            int randomNumber = (int)(Math.random()*30);
            exampleArray.add(randomNumber);
        }
        System.out.println("Созданный массив:"+" "+exampleArray);
        return (exampleArray);
    }
    public void sortArray () {
        size = getSize();
        ArrayList<Integer> exampleArray = createArray();
        for (int i = 0; i<size; i++) {
            int k = i;
            int min = exampleArray.get(i);
            for (int j =i+1; j<size;j++)
                if (exampleArray.get(j) < min) {
                    k = j;
                    min = exampleArray.get(j);
                }
                    exampleArray.set(k, exampleArray.get(i));
                    exampleArray.set(i, min);
            }
        System.out.println(" Отсортированный массив"+ " "+exampleArray);
    }

    public static void main(String[] args) {
        HWSortArrays exampleArray = new HWSortArrays();

        long start = new Date().getTime();
        exampleArray.sortArray();
        long end = new Date().getTime();
        System.out.println("Время выполнения реализованного метода"+" "+(end-start));

        long start1 = new Date().getTime();
        Collections.sort(exampleArray.createArray());
        long end1 = new Date().getTime();
        System.out.println("Время выполнения сортировки методом  Collections.sort()"+" "+(end1-start1));
    }
}
