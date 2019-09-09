package top.daoyang.threadcoreknowledge.background;

/**
 * 死锁
 * 2 个线程，2把锁
 * 在拿到第一个锁后sleep一段时间
 */
public class DeadLock {
    public static void main(String[] args) {
        final Object LOCK1 = new Object();
        final Object LOCK2 = new Object();

        new Thread(() -> {
            synchronized (LOCK1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK2) {

                }
            }
        }).start();

        new Thread(() -> {
           synchronized (LOCK2) {
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized (LOCK1) {

               }
           }
        }).start();
    }
}
