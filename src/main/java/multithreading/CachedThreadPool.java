/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CachedThreadPoolTest extends Thread {

  int i;

  CachedThreadPoolTest(int i) {
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

public class CachedThreadPool {
  public static void main(String[] args) {
    ExecutorService service = Executors.newCachedThreadPool();

    CachedThreadPoolTest thread11 = new CachedThreadPoolTest(1);
    CachedThreadPoolTest thread12 = new CachedThreadPoolTest(2);
    CachedThreadPoolTest thread111 = new CachedThreadPoolTest(3);
    CachedThreadPoolTest thread121 = new CachedThreadPoolTest(4);
    CachedThreadPoolTest thread112 = new CachedThreadPoolTest(5);
    CachedThreadPoolTest thread122 = new CachedThreadPoolTest(6);

    service.execute(thread11);
    service.execute(thread12);
    service.execute(thread111);
    service.execute(thread121);
    service.execute(thread112);
    service.execute(thread122);
  }
}
