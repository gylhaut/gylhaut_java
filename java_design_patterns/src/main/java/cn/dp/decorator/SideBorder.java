package cn.dp.decorator;

public class SideBorder extends Border {
    String ch;

    protected SideBorder(Display display, String ch) {
        super(display);
        this.ch = ch;
    }

    public int getColunms() {
        return display.getColunms()+2;
    }

    public int getRows() {
        return display.getRows();
    }

    public String getTowText(int rowID) {
        return ch+display.getTowText(rowID)+ch;
    }
}
