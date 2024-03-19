import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        final var lockOne = new Object();
        final var lockTwo = new Object();

        new Thread(()->{
            synchronized (lockOne){
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    throw new RuntimeException();
                }
                synchronized (lockTwo){
                    System.out.println("both locks acquired");
                }
            }

        }).start();
        new Thread(()->{
            synchronized (lockTwo){
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    throw new RuntimeException();
                }
                synchronized (lockOne){
                    System.out.println("both locks acquired");
                }
            }

        }).start();

//        Thread 1: Acquires lock1 and then tries to acquire lock2.
//        Thread 2: Acquires lock2 and then tries to acquire lock1.

        //System.out.println("hahhahahah");


    }
}