package top.daoyang.threadcoreknowledge.ThreadAndObjectMethod.exercies;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 抢到锁后，打印，notify，wait
 * 提前通知
 */
public class AlternatePrintingWaitNotify {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger();

        Runnable runnable = () -> {
            while (count.get() < 100) {
                synchronized (AlternatePrintingWaitNotify.class) {
                    System.out.println(Thread.currentThread().getName() + " : " + count.getAndIncrement());
                    AlternatePrintingWaitNotify.class.notifyAll();
                    try {
                        AlternatePrintingWaitNotify.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    AlternatePrintingWaitNotify.class.notifyAll();
                }
            }
        };

        new Thread(runnable, "even").start();
        new Thread(runnable, "odd").start();
    }
}
