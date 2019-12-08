package cn.dp.util;

class ConstClass{
    static {
        System.out.println("ConstClass init!");
    }
    public static final String HELLOWORD ="hello world";
}

public class NotInitalization {
    public static void main(String[] args){
        System.out.println(ConstClass.HELLOWORD);
//        SuperClass[] cs = new SuperClass[10];
//        Integer i = cs.length;

       // System.out.println(SubClass.value);
    }
}
