package top.daoyang.threadcoreknowledge.uncaughtexception;

/**
 * 不能在父类中直接捕获子类抛出的异常
 * try catch 只能捕获对应线程的异常，如果异常在子线程中抛出，则父线程不能catch
 */
public class CantCaughtExceptionInFatherThread {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            throw new RuntimeException();
        };


        try {
            new Thread(runnable, "thread1").start();
            new Thread(runnable, "thread2").start();
            new Thread(runnable, "thread3").start();
            new Thread(runnable, "thread4").start();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("find");
        }
    }
}
