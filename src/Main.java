import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        final var lockOne = new Object();
        final var lockTwo = new Object();

        new Thread(()->{
            synchronized (lockOne){
                try {
                    System.out.println("Thread 1 acquired lockOne");
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    throw new RuntimeException();
                }
                System.out.println("thread 1 waiting for lockTwo");
                synchronized (lockTwo){
                    System.out.println(" Thread 1 acquired lockTwo!!");
                }
            }

        }).start();
        new Thread(()->{
            synchronized (lockTwo){
                try {
                    System.out.println("Thread 2 acquired lockTwo");
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    throw new RuntimeException();
                }
                System.out.println("thread 2 waiting for lockOne");
                System.out.println("deadlock is acheived as both threads are waiting for objects\n" +
                        "which are acquired by both parties\n" +
                        "i.e Thread1 has acquired Lock One and Thread 2 has acquired LockTwo.");
                synchronized (lockOne){
                    System.out.println("Thread2 acquired lockOne!!");
                }
            }

        }).start();



//        Thread 1: Acquires lock1 and then tries to acquire lock2.
//        Thread 2: Acquires lock2 and then tries to acquire lock1.

        //System.out.println("hahhahahah");


    }
}