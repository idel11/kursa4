package Essential.task3.repositories.impls;

import Essential.task3.models.Driver;
import Essential.task3.repositories.DriverRepo;


import java.util.List;

public class DriverRepoImpl implements DriverRepo {

    private final List<Driver> array;

    public DriverRepoImpl(List<Driver> array) {
        this.array = array;
    }

    @Override
    public Driver add(Driver driver) {
        array.add(driver);
        return driver;
    }

    @Override
    public List<Driver> getAll() {
        return array;
    }

    @Override
    public Driver update(Driver driver) {
        for (Driver d : array) {
            if (d.getId() == driver.getId()) {
                d = driver;
            }
        } return driver;
    }

    @Override
    public Driver remove(Driver driver) {
        array.remove(driver);
        return driver;
    }
}
