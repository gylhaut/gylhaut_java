package cn.dp.decorator;

public abstract class Display {
    public abstract int getColunms();
    public abstract int getRows();
    public abstract String getTowText(int rowID);
    public void show(){
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getTowText(i));
        }
    }

}
