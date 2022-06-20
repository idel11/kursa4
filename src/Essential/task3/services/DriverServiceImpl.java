package Essential.task3.services;

import Essential.task3.models.Driver;
import Essential.task3.models.Route;
import Essential.task3.models.Transport;
import Essential.task3.repositories.DriverRepoImpl;
import Essential.task3.repositories.TransportRepoImpl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DriverServiceImpl implements DriverService {

    @Override
    public void addDriver(Driver driver, @NotNull DriverRepoImpl dr) {
        dr.addDriver(driver);
    }

    @Override
    public void removeDriver(Driver driver, @NotNull DriverRepoImpl dr) {
        dr.removeDriver(driver);
    }

    @Override
    public Driver getById(int id, @NotNull DriverRepoImpl dr) {
        ArrayList<Driver> array = dr.getAllDrivers();
        for (Driver a : array) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    @Override
    public Driver getBySurname(String surname, @NotNull DriverRepoImpl dr) {
        ArrayList<Driver> array = dr.getAllDrivers();
        for (Driver a : array) {
            if (a.getSurname() == surname) {
                return a;
            }
        }
        return null;
    }

    @Override
    public void getAll(@NotNull DriverRepoImpl dr) {
        dr.getAllDrivers();
    }

    @Override
    public ArrayList<Driver> getAllByRoute(Route route, @NotNull TransportRepoImpl tr) {
        ArrayList<Driver> resultArrayDrive = new ArrayList<>();
        for (Transport t : tr.getAllTransports()) {
            if (t.getRoute() == route) {
                resultArrayDrive.add(t.getDriver());
            }
        }
        return resultArrayDrive;
    }

    @Override
    public ArrayList<Transport> getTransportNoDriver(@NotNull TransportRepoImpl tr) {
        ArrayList<Transport> result = new ArrayList<>();
        for (Transport t : tr.getAllTransports()) {
            if (t.getDriver() == null) {
                result.add(t);
            }
        }
        return result;
    }

    @Override
    public void assignDriverToTransport(TransportRepoImpl tr, DriverRepoImpl dr) {
        for (Transport t : getTransportNoDriver(tr)) {
            for (Driver d : dr.getAllDrivers()) {
                if (t.getQualification() == d.getQualification()) {
                    t.setDriver(d);
                }
            }

        }

    }

}
