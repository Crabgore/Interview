package lesson_3.t2;

public class Main {
    public static void main(String[] args) {
        long curTime;
        int first = 10;
        int second = 45;

        curTime = System.currentTimeMillis();
        show(first);
        long o1 = calculateTime(curTime);

        curTime = System.currentTimeMillis();
        show(second);
        long o2 = calculateTime(curTime);

        System.out.println("данные увеличились в " + second/first + " раз(а)");
        System.out.println("время выполнения увеличилось в " + o2/o1  + " раз(а)");
    }

    public static void show(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(calculate(i) + " ");
        }
    }

    public static int calculate(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return calculate(n - 1) + calculate(n - 2);
        }
    }

    private static long calculateTime(long curTime1) {
        long curTime2 = System.currentTimeMillis();
        long result = curTime2 - curTime1;
        System.out.println(" сортировка заняла " + result);
        return result;
    }
}
