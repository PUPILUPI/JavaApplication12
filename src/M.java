import Methods.Methods;

import java.util.concurrent.atomic.AtomicInteger;


public class M {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(3);

        System.out.println(atomicInteger);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                try {
                    Methods.doSun();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                try {
                    Methods.doCloud();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread1 = new Thread(() -> {
            runnable.run();
        });
        thread1.setName("Егор");
        Thread thread2 = new Thread(() -> {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            //           }
            runnable.run();
        });
        thread2.setName("Вова");
            thread1.start();
            thread2.start();
    }
}