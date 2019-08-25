package top.daoyang.threadcoreknowledge.stopthreads.wrong;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class WrongWayVolatile {

    static class Producer implements Runnable {

        BlockingQueue<Integer> queue;

        Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                if (i % 100 == 0) {
                    try {
                        queue.put(i);
                        System.out.println(i + "是100的倍数，被放入到仓库中。");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
            System.out.println("生产者结束运行");
        }
    }

    static class Consumer implements Runnable {

        BlockingQueue<Integer> queue;

        Producer producer;

        Thread producerThread;

        Consumer(BlockingQueue<Integer> queue, Producer producer, Thread producerThread) {
            this.queue = queue;
            this.producer = producer;
            this.producerThread = producerThread;
        }

        @Override
        public void run() {
            while (needMoreNums()) {
                Integer poll = queue.poll();
                System.out.println(poll + "被消费了");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("通知生产者停止生产");
            producerThread.interrupt();
        }

        private boolean needMoreNums() {
            return !(Math.random() > 0.95);
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        Producer producer = new Producer(queue);
        Thread producerThread = new Thread(producer);

        Consumer consumer = new Consumer(queue, producer, producerThread);


        producerThread.start();
        new Thread(consumer).start();
    }
}
