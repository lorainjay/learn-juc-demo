package n4;

import java.util.concurrent.locks.ReentrantLock;

public class p72_demo {
    private static ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {

        reentrantLock.lock();
        try {
            System.out.println("main eating。。。。");
            m1();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void m1(){
        reentrantLock.lock();
        try {
            m2();
            System.out.println("m1 eating。。。。");
        } finally {
            reentrantLock.unlock();
        }
    }

    private static void m2() {
        reentrantLock.lock();
        try {
            System.out.println("m2 eating。。。。");
        } finally {
            reentrantLock.unlock();
        }
    }

}
