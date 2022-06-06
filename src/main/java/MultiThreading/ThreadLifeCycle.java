package MultiThreading;

class ThreadTest implements Runnable {

    public void run() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("State of Thread1 when using join method " + ThreadLifeCycle.thread1.getState());
    }
}

public class ThreadLifeCycle implements Runnable {

    public static Thread thread1;

    public static void main(String[] args) {

        thread1 = new Thread(new ThreadLifeCycle());

        System.out.println("State of thread1 when it was created " + thread1.getState());
        thread1.start();
        System.out.println("State of thread1 when it started " + thread1.getState());

    }

    @Override
    public void run() {

        Thread thread2 = new Thread(new ThreadTest());
        thread2.start();
        System.out.println("State of Thread2 when started " + thread2.getState());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("State of thread2 when its sleeping " + thread2.getState());

        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("State of thread2 after calling the join method " + thread2.getState());
    }
}