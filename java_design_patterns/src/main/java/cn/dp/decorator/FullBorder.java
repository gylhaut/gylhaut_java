package cn.dp.decorator;

public  class FullBorder extends Border {
    public FullBorder(Display display) {
        super(display);
    }

    public int getColunms() {
        return display.getColunms() + 2;
    }

    public int getRows() {
        return display.getRows() + 2;
    }

    public String getTowText(int rowID) {
        if (rowID == 0) {
            return "+" + makeLine("-", display.getColunms()) + "+";
        } else if (rowID == display.getRows() + 1) {
            return "+" + makeLine("-", display.getColunms()) + "+";
        } else {
            return "|" + display.getTowText(rowID - 1) + "|";
        }
    }

    private String makeLine(String ch, int count) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}