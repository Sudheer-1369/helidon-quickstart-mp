/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This code shows the work of newFixedThreadPool with size fixed which means the number of threads is fixed
 * and the others threads has to wait till one of the thread is released.
 */
class Thread11 extends Thread {

    int i;

    Thread11(int i) {
        this.i = i;
    }

    public void run() {
        int j = 0;
        while (j < 5) {
            System.out.println("Inside the Thread11 where j is " + j + "for i " + i);
            j++;
        }

        System.out.println("ThreadFor i " + i + " is completed");
    }
}

public class FixedThreadPool {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);

        Thread11 thread11 = new Thread11(1);
        Thread11 thread12 = new Thread11(2);
        Thread11 thread111 = new Thread11(3);
        Thread11 thread121 = new Thread11(4);
        Thread11 thread112 = new Thread11(5);
        Thread11 thread122 = new Thread11(6);

        service.execute(thread11);
        service.execute(thread12);
        service.execute(thread111);
        service.execute(thread121);
        service.execute(thread112);
        service.execute(thread122);

        service.shutdown();
    }

}
