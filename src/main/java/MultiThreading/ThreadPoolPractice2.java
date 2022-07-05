/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package MultiThreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Vthread implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println("Sudheer");
        }
        System.out.println("Completed VThread");
    }
}

class Mthread implements Runnable {


    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println("Mounika");
        }
        System.out.println("MThread is complted");

    }
}

public class ThreadPoolPractice2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Thread thread1 = new Thread(new Vthread());
        Thread thread2 = new Thread(new Mthread());
        Future<?> record1 = service.submit(thread1);
        Future<?> record2 = service.submit(thread2);

        System.out.println(record1.get());
        System.out.println(record2.get());

        service.shutdown();
    }
}
