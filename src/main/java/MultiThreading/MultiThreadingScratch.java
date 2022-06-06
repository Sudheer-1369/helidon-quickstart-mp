/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package MultiThreading;

class Test implements Runnable {

    public void run() {
        System.out.println("In Test " + Thread.currentThread().getState());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class MultiThreadingScratch {
    public static void main(String[] args) throws InterruptedException {

    }
}
