package top.daoyang.threadcoreknowledge.ThreadAndObjectMethod.wait;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里的wait要用while包起来
 */
public class ProducerConsumerModel {

    private class Storage {

        private Integer maxSize;
        private final List<Integer> list;

        public Storage(Integer maxSize) {
            this.maxSize = maxSize;
            this.list = new ArrayList<>();
        }

        public void put(Integer v) throws InterruptedException {
            synchronized (list) {
                while (list.size() >= maxSize) {
                    System.out.println("Producer wait");
                    list.wait();
                }
                list.add(0, v);
                System.out.println("Producer add " + v);

                list.notifyAll();
            }
        }

        public Integer take() throws InterruptedException {
            synchronized (list) {
                while (list.size() == 0) {
                    System.out.println("consumer wait");
                    list.wait();
                }

                list.notifyAll();
                return list.remove(list.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        ProducerConsumerModel outerClass = new ProducerConsumerModel();
        Storage storage = outerClass.new Storage(10);

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    System.out.println(i);
                    storage.put(i);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " 中止");
                }
            }
        });

        producer.setName("producer");
        producer.start();

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Integer remove = storage.take();
                    System.out.println("Consumer remove " + remove);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " 中止");
                }
            }
        });
        consumer.setName("consumer");
        consumer.start();
    }
}
