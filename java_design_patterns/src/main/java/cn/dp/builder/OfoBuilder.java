package cn.dp.builder;

public class OfoBuilder extends Builder {
    private Bike mBike = new Bike();
    @Override
    void buildFrame() {
        mBike.setFrame(new CarbonFrame());
    }
    @Override
    void buildSeat() {
        mBike.setSeat(new RubberSeat());
    }
    @Override
    void buildTire() {
        mBike.setTire(new InflateTire());
    }
    @Override
    Bike createBike() {
        return mBike;
    }
}
