/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package MultiThreading.ThreadInterception;

class Interception1 implements Runnable {

  public void run() {
    System.out.println("Inside the Interception1 thread");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.out.println("Interrupted Exception Handled");
    }
  }
}

public class SleepInterception {

  public static void main(String[] args) {
    Thread thread = new Thread(new Interception1());
    thread.start();
    thread.interrupt();
    System.out.println(Thread.currentThread().getPriority() + "----" + thread.getPriority());
    System.out.println("Inside the sleepInterception main method");
  }
}
