package cn.dp.decorator;

public class StringDisplay extends Display {
    String name;

    public StringDisplay(String name) {
        this.name = name;
    }


    public int getColunms() {
        return name.getBytes().length;
    }

    public int getRows() {
        return 1;
    }

    public String getTowText(int rowID) {
        if (rowID ==0){
            return name;
        }else {
            return null;
        }
    }
}
