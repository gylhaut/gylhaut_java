package cn.dp.builder;

public class MobikeBuilder extends Builder {
    private Bike mBike = new Bike();
    @Override
    void buildFrame() {
        mBike.setFrame(new AlloyFrame());
    }
    @Override
    void buildSeat() {
        mBike.setSeat(new DermisSeat());
    }
    @Override
    void buildTire() {
        mBike.setTire(new SolidTire());
    }
    @Override
    Bike createBike() {
        return mBike;
    }
}
