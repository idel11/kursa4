package Essential.task3.models;

public class Transport {

    private int id;
    private String model;
    private String numberOfPassengers;
    private Driver driver;
    private Route route;
    private DriverQualification qualification;

    public Transport(int id, String model, String numberOfPassengers,
                     Driver driver, Route route, DriverQualification qualification) {
        this.id = id;
        this.model = model;
        this.numberOfPassengers = numberOfPassengers;
        this.driver = driver;
        this.route = route;
        this.qualification = qualification;
    }
}
