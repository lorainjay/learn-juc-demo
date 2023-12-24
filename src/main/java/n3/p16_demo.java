package n3;

public class p16_demo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {

                System.out.println("running....");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        System.out.println(t1);

        Thread.sleep(500);
        System.out.println(t1.getState());
    }

}
