package top.daoyang.threadcoreknowledge.stopthreads.answer;

public class AnswerThrow implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new AnswerThrow());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("go");
                throwMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("cleaned up context");
                return;
            }
        }
    }

    // 往外部抛出异常，以便让上层处理中断异常
    private void throwMethod() throws InterruptedException {
        Thread.sleep(5000);
    }
}
