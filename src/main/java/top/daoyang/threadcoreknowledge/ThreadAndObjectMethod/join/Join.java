package top.daoyang.threadcoreknowledge.ThreadAndObjectMethod.join;

/**
 * 主线程等待子线程执行完毕
 * 可以先start后join
 */
public class Join {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 执行完毕");
        };

        Thread thread1 = new Thread(runnable, "thread1");
        thread1.start();
        Thread thread2 = new Thread(runnable, "thread2");
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(Thread.currentThread().getName() + " done");
    }
}
