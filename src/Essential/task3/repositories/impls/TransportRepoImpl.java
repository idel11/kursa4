package Essential.task3.repositories.impls;

import Essential.task3.models.Transport;
import Essential.task3.repositories.TransportRepo;

import java.util.ArrayList;

public class TransportRepoImpl implements TransportRepo {


    ArrayList<Transport> array = new ArrayList<>();

    public TransportRepoImpl(ArrayList<Transport> array) {
        this.array = array;
    }

    @Override
    public void addTransport(Transport transport) {
        array.add(transport);
    }

    @Override
    public ArrayList<Transport> getAllTransports() {
        return array;
    }

    @Override
    public void updateTransport(Transport transport) {
        for (Transport t : array) {
            if (t.getId() == transport.getId()) {
                t = transport;
            }
        }
    }

    @Override
    public void removeTransport(Transport transport) {
        array.remove(transport);
    }

}
