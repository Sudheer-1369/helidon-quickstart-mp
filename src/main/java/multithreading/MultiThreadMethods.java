/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package multithreading;

class TestClass implements Runnable {

  public void run() {
    System.out.println("Inside the TestClass before sleep");
    try {
      Thread.sleep(5000);
      System.out.println("Inside the TestClass after sleep");
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}

public class MultiThreadMethods {

  public static void main(String[] args) throws InterruptedException {

    Thread thread = new Thread(new TestClass());
    thread.start();
    thread.join();

    System.out.println("Testing sleep");
  }
}
