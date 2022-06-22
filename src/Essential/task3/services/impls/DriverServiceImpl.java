package Essential.task3.services.impls;

import Essential.task3.models.Driver;
import Essential.task3.models.Route;
import Essential.task3.models.Transport;
import Essential.task3.repositories.impls.DriverRepoImpl;
import Essential.task3.repositories.impls.TransportRepoImpl;
import Essential.task3.services.DriverService;

import java.util.ArrayList;

public class DriverServiceImpl implements DriverService {

    @Override
    public void addDriver(Driver driver, DriverRepoImpl dr) {
        dr.addDriver(driver);
    }

    @Override
    public void removeDriver(Driver driver, DriverRepoImpl dr) {
        dr.removeDriver(driver);
    }

    @Override
    public Driver getById(int id, DriverRepoImpl dr) {
        ArrayList<Driver> array = dr.getAllDrivers();
        for (Driver a : array) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    @Override
    public Driver getBySurname(String surname, DriverRepoImpl dr) {
        ArrayList<Driver> array = dr.getAllDrivers();
        for (Driver a : array) {
            if (a.getSurname() == surname) {
                return a;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Driver> getAll(DriverRepoImpl dr) {
        ArrayList<Driver> result = dr.getAllDrivers();
        return result;
    }

    @Override
    public ArrayList<Driver> getAllByRoute(Route route, TransportRepoImpl tr) {
        ArrayList<Driver> resultArrayDrive = new ArrayList<>();
        for (Transport t : tr.getAllTransports()) {
            if (t.getRoute() == route) {
                resultArrayDrive.add(t.getDriver());
            }
        }
        return resultArrayDrive;
    }

    @Override
    public ArrayList<Transport> getTransportNoDriver(TransportRepoImpl tr) {
        ArrayList<Transport> result = new ArrayList<>();
        for (Transport t : tr.getAllTransports()) {
            if (t.getDriver() == null) {
                result.add(t);
            }
        }
        return result;
    }

    @Override
    public void assignDriverToTransport(Transport transport, Driver driver) {
        if(transport.getQualification() == driver.getQualification()){
            transport.setDriver(driver);
        } else System.out.println("The qualification of driver doesn't correspond to transport");

    }

}
