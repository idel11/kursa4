package Essential.task3.services;

import Essential.task3.models.Route;
import Essential.task3.models.Transport;

import java.util.List;

public interface TransportService {

    public Transport addTransport(Transport transport);

    public Transport removeTransport(Transport transport);

    public Transport findTransportById(int id);

    public List<Transport> findAllTransports();

    public List<Transport> findAllTransportsByModel(String model);

    public List<Transport> findAllTransportsNoDriver();

    public Transport assignTransportOnRoute(Transport transport, Route route);

    public Transport removeTransportFromRoute(Transport transport, Route route);


}
