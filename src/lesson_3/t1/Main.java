package lesson_3.t1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int capacity = 100;
        long curTime;

        MyArrayList<Integer> mal = new MyArrayList<>(capacity);
        fillIn(mal, capacity);

        System.out.println(mal);

        curTime = System.currentTimeMillis();
        mal.insertionSort();
        calculateTime(curTime);

        System.out.println(mal);
    }

    private static void calculateTime(long curTime1) {
        long curTime2 = System.currentTimeMillis();
        long result = curTime2 - curTime1;
        System.out.println("сортировка заняла " + result);
    }

    private static void fillIn(MyArrayList<Integer> mal, int capacity) {
        Random random= new Random();
        for (int i = 0; i < capacity; i++) {
            mal.add(random.nextInt(100000));
        }
    }
}
