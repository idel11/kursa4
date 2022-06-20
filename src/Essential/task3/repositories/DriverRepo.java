package Essential.task3.repositories;

import Essential.task3.models.Driver;

import java.util.ArrayList;

public interface DriverRepo {

    public void addDriver(Driver driver);

    public ArrayList<Driver> getAllDrivers();

    public void updateDriver(Driver driver);

    public void removeDriver(Driver driver);

}
