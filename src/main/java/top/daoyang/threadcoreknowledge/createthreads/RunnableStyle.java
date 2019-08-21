package top.daoyang.threadcoreknowledge.createthreads;

/**
 * 用实现Runnable接口实现多线程
 */
public class RunnableStyle implements Runnable {
    public void run() {
        System.out.println("用实现Runnable接口实现多线程");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }
}
