package Essential.task3.models;

import java.util.Objects;

public class Transport {

    private int id;
    private String model;
    private int numberOfPassengers;
    private Driver driver;
    private Route route;
    private DriverQualification qualification;

    public Transport(int id, String model, int numberOfPassengers,
                     Driver driver, Route route, DriverQualification qualification) {
        this.id = id;
        this.model = model;
        this.numberOfPassengers = numberOfPassengers;
        this.driver = driver;
        this.route = route;
        this.qualification = qualification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public DriverQualification getQualification() {
        return qualification;
    }

    public void setQualification(DriverQualification qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", numberOfPassengers='" + numberOfPassengers + '\'' +
                ", driver=" + driver +
                ", route=" + route +
                ", qualification=" + qualification +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return id == transport.id && numberOfPassengers == transport.numberOfPassengers && Objects.equals(model, transport.model) && Objects.equals(driver, transport.driver) && Objects.equals(route, transport.route) && qualification == transport.qualification;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, numberOfPassengers, driver, route, qualification);
    }
}
