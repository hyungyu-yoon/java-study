package ch14.sec05.exam03;

public class YieldExample {
    public static void main(String[] args) {
        WorkThread threadA = new WorkThread("workThreadA");
        WorkThread threadB = new WorkThread("workThreadB");
        threadA.start();
        threadB.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {


        }
        threadA.work = false;

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        threadA.work = true;
    }
}
