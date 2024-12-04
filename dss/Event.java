package dss;



abstract class Event implements IEvent, Comparable<Event> {
    protected double time;
    protected Vehicle vehicle;
    protected Simulator simulator;

    public Event(double time, Simulator simulator, Vehicle vehicle) {
        this.time = time;
        this.simulator = simulator;
        this.vehicle = vehicle;
    }

    public double getTime() {
        return time;
    }

    public abstract void processEvent();

    @Override
    public int compareTo(Event other) {
        return Double.compare(this.time, other.time);
    }
}








