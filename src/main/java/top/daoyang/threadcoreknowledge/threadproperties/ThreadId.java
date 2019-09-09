package top.daoyang.threadcoreknowledge.threadproperties;

public class ThreadId {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId());
        System.out.println(new Thread().getId());
    }
}
