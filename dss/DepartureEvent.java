package dss;

class DepartureEvent extends Event {
    public DepartureEvent(double time, Simulator simulator, Vehicle vehicle) {
        super(time, simulator, vehicle);
    }

    @Override
    public void processEvent() {
        simulator.handleDeparture(this);
    }
}
