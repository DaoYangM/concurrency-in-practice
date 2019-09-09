package top.daoyang.threadcoreknowledge.uncaughtexception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 自定义线程异常处理类
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING, "线程异常，" + t.getName());
    }

    public static void main(String[] args) {
        MyUncaughtExceptionHandler myUncaughtExceptionHandler = new MyUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(myUncaughtExceptionHandler);

//        try {
//            new Thread(() -> {
//                throw new RuntimeException();
//            }).start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        new Thread(() -> {
            throw new RuntimeException();
        }).start();
    }
}
