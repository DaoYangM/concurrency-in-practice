package top.daoyang.threadcoreknowledge.background.objectescape;

public class AssignThisBeforeFullConstruct {

    private int x;

    private int y;

    private AssignThisBeforeFullConstruct(int x, int y) throws InterruptedException {
        Got.assignThisBeforeFullConstruct = this;
        Thread.sleep(100);
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) throws InterruptedException {
        new AssignThisBeforeFullConstruct(1, 2);
        System.out.println(Got.assignThisBeforeFullConstruct.x);
        System.out.println(Got.assignThisBeforeFullConstruct.y);
    }

    private static class Got {
        static AssignThisBeforeFullConstruct assignThisBeforeFullConstruct;
    }
}
