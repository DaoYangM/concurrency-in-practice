package top.daoyang.threadcoreknowledge.ThreadAndObjectMethod.exercies;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 两个线程枪锁
 * 判断合适了打印，并且改变状态
 */
public class AlternatePrintingSynchronized {

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger();

        new Thread(() -> {
            while (count.get() < 100) {
                synchronized (AlternatePrintingSynchronized.class) {
                    if ((count.get() & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + " : " + count.getAndIncrement());
                    }
                }
            }
        }, "even").start();

        new Thread(() -> {
            while (count.get() < 100) {
                synchronized (AlternatePrintingSynchronized.class) {
                    if ((count.get() & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + " : " + count.getAndIncrement());
                    }
                }
            }
        }, "odd").start();
    }
}
