package top.daoyang.threadcoreknowledge.ThreadAndObjectMethod.wait;

/**
 * wait、notify方法要在synchronized块中执行
 * notify方法会随机唤醒一个调用wait方法的线程，并且要完全执行完notify方法
 * notify方法被调用后并不会立即释放发锁，要等到执行完synchronized语句块后才会释放monitor锁
 */
public class WaitAndNotify {

    private static final Object OBJECT = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (OBJECT) {
                System.out.println(Thread.currentThread().getName() + " get monitor lock and wait release monitor lock");
                try {
                    OBJECT.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " weak up after OBJECT.notify() out synchronized block");
            }
        }).start();

        Thread.sleep(100);

        new Thread(() -> {
            synchronized (OBJECT) {
                // 并不会立即释放锁，要等到执行完synchronized语句块后才释放monitor锁
                OBJECT.notify();
                System.out.println(Thread.currentThread().getName() + " notify one wait thread");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " out of synchronized block release monitor lock");
            }
        }).start();
    }
}
