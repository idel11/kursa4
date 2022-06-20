package Essential.task3.repositories;

import Essential.task3.models.Transport;

import java.util.ArrayList;

public interface TransportRepo {

    public void addTransport(Transport transport);

    public ArrayList<Transport> getAllTransports();

    public void updateTransport(Transport transport);

    public void removeTransport(Transport transport);

}
