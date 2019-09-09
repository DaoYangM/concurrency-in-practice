package top.daoyang.threadcoreknowledge.ThreadAndObjectMethod.join;

/**
 * Thread.join() 中是主线程被中断
 */
public class MainInterrupt {

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();

        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("mainThread.interrupt()");
            mainThread.interrupt();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + " catch interrupt");
                return;
            }
            System.out.println(Thread.currentThread().getName() + " done");
        };

        Thread thread = new Thread(runnable);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(Thread.currentThread().getName() + " catch interrupt");
            thread.interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " done");
    }
}
