package dss;


class ArrivalEvent extends Event {
    public ArrivalEvent(double time, Simulator simulator, Vehicle vehicle) {
        super(time,simulator, vehicle);
    }

    @Override
    public void processEvent() {
        simulator.handleArrival(this);
    }
}

