package Essential.task3.repositories.impls;

import Essential.task3.repositories.TransportRepo;
import Essential.task3.models.Transport;
import java.util.List;

public class TransportRepoImpl implements TransportRepo {


    private final List<Transport> array;

    public TransportRepoImpl(List<Transport> array) {
        this.array = array;
    }

    @Override
    public Transport add(Transport transport) {
        array.add(transport);
        return transport;
    }

    @Override
    public List<Transport> getAll() {
        return array;
    }

    @Override
    public Transport update(Transport transport) {
        for (Transport t : array) {
            if (t.getId() == transport.getId()) {
                t = transport;
            }
        } return transport;
    }

    @Override
    public Transport remove(Transport transport) {
        array.remove(transport);
        return transport;
    }

}
