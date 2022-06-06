/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package MultiThreading;

import java.util.Scanner;

class MultiThreadDemoT extends Thread {

    private int i;

    MultiThreadDemoT(int i) {
        this.i = i;
    }

    public void run() {
        System.out.println("i is---" + Thread.currentThread().getId());
        System.out.println("The thread with id " + Thread.currentThread().getId() + ", and name " + Thread.currentThread().getName() + " is running");
        System.out.println("i is " + Thread.currentThread().getId());
    }
}

public class MultiThreadT {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 4;
        Thread[] threads = new Thread[n];
        for (int i = 0; i < n; i++) {
            threads[i] = new MultiThreadDemoT(i);
            threads[i].start();
        }
    }
}
