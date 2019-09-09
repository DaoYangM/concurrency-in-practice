package top.daoyang.threadcoreknowledge.background.objectescape;

import java.util.HashMap;
import java.util.Map;

public class StartThreadOnConstruct {
    private Map<String, String> week;

    private StartThreadOnConstruct() {

        new Thread(() -> {
            week = new HashMap<>();
            week.put("1", "星期一");
            week.put("2", "星期二");
        }).start();
    }

    public static void main(String[] args) {
        StartThreadOnConstruct startThreadOnConstruct = new StartThreadOnConstruct();

        System.out.println(startThreadOnConstruct.week.get("1"));
    }
}
