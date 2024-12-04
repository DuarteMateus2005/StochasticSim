package dss;

class Vehicle {
    private static int idCounter = 0;
    private int id;

    public Vehicle() {
        this.id = ++idCounter;
    }

    public int getId() {
        return id;
    }
}

