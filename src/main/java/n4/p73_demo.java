package n4;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class p73_demo {

    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        Thread t1  = new Thread(()->{
            try {
                System.out.println("尝试获取锁");
//                lock.lockInterruptibly();
                lock.lock();
            } catch (Exception e) {
                e.printStackTrace();
            }

//            } catch (InterruptedException e) {
//                System.out.println("获取不到锁");
//                e.printStackTrace();
//                return;
//            }
            System.out.println("获取到锁");
            lock.unlock();
        });


        lock.lock();
        t1.start();
        sleep(1000);
        t1.interrupt();
    }

}
