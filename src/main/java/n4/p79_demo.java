package n4;

public class p79_demo {
    static boolean t2runned= false;
    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(()->{
            synchronized (lock) {
                while (!t2runned) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("轮到t1执行啦");
            }
        });
        Thread t2 = new Thread(()->{
            synchronized (lock) {
                System.out.println("t2执行啦");
                t2runned =true;
                lock.notify();
            }
        });


        t1.start();
        t2.start();
    }
}
