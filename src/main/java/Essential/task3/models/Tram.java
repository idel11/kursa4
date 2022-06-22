package Essential.task3.models;

public class Tram extends Transport {
    private int numberOfCars;

    public Tram(int id, String model, int numberOfPassengers,
                Driver driver, Route route, DriverQualification qualification, int numberOfCars) {
        super(id, model, numberOfPassengers, driver, route, qualification);
        this.numberOfCars = numberOfCars;
    }

    @Override
    public String toString() {
        return "Tram{" +
                "numberOfCars=" + numberOfCars +
                ", id=" + super.getId() +
                ", model='" + super.getModel() + '\'' +
                ", numberOfPassengers='" + super.getNumberOfPassengers() + '\'' +
                ", driver=" + super.getDriver() +
                ", route=" + super.getRoute() +
                ", qualification=" + super.getQualification() +
                '}';
    }
}
