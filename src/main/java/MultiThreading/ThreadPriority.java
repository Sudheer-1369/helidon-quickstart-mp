/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package MultiThreading;

class Thread1 extends Thread {

  public void run() {
    System.out.println("Inside the Thread1 class");
    System.out.println("Inside the Thread1 class");
    System.out.println("Inside the Thread1 class");
    System.out.println("Inside the Thread1 class");
    System.out.println("Inside the Thread1 class");
    System.out.println("Inside the Thread1 class");
    System.out.println("Inside the Thread1 class");
    System.out.println("Inside the Thread1 class");
    System.out.println("Inside the Thread1 class");
    System.out.println("Inside the Thread1 class");
    System.out.println("Inside the Thread1 class");
    System.out.println("Inside the Thread1 class");
  }
}

class Thread2 extends Thread {

  public void run() {
    System.out.println("Inside the Thread2 class");
  }
}

public class ThreadPriority {

  public static void main(String[] args) {
    Thread1 thread1 = new Thread1();
    Thread2 thread2 = new Thread2();

    thread1.setPriority(2);
    thread2.setPriority(10);
    thread1.start();
    thread2.start();
  }
}
