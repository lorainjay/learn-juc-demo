package n4;

import static java.lang.Thread.sleep;

public class p12_demo {
    public static void main(String[] args) {

        n1 n = new n1();
        n1 nn = new n1();
        new Thread(() -> {
            System.out.println("1---begin");
            try {
                n.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println("2---begin");
            nn.b();
        }).start();
    }

}
class n1{
    public synchronized  void a() throws InterruptedException {

        System.out.println("1");
    }

    public synchronized   void b(){
        System.out.println("2");
    }
}
