package cn.dp.decorator;

public class Main {
    public static void main(String[] args) {
        Display d1 = new StringDisplay("张三");
        d1.show();
        System.out.println("\n");
        Display d2 = new SideBorder(d1, "*");
        d2.show();
        System.out.println("\n");
        Display d3 = new FullBorder(d2);
        d3.show();
        System.out.println("\n");
        Display d4 = new SideBorder(
                new FullBorder(new FullBorder(new SideBorder(new FullBorder(
                        new StringDisplay("李四")
                ),"#"))),"*"
        );
        d4.show();


    }
}
