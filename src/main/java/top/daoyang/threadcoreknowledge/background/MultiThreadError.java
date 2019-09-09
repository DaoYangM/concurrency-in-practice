package top.daoyang.threadcoreknowledge.background;

/**
 * 多个线程对a++会导致的问题
 */
public class MultiThreadError {
    private static int a;
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10000; i++) {
                a++;
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(a);
    }
}
