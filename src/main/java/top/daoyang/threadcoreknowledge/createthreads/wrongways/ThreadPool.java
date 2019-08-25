package top.daoyang.threadcoreknowledge.createthreads.wrongways;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 1000; i++) {
            final int j = i;
            executorService.submit(() -> System.out.println(Thread.currentThread().getName() + " " + j));
        }
    }
}
