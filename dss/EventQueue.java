package dss;

import java.util.PriorityQueue;
import java.util.Queue;

class EventQueue {
    private static EventQueue instance;
    private Queue<Event> queue;

    private EventQueue() {
        queue = new PriorityQueue<>();
    }

    public static EventQueue getInstance() {
        if (instance == null) {
            instance = new EventQueue();
        }
        return instance;
    }

    public void addEvent(Event event) {
        queue.add(event);
    }

    public Event getNextEvent() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

