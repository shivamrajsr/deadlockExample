Explanation of the Deadlock:

Thread 1: Acquires lock1 and then tries to acquire lock2.
Thread 2: Acquires lock2 and then tries to acquire lock1.

This creates a deadlock situation because each thread is waiting for a resource 
that the other thread holds. The program will never progress further and will likely hang indefinitely.
