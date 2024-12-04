package dss;

class TollhouseEvent extends Event {
    public TollhouseEvent(double time, Simulator simulator, Vehicle vehicle) {
        super(time, simulator, vehicle);
    }

    @Override
    public void processEvent() {
        simulator.handleTollhouse(this);
    }
}
