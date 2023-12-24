package n4;

public class p22_demo {
    public static void main(String[] args) {

        TicketWindow window = new TicketWindow(1000);
        for (int i = 0; i < 2000; i++) {
            Thread thread = new Thread(()->{

            });

        }
    }
}

class TicketWindow{
    private int count;

    public TicketWindow(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int sell(int amount){
        if(this.count > amount){
            this.count -= amount;
            return this.count;
        }else return 0;
    }
}
