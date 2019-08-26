package top.daoyang.threadcoreknowledge.sixstate;

public class BlockedWaitingTimedWaiting implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        BlockedWaitingTimedWaiting runnable = new BlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        Thread.sleep(10);
        System.out.println("Thread TIME_WAITING state -> " + thread1.getState());

        thread2.start();
        Thread.sleep(10);
        System.out.println("Thread BLOCKED state -> " + thread2.getState());

        Thread.sleep(1300);
        System.out.println("Thread WAITING state -> " + thread1.getState());

        System.out.println("nsb");
    }

    @Override
    public void run() {
        sync();
    }

    private synchronized void sync() {
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
