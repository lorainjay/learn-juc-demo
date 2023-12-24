package n4;

public class p67_demo
{
	public static void main(String[] args) {
		final Object A = new Object();
		final Object B = new Object();
		new Thread(()->{
			synchronized (A) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (B) {

				}
			}
		}).start();

		new Thread(()->{
			synchronized (B) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (A) {

				}
			}
		}).start();
	}

}
