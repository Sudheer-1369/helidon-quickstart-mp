package MultiThreading;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Customer{
    private int amount;

    public Customer(int amount) {
        this.amount = amount;
    }

    public synchronized void withDraw(int amount){

        System.out.println("Ready to withDraw");

        if (this.amount<amount){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Amount withdrawn");
    }

    public synchronized void deposite(int amount){

        System.out.println("Ready to deposit the money");

        this.amount += amount;
        notify();
        System.out.println("Money deposited");
    }

}
public class InterThreadCommunication{

    static Customer customer = new Customer(50000);

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        Thread thread1 = new Thread(()->{
            customer.withDraw(95000);
        });
        Thread thread2 = new Thread(()->{
            customer.deposite(20000);
        });
        executor.execute(thread1);
        executor.execute(thread2);

        executor.shutdown();
    }
}