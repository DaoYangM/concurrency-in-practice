package top.daoyang.threadcoreknowledge.sixstate;

/**
 * 线程状态转变 New -> Runnable -> Terminated
 */
public class NewRunnableTerminated implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new NewRunnableTerminated());

        // 线程NEW，没有调用start()
        System.out.println("Thread state NEW -> " + thread.getState());

        thread.start();

        // 线程Runnable，只要调用Thread.start()，不管有没有分配到CPU资源，线程状态就到了Runnable
        System.out.println("Thread state RUNNABLE -> " + thread.getState());

        Thread.sleep(1);

        // 线程Runnable，线程分配到了资源运行了也是，Runnable()
        System.out.println("Thread state RUNNABLE -> " + thread.getState());

        Thread.sleep(1000);

        // 线程Terminated
        System.out.println("Thread state TERMINATED -> " + thread.getState());
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
