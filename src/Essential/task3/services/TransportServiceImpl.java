package Essential.task3.services;

import Essential.task3.models.Route;
import Essential.task3.models.Transport;
import Essential.task3.repositories.TransportRepoImpl;

import java.util.ArrayList;

public class TransportServiceImpl implements TransportService {
    @Override
    public void addTrans(TransportRepoImpl tr, Transport transport) {
        tr.addTransport(transport);
    }

    @Override
    public void removeTrans(TransportRepoImpl tr, Transport transport) {
        for (Transport t : tr.getAllTransports()) {
            if (t.getDriver() == null) {
                if (t.equals(transport)) {
                    tr.removeTransport(transport);
                }
            }
        }
    }

    @Override
    public Transport getTransById(TransportRepoImpl tr, int id) {
        for (Transport t : tr.getAllTransports()) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Transport> getAllTrans(TransportRepoImpl tr) {
        ArrayList<Transport> result = new ArrayList<>();
        result = tr.getAllTransports();
        return result;
    }

    @Override
    public ArrayList<Transport> getAllTransByModel(TransportRepoImpl tr, String model) {
        ArrayList<Transport> result = new ArrayList<>();
        for (Transport t : tr.getAllTransports()) {
            if (t.getModel() == model) {
                result.add(t);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Transport> getAllTransNoDriver(TransportRepoImpl tr) {
        ArrayList<Transport> result = new ArrayList<>();
        for (Transport t : tr.getAllTransports()) {
            if (t.getDriver() == null) {
                result.add(t);
            }
        }
        return result;
    }

    @Override
    public void assignTransOnRoute(TransportRepoImpl tr, Route route) {
        for (Transport t : tr.getAllTransports()) {
            if (t.getDriver() != null) {
                t.setRoute(route);
            } else System.out.println("No driver for this transport");
        }
    }

    @Override
    public void removeTransFromRoute(Transport transport, Route route) {
        if (transport.getDriver() == null) {
            if (transport.getRoute() == route) {
                transport.setRoute(null);
            } else System.out.printf("This route is not assigned to this transport");
        } else System.out.println("This route has assigned driver");
    }
}
