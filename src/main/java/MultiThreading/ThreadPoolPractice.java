/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package MultiThreading;

import InterceptorForThreads.AroundThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.enterprise.context.ApplicationScoped;

class Rthread implements Runnable {

  @Override
  public void run() {

    for (int i = 0; i < 5; i++) {
      System.out.println("Sudheer");
    }
    System.out.println("Sudheer loves Sudheer");
  }
}

class Sthread implements Runnable {

  String msg;

  public Sthread(String msg) {
    this.msg = msg;
  }

  @Override
  public void run() {

    for (int i = 0; i < 5; i++) {
      System.out.println(msg);
    }
    System.out.println("Manu loves " + msg);
  }
}

@ApplicationScoped
public class ThreadPoolPractice {

  @AroundThread
  public static void main(String[] args) throws Exception {
    ExecutorService service = Executors.newFixedThreadPool(2);
    //        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
    Thread thread1 = new Thread(new Sthread("Sudheer"));
    Thread thread2 = new Thread(new Sthread("Sudheer"));

    service.execute(thread1);
    service.execute(thread2);

    service.shutdown();
    Thread thread3 = new Thread(new Sthread("Venkar"));
    service.execute(thread3); // This one will be rejected since service is shutdown

    if (service.awaitTermination(1, TimeUnit.NANOSECONDS)) {
      System.out.println("The service is shutdown");
    } else {
      System.out.println("The service is still on");
    }

    //        ScheduledExecutorService scheduledExecutorService =
    //                Executors.newScheduledThreadPool(5);
    //
    //        ScheduledFuture scheduledFuture =
    //                scheduledExecutorService.schedule(
    //                        () -> {
    //                            System.out.println("Executed!");
    //                            return "Called!";
    //                        }
    //                        ,
    //                        5,
    //                        TimeUnit.SECONDS);
    //
    //        scheduledFuture.cancel(true);
    ////        System.out.println("result = " + scheduledFuture.get());
    //
    //        scheduledExecutorService.shutdown();
  }
}
