package top.daoyang.threadcoreknowledge.ThreadAndObjectMethod.exercies;

/**
 * 两个线程交替打印奇数偶数
 */
public class AlternatePrinting {

    private static volatile Boolean isOdd = false;

    public static void main(String[] args) {

        final int[] j = {0};

        Thread odd = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                synchronized (AlternatePrinting.class) {
                    while (!isOdd) {
                        try {
                            AlternatePrinting.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(Thread.currentThread().getName() + " " + j[0]);
                    j[0] = j[0] + 1;
                    isOdd = false;
                    AlternatePrinting.class.notifyAll();
                }
            }
        });
        odd.setName("odd");

        Thread even = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                synchronized (AlternatePrinting.class) {
                    while (isOdd) {
                        try {
                            AlternatePrinting.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " " + j[0]);
                    j[0] += 1;
                    isOdd = true;
                    AlternatePrinting.class.notifyAll();
                }
            }
        });
        even.setName("even");

        odd.start();
        even.start();
    }
}
