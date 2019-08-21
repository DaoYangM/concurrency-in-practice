package top.daoyang.threadcoreknowledge.createthreads;

/**
 * 用继承Thread类实现多线程
 */
public class ThreadStyle extends Thread {

    @Override
    public void run() {
        System.out.println("用继承Thread类来实现多线程");
    }

    public static void main(String[] args) {
        Thread thread = new ThreadStyle();
        thread.start();
    }
}
