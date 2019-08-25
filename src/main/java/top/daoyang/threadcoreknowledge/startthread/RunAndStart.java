package top.daoyang.threadcoreknowledge.startthread;

public class RunAndStart {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        runnable.run();

        new Thread(runnable).start();
    }
}
