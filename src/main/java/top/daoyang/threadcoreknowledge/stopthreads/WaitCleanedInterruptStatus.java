package top.daoyang.threadcoreknowledge.stopthreads;

public class WaitCleanedInterruptStatus {

    private static final Integer LOCK = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            synchronized (LOCK) {
                for (int i = 0; i < Integer.MAX_VALUE && !Thread.currentThread().isInterrupted(); i++) {
                    if (i % 10000 == 0) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println("cleaned up current thread interrupted status");
                        }
                    }
                }
            }
        });

        thread.start();
        Thread.sleep(2000);

        thread.interrupt();
    }
}
