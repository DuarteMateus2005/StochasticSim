**Discrete stochastic simulation of a tollhouse**

The code aims to study the evolution of the tollhouse queue using discrete stochastic simulation by managing vehicle arrivals, processing, and departures with random variables to model real-world unpredictability, depending on input parameters such as arrival mean, traversal mean, and payment mean.

It simulates a tollhouse system where vehicles arrive, traverse, and make payments. It uses a priority queue to manage events and schedules the next events based on exponential distributions.

Simulation flow:
1. Initialization: The simulator is initialized with mean times and total simulation time.
2. Event Scheduling: The simulator schedules the first vehicle arrival.
3. Event Processing: The simulator processes events in chronological order, handling arrivals, tollhouse processing, and departures, while continuously scheduling the next relevant events.
