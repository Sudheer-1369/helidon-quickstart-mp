package MultiThreading;

import static java.lang.Thread.MAX_PRIORITY;

public class MainThread implements Runnable {

  public static void main(String[] args) {

    Thread t = Thread.currentThread();
    System.out.println("Name of main thread " + t.getName());
    System.out.println("Priority of main thread " + t.getPriority());

    t.setName("Sudheers Main");
    t.setPriority(MAX_PRIORITY);

    System.out.println("Name of the thread after change " + t.getName());
    System.out.println("Priority of the thread after change " + t.getPriority());

    Thread thread = new Thread(() -> System.out.println("Child Thread"));

    thread.start();
    System.out.println("The child thread name is " + thread.getName());
    System.out.println("The child thread priority is " + thread.getPriority());
  }

  @Override
  public void run() {
    System.out.println("Main Thread");
  }
}
