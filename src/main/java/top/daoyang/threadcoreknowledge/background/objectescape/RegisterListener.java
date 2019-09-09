package top.daoyang.threadcoreknowledge.background.objectescape;

/**
 * 用内部类注册监听器
 * 内部类持有外部类的引用，因此有对象逃逸的风险
 */
public class RegisterListener {

    private int count;

    private RegisterListener(MySource mySource) {
        mySource.setListener(() -> System.out.println("On event " + count));

        for (int i = 0; i < 10000; i++) {
            System.out.print(i);
        }
        System.out.println();
        this.count = 1000;
    }

    public static void main(String[] args) {
        MySource mySource = new MySource();
        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mySource.eventCome();
        }).start();

        new RegisterListener(mySource);

    }

    static class MySource {
        private EventListener listener;

        private void setListener(EventListener listener) {
            this.listener = listener;
        }

        void eventCome() {
            if (listener != null) {
                listener.onEvent();
            } else {
                System.out.println("listener is null");
            }
        }
    }

    @FunctionalInterface
    interface EventListener {
        void onEvent();
    }
}
