package n3;

public class p26_demo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            while (true){
                boolean flag = Thread.currentThread().isInterrupted();
                if (flag){
                    System.out.println("被打断了。。。。");
                    break;
                }
            }

        },"t1");

        t1.start();
        Thread.sleep(1000);
        System.out.println("interupt...");
        t1.interrupt();
        System.out.println("结束。。。");
    }
}
