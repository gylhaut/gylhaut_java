import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String test = "immutable String";
        String test1 = test;
        String test2 = new String(test);
        String test3 = new String(test.toCharArray());
        Field values = String.class.getDeclaredField("value");
        values.setAccessible(true);
        char[] chars = (char[])values.get(test);
        chars[0] = 'u';
        chars[1] = 'n';
        System.out.println("test==test1:" + (test == test1));
        System.out.println("test==test2:" + (test == test2));
        System.out.println("test1==test2:" + (test1 == test2));
        System.out.println("test:" + test + "   test1:" + test1 + " test2:" + test2 + "  test3:" + test3);
    }

}
