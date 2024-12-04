package main;

import dss.Simulator;

public class Main {
    public static void main(String[] args) {
        double arrivalMean = 5.0; // Mean time between arrivals
        double traversalMean = 10.0; // Mean time to traverse the tollway
        double paymentMean = 5.0; // Mean time to pay at the tollhouse
        double simulationTime = 1000.0; // Total simulation time

        Simulator simulator = new Simulator(arrivalMean, traversalMean, paymentMean, simulationTime);
        simulator.startSimulation();
    }
}
