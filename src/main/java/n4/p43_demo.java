package n4;




import static java.lang.Thread.sleep;

/**
 * sleep和wait区别
 */

public class p43_demo {
    static final Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (obj) {
                System.out.println("1获得锁");
                try {
                   obj.wait();//可以被取代锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        sleep(500);
        synchronized (obj) {
            System.out.println("2获得锁");
        }
    }
}
