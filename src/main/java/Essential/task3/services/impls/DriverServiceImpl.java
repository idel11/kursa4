package Essential.task3.services.impls;

import Essential.task3.models.Driver;
import Essential.task3.models.Route;
import Essential.task3.models.Transport;
import Essential.task3.repositories.DriverRepo;
import Essential.task3.repositories.TransportRepo;
import Essential.task3.services.DriverService;

import java.util.ArrayList;
import java.util.List;

public class DriverServiceImpl implements DriverService {

    private DriverRepo driverRepo;
    private TransportRepo transportRepo;

    public DriverServiceImpl(DriverRepo driverRepo, TransportRepo transportRepo) {
        this.driverRepo = driverRepo;
        this.transportRepo = transportRepo;
    }

    @Override
    public Driver addDriver(Driver driver) {
        driverRepo.add(driver);
        return driver;
    }

    @Override
    public Driver removeDriver(Driver driver) {
        int k = 0;
        for (Transport t : transportRepo.getAll()) {
            if (t.getDriver() == driver) {
                k++;
            }
        }
        if (k == 0) {
            driverRepo.remove(driver);
            return driver;
        } else {
            System.out.println("Driver is assigned on transport");
        }
        return null;
    }

    @Override
    public Driver findDriverById(int id) {
        List<Driver> array = driverRepo.getAll();
        for (Driver a : array) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    @Override
    public Driver findDriverBySurname(String surname) {
        List<Driver> array = driverRepo.getAll();
        for (Driver a : array) {
            if (a.getSurname() == surname) {
                return a;
            }
        }
        return null;
    }

    @Override
    public List<Driver> findAllDrivers() {
        List<Driver> result = driverRepo.getAll();
        return result;
    }

    @Override
    public List<Driver> findAllDriversByRoute(Route route) {
        List<Driver> resultArrayDrive = new ArrayList<>();
        for (Transport t : transportRepo.getAll()) {
            if (t.getRoute() == route) {
                resultArrayDrive.add(t.getDriver());
            }
        }
        return resultArrayDrive;
    }

    @Override
    public List<Transport> findTransportNoDriver() {
        List<Transport> result = new ArrayList<>();
        for (Transport t : transportRepo.getAll()) {
            if (t.getDriver() == null) {
                result.add(t);
            }
        }
        return result;
    }

    @Override
    public Driver assignDriverToTransport(Transport transport, Driver driver) {
        if (transport.getQualification() == driver.getQualification()) {
            transport.setDriver(driver);
            return driver;
        } else {
            System.out.println("The qualification of driver doesn't correspond to transport");
            return null;
        }
    }

}
