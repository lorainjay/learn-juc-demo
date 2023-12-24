package n4;

import java.util.concurrent.locks.LockSupport;

/**
 * park 和 unpark指定执行顺序
 */
public class p80_demo {
    static boolean t2runned= false;
    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            LockSupport.park();
            System.out.println("t1执行啦");
        });
        Thread t2 = new Thread(()->{
            LockSupport.unpark(t1);
            System.out.println("t2先走一步啦");
        });


        t1.start();
        t2.start();
    }
}
