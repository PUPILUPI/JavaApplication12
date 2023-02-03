package Methods;

public class Methods {
    public static final Object scissors = new Object();
    public static final Object paper = new Object();

    public static void doSun() throws InterruptedException {
            synchronized (scissors) {
                System.out.println(Thread.currentThread().getName()
                        + " взяла ножницы для вырезания солнышка");
                scissors.notify();
                synchronized (paper) {
                    System.out.println(Thread.currentThread().getName()
                            + " взяла бумагу для вырезания солнышка");
                    System.out.println(Thread.currentThread().getName()
                            + " вырезает солнышко");
                    paper.notify();
                }
            }
    }

    public static void doCloud() throws InterruptedException {
            synchronized (paper) { // May deadlock here
                System.out.println(Thread.currentThread().getName()
                        + " взяла бумагу для вырезания облачка");
                paper.wait();
                synchronized (scissors) {
/*
                if (Thread.holdsLock(scissors)) {
                    System.out.println("заняты");
                    scissors.wait();
                }else {
                    scissors.notifyAll();
                }

 */
                    System.out.println(Thread.currentThread().getName()
                            + " взяла ножницы для вырезания облачка");
                    System.out.println(Thread.currentThread().getName()
                            + " вырезает облачко");
                    paper.notify();
                }
        }
    }
}