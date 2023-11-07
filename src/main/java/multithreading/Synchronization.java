package multithreading;

class Sender {

  public void send(String msg) {
    synchronized (
        this) { // instead we can make the method syncronized but that effects the performance and
      // need to decide based on the situation.
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println("Sending the message " + msg);
      System.out.println("Sending the message " + msg);
      System.out.println("Sending the message " + msg);
      System.out.println("Sending the message " + msg);
      System.out.println("Sending the message " + msg);
      System.out.println("Sending the message " + msg);
      System.out.println("Sending the message " + msg);
      System.out.println("Sending the message " + msg);
    }
  }
}

class SyncSend implements Runnable {
  private final Sender sender;

  private final String msg;

  public SyncSend(Sender sender, String msg) {
    this.sender = sender;
    this.msg = msg;
  }

  @Override
  public void run() {
    //        synchronized (sender) {
    //            sender.send(msg);
    //        }

    sender.send(msg);
  }
}

public class Synchronization {
  public static Sender sender = new Sender();

  public static void main(String[] args) {
    Thread thread = new Thread(new SyncSend(sender, "Sudheer"));
    Thread thread1 = new Thread(new SyncSend(sender, "Sudheer"));

    thread.start();
    thread1.start();
  }
}
