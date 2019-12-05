package cn.itcast.regex;
public class StaticTest {
    public static void main(String[] args){
        A a1 = new A();
        A a2 = new B();
        a1.show();
        a2.show();
    }
}
 class A
{
    public static void show(){
        System.out.println("print A");
    }
}
class B extends A{
    public static void show(){
        System.out.println("print B");
    }
}