package Essential.task3.models;

public class Bus extends Transport {
    private String type;
    private int numberOfDoors;

    public Bus(int id, String model, int numberOfPassengers,
               Driver driver, Route route, DriverQualification qualification,
               String type, int numberOfDoors) {
        super(id, model, numberOfPassengers, driver, route, qualification);
        this.type = type;
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "type='" + type + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                "id=" + super.getId() +
                ", model='" + super.getModel() + '\'' +
                ", numberOfPassengers='" + super.getNumberOfPassengers() + '\'' +
                ", driver=" + super.getDriver() +
                ", route=" + super.getRoute() +
                ", qualification=" + super.getQualification() +
                '}';
    }
}
