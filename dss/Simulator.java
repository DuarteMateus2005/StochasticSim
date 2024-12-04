package dss;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Simulator implements ISimulator {
    private double currentTime = 0.0;
    private double arrivalMean;
    private double traversalMean;
    private double paymentMean;
    private double simulationTime;
    private Queue<Vehicle> tollhouseQueue = new LinkedList<>();
    private Random random = new Random();

    public Simulator(double arrivalMean, double traversalMean, double paymentMean, double simulationTime) {
        this.arrivalMean = arrivalMean;
        this.traversalMean = traversalMean;
        this.paymentMean = paymentMean;
        this.simulationTime = simulationTime;
    }

    public void startSimulation() {
        scheduleNextArrival();
        while (!EventQueue.getInstance().isEmpty() && currentTime < simulationTime) {
            Event event = EventQueue.getInstance().getNextEvent();
            currentTime = event.getTime();
            event.processEvent();
            System.out.println("Tollhouse Queue size: " + tollhouseQueue.size());
        }
    }

    private void scheduleNextArrival() {
        double nextArrivalTime = currentTime + getRandomExponential(arrivalMean);
        if (nextArrivalTime < simulationTime) {
            Vehicle vehicle = new Vehicle();
            EventQueue.getInstance().addEvent(new ArrivalEvent(nextArrivalTime, this, vehicle));
        }
    }

    public void handleArrival(ArrivalEvent event) {
        scheduleNextArrival();
        double traversalTime = getRandomExponential(traversalMean);
        EventQueue.getInstance().addEvent(new TollhouseEvent(currentTime + traversalTime, this, event.vehicle));
    }

    public void handleTollhouse(TollhouseEvent event) {
        if (tollhouseQueue.isEmpty()) {
            double paymentTime = getRandomExponential(paymentMean);
            EventQueue.getInstance().addEvent(new DepartureEvent(currentTime + paymentTime, this, event.vehicle));
        }
        tollhouseQueue.add(event.vehicle);
    }

    public void handleDeparture(DepartureEvent event) {
        tollhouseQueue.poll();
        if (!tollhouseQueue.isEmpty()) {
            Vehicle nextVehicle = tollhouseQueue.peek();
            double paymentTime = getRandomExponential(paymentMean);
            EventQueue.getInstance().addEvent(new DepartureEvent(currentTime + paymentTime, this, nextVehicle));
        }
    }

    private double getRandomExponential(double mean) {
        return -mean * Math.log(1.0 - random.nextDouble());
    }
}
