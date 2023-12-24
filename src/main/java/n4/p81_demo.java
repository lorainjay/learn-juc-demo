package n4;

/**
 * 交替打印
 */
public class p81_demo {
    public static void main(String[] args) {
        WaitAndNotify waitAndNotify = new WaitAndNotify(1, 5);
        new Thread(()->{
            waitAndNotify.run("a", 1, 2);
        }).start();
        new Thread(()->{
            waitAndNotify.run("b", 2, 3);
        }).start();
        new Thread(()->{
            waitAndNotify.run("c", 3, 1);
        }).start();
    }

}

class WaitAndNotify{

    public void run(String str, int flag, int nextFlag){
        for (int i = 0; i < loopNumber; i++) {

            synchronized (this){
                while (this.flag != flag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(str);
                this.flag  = nextFlag;
                this.notifyAll();
            }

        }
    }

    private int flag ;

    private int loopNumber;

    public WaitAndNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }
}
