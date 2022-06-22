package Essential.task3.services.impls;

import Essential.task3.models.Bus;
import Essential.task3.models.Driver;
import Essential.task3.models.Route;
import Essential.task3.models.Transport;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static Essential.task3.models.DriverQualification.BUS_DRIVER;
import static org.junit.jupiter.api.Assertions.*;

class TransportServiceImplTest {

    @Test
    void addTransport() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        List<Transport> actual = new ArrayList<>();
        actual.add(bus1);
        assertEquals(actual.get(0),bus1);
    }

    @Test
    void removeTransport() {
    }

    @Test
    void findTransportById() {
    }

    @Test
    void findAllTransports() {
    }

    @Test
    void findAllTransportsByModel() {
    }

    @Test
    void findAllTransportsNoDriver() {
    }

    @Test
    void assignTransportOnRoute() {
    }

    @Test
    void removeTransportFromRoute() {
    }
}