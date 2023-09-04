# 多线程交替打印算法
现在分别有3个线程，分别只能输出1，2，3。例如:请改写这些线程，让这三个线程在同时启动的情况下，永远得到 123123...的结果。

```java
public class ThreadTest {


    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.print();

    }


    public void print() {
        AtomicInteger lock = new AtomicInteger();
        new Thread(new PrintTask(1, lock)).start();
        new Thread(new PrintTask(2, lock)).start();
        new Thread(new PrintTask(3, lock)).start();
    }

    public void print1() {
        AtomicInteger lock = new AtomicInteger();
        new Thread(new PrintTask1(1, lock)).start();
        new Thread(new PrintTask1(2, lock)).start();
        new Thread(new PrintTask1(3, lock)).start();
    }


    class PrintTask implements Runnable {

        private int print;
        private AtomicInteger lock;


        public PrintTask(int print, AtomicInteger lock) {
            this.print = print;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (lock.get() / 3 == 4) {
                        break;
                    }
                    if (lock.get() % 3 != print - 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println(print);
                        lock.getAndIncrement();
                        lock.notifyAll();
                    }
                }
            }
        }
    }

    class PrintTask1 implements Runnable {

        private int print;
        private AtomicInteger lock;


        public PrintTask1(int print, AtomicInteger lock) {
            this.print = print;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (lock.get() == 10) {
                        break;
                    }
                    if (lock.get() % 3 != print - 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println(lock.get() + 1);
                        lock.getAndIncrement();
                        lock.notifyAll();
                    }
                }
            }
        }
    }


}



```