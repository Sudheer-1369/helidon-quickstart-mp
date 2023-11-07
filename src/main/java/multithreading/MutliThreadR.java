/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package multithreading;

class MultiThreadDemoR implements Runnable {

  int i = 0;

  @Override
  public void run() {
    i++;
    System.out.println("i is---" + i);
    System.out.println(
        "The thread with id "
            + Thread.currentThread().getId()
            + ", and name "
            + Thread.currentThread().getName()
            + " is running");
  }
}

public class MutliThreadR {

  public static void main(String[] args) {

    int n = 8;
    //        MultiThreadDemoR mdr = new MultiThreadDemoR();
    // We can share a single instance of the object implementing the runnable interface and it works
    // fine but issue only comes when there exists any static variables
    for (int i = 0; i < n; i++) {
      Thread object = new Thread(new MultiThreadDemoR());
      object.start();
    }
  }
}
