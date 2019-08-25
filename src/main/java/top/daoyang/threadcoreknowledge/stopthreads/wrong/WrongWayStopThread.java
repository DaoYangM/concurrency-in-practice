package top.daoyang.threadcoreknowledge.stopthreads.wrong;

/**
 * 用Thread.stop() 直接停止线程，是十分错误的方式。
 */
public class WrongWayStopThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("连队"+i+"开始获取装备");
            for (int j = 0; j < 10; j++) {
                System.out.println(j);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("连队"+i+"结束");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new WrongWayStopThread());

        thread.start();

        Thread.sleep(100);
        thread.stop();
    }
}
