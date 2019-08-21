package top.daoyang.threadcoreknowledge.createthreads;

public class RunnableStyle implements Runnable {
    public void run() {
        System.out.println("用Runnable方法实现多线程");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }
}
