package top.daoyang.threadcoreknowledge.ThreadAndObjectMethod.sleep;

public class SleepDontReleaseMonitor {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            synchronized (SleepDontReleaseMonitor.class) {
                System.out.println(Thread.currentThread().getName() + " got monitor lock");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " release monitor lock");
            }
        };

        new Thread(runnable, "thread1").start();
        new Thread(runnable, "thread2").start();
    }
}
