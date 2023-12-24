package n3;

import java.util.concurrent.locks.LockSupport;

import static java.lang.Thread.sleep;

/**
 * park：在打断标记为true时失效
 */
public class p31_demo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("park.....");
            LockSupport.park();
            System.out.println("unpark");
            LockSupport.park();
            System.out.println("unpark");
        });


        t1.start();
        sleep(3000);

        t1.interrupt();
    }



}
