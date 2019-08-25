package top.daoyang.threadcoreknowledge.stopthreads.answer;

public class AnswerSetInterrupted implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new AnswerSetInterrupted());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("go");
            throwMethod();
        }
        System.out.println("cleaned up context");
    }

    // 往外部抛出异常，以便让上层处理中断异常
    private void throwMethod() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
