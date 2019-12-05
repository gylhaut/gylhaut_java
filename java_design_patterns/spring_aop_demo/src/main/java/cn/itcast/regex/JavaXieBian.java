package cn.itcast.regex;

import java.util.ArrayList;
import java.util.List;

public class JavaXieBian {
    public static void main(String[] args){
        new JavaXieBian().testArray();
        List<? extends Fruit> fruits = new ArrayList<Apple>();
        //fruits.add(new Apple());

    }

    public void testArray() {
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();
        try {
            fruit[0] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            fruit[0] = new Orange();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}

