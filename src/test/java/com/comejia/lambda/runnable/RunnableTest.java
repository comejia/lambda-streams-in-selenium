package com.comejia.lambda.runnable;

public class RunnableTest {

    public static void main(String[] args) {

        // Runnable usefully in threads
        Runnable r = () -> {
            try {
                Thread.sleep(2000);
                System.out.println("Hello");
            } catch (InterruptedException ignore) { }
        };
        new Thread(r).start();
        //r.run();

        System.out.println("Hi");
    }
}
