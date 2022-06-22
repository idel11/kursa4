package Essential.task3.services;

import Essential.task3.models.Driver;
import Essential.task3.models.Route;
import Essential.task3.models.Transport;
import Essential.task3.repositories.impls.DriverRepoImpl;
import Essential.task3.repositories.impls.TransportRepoImpl;

import java.util.ArrayList;

public interface DriverService {

    public void addDriver(Driver driver, DriverRepoImpl dr);

    public void removeDriver(Driver driver, DriverRepoImpl dr);

    public Driver getById(int id, DriverRepoImpl dr);

    public Driver getBySurname(String surname, DriverRepoImpl dr);

    public ArrayList<Driver> getAll(DriverRepoImpl dr);

    public ArrayList<Driver> getAllByRoute(Route route, TransportRepoImpl tr);

    public ArrayList<Transport> getTransportNoDriver(TransportRepoImpl tr);

    public void assignDriverToTransport(Transport transport, Driver driver);


}
