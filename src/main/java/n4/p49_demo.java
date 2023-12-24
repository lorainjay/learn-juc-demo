package n4;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import static java.lang.Thread.sleep;

/**
 * 实现设计模式-保护性暂停
 */
public class p49_demo {
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            new People().start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Integer id : MailBoxes.getIds()) {
            new Postman(id, "内容 " + id).start();
        }
    }
}

class People extends Thread {

    @Override
    public void run() {
        GuardObject guardedObject = MailBoxes.createGuardedObject();
        System.out.println("开始收信id为: " +  guardedObject.getId());
        Object o = null;
        try {
            o = guardedObject.getObject(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("收信的id为: " +  guardedObject.getId()+"内容为："+ o);
    }
}

class Postman extends Thread {

    private int id;
    private String mail;

    public Postman(int id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    @Override
    public void run() {
        GuardObject guardedObject = MailBoxes.getGuardedObject(id);
        System.out.println("送信的id: "+ id+ "内容： "+mail );
        try {
            guardedObject.Complete(mail);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MailBoxes{
    private static int id = 1;
    private static Map<Integer, GuardObject> boxes = new Hashtable<>();

    public static synchronized int generateId() {
        return id++;
    }

    // 用户会进行投信
    public static GuardObject createGuardedObject() {
        GuardObject guardedObject = new GuardObject(generateId());
        boxes.put(guardedObject.getId(), guardedObject);
        return guardedObject;
    }

    // 派件员会派发信
    public static GuardObject getGuardedObject(int id) {
        return boxes.remove(id);
    }

    public static Set<Integer> getIds() {
        return boxes.keySet();
    }
}
class GuardObject{
    private int id;

    public GuardObject(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }


    public Object response;

    public Object getObject(long timeOut) throws InterruptedException {

        synchronized (this){
            long startTime = System.currentTimeMillis();
            long passedTime = 0;
            while (response == null){
                long waitTime = timeOut - passedTime;
                if (waitTime <= 0) {
                    System.out.println("线程1等待超时");
                    break;
                }
                this.wait(waitTime);
                passedTime = System.currentTimeMillis() - startTime;
            }
            return response;
        }
    }

    public void Complete(Object response) throws InterruptedException {
        sleep(20000);
        synchronized (this){
            this.response = response;
            this.notifyAll();
        }
    }
}
