package n3;


public class demo1_createThread {
    public static void main(String[] args) {

        Thread t = new Thread(){
            @Override
            public void run(){

                System.out.println("running");
            }
        };
        t.start();


        Runnable r = ()-> System.out.println("running22");
        Thread t2 = new Thread(r);
        t2.start();
    }

}
