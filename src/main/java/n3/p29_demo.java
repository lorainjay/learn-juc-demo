package n3;
/**
 * 两阶段终止
 */
public class p29_demo {
    public static void main(String[] args) throws InterruptedException {

        TwoPhase tp = new TwoPhase();
        tp.start();
        Thread.sleep(3500);
        tp.stop();
    }
}
class  TwoPhase{
    private Thread monitor;

    public void start(){

        monitor = new Thread(()->{
            while (true){
                Thread currentThread = Thread.currentThread();
                if (currentThread.isInterrupted()){
                    System.out.println("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000); //会将标记设置为false；
                    System.out.println("执行监控记录");
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        });

        monitor.start();
    }

    public void stop(){
        monitor.interrupt();
    }
}
