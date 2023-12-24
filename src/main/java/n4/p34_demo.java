package n4;

import org.openjdk.jol.info.ClassLayout;

public class p34_demo {
    public static void main(String[] args) {

        Dog d = new Dog();

        System.out.println(   ClassLayout.parseInstance(d).toPrintable(d));
    }
}
class Dog{

}
