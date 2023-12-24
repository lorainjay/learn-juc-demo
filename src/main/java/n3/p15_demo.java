package n3;

public class p15_demo {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                System.out.println("running....");
            }
        };
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
    }
}
