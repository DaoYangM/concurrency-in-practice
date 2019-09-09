package top.daoyang.threadcoreknowledge.ThreadAndObjectMethod.join;

public class JoinPrinciple {

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

        synchronized (thread1) {
            thread1.wait(0);
        }

        System.out.println(Thread.currentThread().getName() + " done");
    }
}
