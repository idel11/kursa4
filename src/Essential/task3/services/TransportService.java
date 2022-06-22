package Essential.task3.services;

import Essential.task3.models.Route;
import Essential.task3.models.Transport;
import Essential.task3.repositories.impls.TransportRepoImpl;

import java.util.ArrayList;

public interface TransportService {

    void addTrans(TransportRepoImpl tr, Transport transport);
    void removeTrans(TransportRepoImpl tr, Transport transport);
    Transport getTransById(TransportRepoImpl tr, int id);
    ArrayList<Transport> getAllTrans(TransportRepoImpl tr);
    ArrayList<Transport> getAllTransByModel(TransportRepoImpl tr, String model);
    ArrayList<Transport> getAllTransNoDriver(TransportRepoImpl tr);
    void assignTransOnRoute(TransportRepoImpl tr, Route route);
    void removeTransFromRoute(Transport transport, Route route);

}
