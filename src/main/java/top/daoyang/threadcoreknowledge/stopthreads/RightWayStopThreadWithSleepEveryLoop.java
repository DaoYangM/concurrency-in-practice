package top.daoyang.threadcoreknowledge.stopthreads;

public class RightWayStopThreadWithSleepEveryLoop {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                for (int i = 0; i < 300; i++) {
                    if (i % 100 == 0) {
                        System.out.println(i + " is 100 times");
                    }

                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread.sleep(100);

        thread.interrupt();
    }
}
