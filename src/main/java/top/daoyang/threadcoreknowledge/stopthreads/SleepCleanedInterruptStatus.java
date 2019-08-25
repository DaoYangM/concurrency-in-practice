package top.daoyang.threadcoreknowledge.stopthreads;

public class SleepCleanedInterruptStatus {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE && !Thread.currentThread().isInterrupted(); i++) {
                if (i % 10000 == 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("cleaned up current thread interrupted status");
                    }
                }
            }
        });

        thread.start();
        Thread.sleep(2000);

        thread.interrupt();
    }
}
