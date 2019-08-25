package top.daoyang.threadcoreknowledge.stopthreads;

public class RightWayStopThreadWithSleep {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (true) {
                System.out.println("weak up");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread.sleep(1000);

        thread.interrupt();
    }
}
