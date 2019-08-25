package top.daoyang.threadcoreknowledge.stopthreads;

/**
 * Thread.interrupt() 只是通知该线程应该停止了，但是线程还是会继续执行。
 * 要真正的停止线程那么要在 Thread.currentThread().isInterrupted() 判断之后，推出
 */
public class RightWayStopThreadWithoutSleep implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE / 2 && !Thread.currentThread().isInterrupted(); i++) {
            if (i % 10000 == 0) {
                System.out.println(i + " is 10000 times");
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());

        thread.start();
        Thread.sleep(1000);

        thread.interrupt();
    }
}
