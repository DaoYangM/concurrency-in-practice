package top.daoyang.threadcoreknowledge.createthreads.wrongways;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
    }
}
