package Essential.task3.models;

public class Bus extends Transport {
    private String type;
    private int numberOfDoors;

    public Bus(int id, String model, String numberOfPassengers,
               Driver driver, Route route, DriverQualification qualification,
               String type, int numberOfDoors) {
        super(id, model, numberOfPassengers, driver, route, qualification);
        this.type = type;
        this.numberOfDoors = numberOfDoors;
    }
}
