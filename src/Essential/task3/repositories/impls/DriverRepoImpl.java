package Essential.task3.repositories.impls;

import Essential.task3.models.Driver;
import Essential.task3.repositories.DriverRepo;

import java.util.ArrayList;

public class DriverRepoImpl implements DriverRepo {

    ArrayList<Driver> array = new ArrayList<>();

    public DriverRepoImpl(ArrayList<Driver> array) {
        this.array = array;
    }

    @Override
    public void addDriver(Driver driver) {
        array.add(driver);
    }

    @Override
    public ArrayList<Driver> getAllDrivers() {
        return array;
    }

    @Override
    public void updateDriver(Driver driver) {
        for (Driver d : array) {
            if (d.getId() == driver.getId()) {
                d = driver;
            }
        }
    }

    @Override
    public void removeDriver(Driver driver) {
        array.remove(driver);
    }
}
