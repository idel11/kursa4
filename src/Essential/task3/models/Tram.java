package Essential.task3.models;

public class Tram extends Transport {
    private int numberOfCars;

    public Tram(int id, String model, String numberOfPassengers,
                Driver driver, Route route, DriverQualification qualification, int numberOfCars) {
        super(id, model, numberOfPassengers, driver, route, qualification);
        this.numberOfCars = numberOfCars;
    }
}
