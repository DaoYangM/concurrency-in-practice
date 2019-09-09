package top.daoyang.threadcoreknowledge.ThreadAndObjectMethod.wait;

/**
 * Object.wait()只会释放对应的对象监视器锁
 */
public class WaitReleaseOwnMonitorLock {

    private static final Object OBJECT1 = new Object();
    private static final Object OBJECT2 = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            synchronized (OBJECT1) {
                System.out.println(Thread.currentThread().getName() + " got OBJECT1 monitor lock");
                synchronized (OBJECT2) {
                    System.out.println(Thread.currentThread().getName() + " got OBJECT2 monitor lock");
                    try {
                        System.out.println(Thread.currentThread().getName() + " released OBJECT1 monitor lock");
                        OBJECT1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threadA.setName("threadA");

        Thread threadB = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (OBJECT1) {
                System.out.println(Thread.currentThread().getName() + " got OBJECT1 monitor lock");
                synchronized (OBJECT2) {
                    System.out.println(Thread.currentThread().getName() + " got OBJECT2 monitor lock");
                }
            }
        });

        threadB.setName("threadB");

        threadA.start();
        threadB.start();
    }
}
