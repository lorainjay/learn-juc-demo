package n3;

public class p33_demo {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            while (true){
                System.out.println("根本停不下来");
            }
        });
        t.setDaemon(true);
        t.start();
        System.out.println("主线程结束啦");

    }
}
