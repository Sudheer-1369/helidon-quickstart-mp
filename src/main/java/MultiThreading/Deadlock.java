/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package MultiThreading;

class Util {

  static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class Shared {

  synchronized void test1(Shared s2) {
    System.out.println("test1-begin");
    Util.sleep(1000);

    s2.test2();
    System.out.println("test1-end");
  }

  synchronized void test2() {
    System.out.println("test2-begin");
    Util.sleep(1000);

    System.out.println("test2-end");
  }
}

class Threadx1 extends Thread {
  private final Shared s1;
  private final Shared s2;

  public Threadx1(Shared s1, Shared s2) {
    this.s1 = s1;
    this.s2 = s2;
  }

  @Override
  public void run() {

    s1.test1(s2);
  }
}

class Threadx2 extends Thread {
  private final Shared s1;
  private final Shared s2;

  public Threadx2(Shared s1, Shared s2) {
    this.s1 = s1;
    this.s2 = s2;
  }

  @Override
  public void run() {

    s2.test1(s1);
  }
}

public class Deadlock {
  public static void main(String[] args) {

    Shared s1 = new Shared();

    Shared s2 = new Shared();

    Threadx1 t1 = new Threadx1(s1, s2);
    t1.start();

    Threadx2 t2 = new Threadx2(s1, s2);
    t2.start();

    Util.sleep(2000);
  }
}
