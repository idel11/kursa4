package Essential.task3.services;

import Essential.task3.models.Driver;
import Essential.task3.models.Route;
import Essential.task3.models.Transport;
import java.util.List;

public interface DriverService {

    public Driver addDriver(Driver driver);
    public Driver removeDriver(Driver driver);
    public Driver findDriverById(int id);
    public Driver findDriverBySurname(String surname);
    public List<Driver> findAllDrivers();
    public List<Driver> findAllDriversByRoute(Route route);
    public List<Transport> findTransportNoDriver();
    public Driver assignDriverToTransport(Transport transport, Driver driver);


}
