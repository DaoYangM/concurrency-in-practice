package top.daoyang.threadcoreknowledge.stopthreads;

public class RightWayStopThreadWithWait {

    private final static Integer LOCK = 1;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            synchronized (LOCK) {
                System.out.println("thread1 get lock");
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while (true) {
                    System.out.println("thread1 weak up");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 out");
            }
        });
        thread1.start();

        Thread.sleep(1000);

        thread2.start();

        Thread.sleep(1000);

        thread1.interrupt();
        System.out.println("thread1 interrupt");
    }
}
