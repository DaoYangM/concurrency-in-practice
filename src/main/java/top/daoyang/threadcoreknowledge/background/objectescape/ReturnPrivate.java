package top.daoyang.threadcoreknowledge.background.objectescape;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 对象逃逸
 * 返回了private类的对象
 */
public class ReturnPrivate {

    private final Map<String, String> week;

    private final Map<String, Thread> threadMap;

    private ReturnPrivate() {
        this.week = new HashMap<>();
        week.put("1", "星期一");
        week.put("2", "星期二");

        this.threadMap = new HashMap<>();
        Thread t1 = new Thread();
        t1.setName("t1");
        threadMap.put("1", t1);
    }

    private Map<String, String> getWeek() {
        return week;
    }

    /**
     * 解决对象逃逸的方法, BUG
     * @return 返回一个新对象
     */
    private Map<String, String> getWeekImproved() {
        return new HashMap<>(week);
    }

    private Map<String, Thread> getThreadMapImproved() {
        return new HashMap<>(threadMap);
    }

    public static void main(String[] args) {
        ReturnPrivate returnPrivate = new ReturnPrivate();
        Map<String, String> week = returnPrivate.getWeekImproved();

        System.out.println(week.get("1"));

        week.put("1", "2");

        week.remove("1");

        System.out.println(returnPrivate.getWeek().get("1"));

        Map<String, Thread> threadMapImproved = returnPrivate.getThreadMapImproved();
        threadMapImproved.get("1").setName("t2");

        System.out.println(returnPrivate.threadMap.get("1"));
    }
}
