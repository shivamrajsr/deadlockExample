import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        final var objOne = new Object();
        final var objTwo = new Object();

        new Thread(()->{
            synchronized (objOne){
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    throw new RuntimeException();
                }
                synchronized (objTwo){
                    System.out.println("both locks acquired");
                }
            }

        }).start();
        new Thread(()->{
            synchronized (objTwo){
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    throw new RuntimeException();
                }
                synchronized (objOne){
                    System.out.println("both locks acquired");
                }
            }

        }).start();

//        Thread 1: Acquires lock1 and then tries to acquire lock2.
//        Thread 2: Acquires lock2 and then tries to acquire lock1.

        //System.out.println("hahhahahah");


    }
}