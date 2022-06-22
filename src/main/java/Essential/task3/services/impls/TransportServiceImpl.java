package Essential.task3.services.impls;

import Essential.task3.models.Route;
import Essential.task3.models.Transport;
import Essential.task3.repositories.TransportRepo;
import Essential.task3.services.TransportService;

import java.util.ArrayList;
import java.util.List;

public class TransportServiceImpl implements TransportService {

    private TransportRepo transportRepo;

    public TransportServiceImpl(TransportRepo transportRepo) {
        this.transportRepo = transportRepo;
    }

    @Override
    public Transport addTransport(Transport transport) {
        transportRepo.add(transport);
        return transport;
    }

    @Override
    public Transport removeTransport(Transport transport) {
        for (Transport t : transportRepo.getAll()) {
            if (t.getDriver() == null) {
                if (t.equals(transport)) {
                    transportRepo.remove(transport);
                }
            }
        } return transport;
    }

    @Override
    public Transport findTransportById(int id) {
        for (Transport t : transportRepo.getAll()) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    @Override
    public List<Transport> findAllTransports() {
        List<Transport> result = new ArrayList<>();
        result = transportRepo.getAll();
        return result;
    }

    @Override
    public List<Transport> findAllTransportsByModel(String model) {
        List<Transport> result = new ArrayList<>();
        for (Transport t : transportRepo.getAll()) {
            if (t.getModel() == model) {
                result.add(t);
            }
        }
        return result;
    }

    @Override
    public List<Transport> findAllTransportsNoDriver() {
        List<Transport> result = new ArrayList<>();
        for (Transport t : transportRepo.getAll()) {
            if (t.getDriver() == null) {
                result.add(t);
            }
        }
        return result;
    }

    @Override
    public Transport assignTransportOnRoute(Route route) {
        for (Transport t : transportRepo.getAll()) {
            if (t.getDriver() != null) {
                t.setRoute(route);
                return t;
            } else System.out.println("No driver for this transport");
        } return null;
    }

    @Override
    public Transport removeTransportFromRoute(Transport transport, Route route) {
        if (transport.getDriver() == null) {
            if (transport.getRoute() == route) {
                transport.setRoute(null);
                return transport;
            } else System.out.printf("This route is not assigned to this transport");
        } else System.out.println("This route has assigned driver");
        return null;
    }
}
