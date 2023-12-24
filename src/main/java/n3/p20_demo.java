package n3;

/**
 * 检验yiled作用
 * 体验优先级对于线程运行的影响
 */
public class p20_demo {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                int count = 0;
                for (;;)
                {
                    System.out.println("--->1:+"+count++);
                }
            }
        };
        Runnable r2 = new Runnable() {
            int count = 0;
            @Override
            public void run() {

                for (;;)
                {
                    System.out.println("--->2:+"+count++);
                }
            }
        };

        Thread t1 = new Thread(r1,"t1");
        Thread t2 = new Thread(r2, "t2");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}
