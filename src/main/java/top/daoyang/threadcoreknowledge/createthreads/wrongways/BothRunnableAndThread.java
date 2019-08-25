package top.daoyang.threadcoreknowledge.createthreads.wrongways;

public class BothRunnableAndThread {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("runnable")) {
            @Override
            public void run() {
                System.out.println("thread");
            }
        }.start();
    }
}
