package top.daoyang.threadcoreknowledge.ThreadAndObjectMethod.wait;

/**
 * notifyAll方法唤醒所有调用wait方法的线程
 * 如果notify、notifyAll提早通知了，调用wait方法的线程将永远不会被唤醒
 */
public class WaitAndNotifyAll {

    private static final Object OBJECT = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            synchronized (OBJECT) {
                System.out.println(Thread.currentThread().getName() + " got monitor lock, ready to wait release monitor lock");
                try {
                    OBJECT.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " has been weaken");
            }
        };

        Thread threadA = new Thread(r);
        threadA.setName("threadA");
        threadA.start();

        Thread threadB = new Thread(r);
        threadB.setName("threadB");
        threadB.start();

        Thread.sleep(200);

        Thread threadC = new Thread(() -> {
            synchronized (OBJECT) {
                OBJECT.notifyAll();
                System.out.println(Thread.currentThread().getName() + " notified all wait threads");
            }
        });

        threadC.setName("threadC");
        threadC.start();
    }
}
