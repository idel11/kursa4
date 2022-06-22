package Essential.task3.services.impls;

import Essential.task3.models.*;
import Essential.task3.repositories.TransportRepo;
import Essential.task3.repositories.impls.TransportRepoImpl;
import Essential.task3.services.TransportService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static Essential.task3.models.DriverQualification.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TransportServiceImplTest {

    @Test
    void addTransport() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        List<Transport> transports = new ArrayList<>();
        TransportRepo transportRepo = new TransportRepoImpl(transports);
        TransportService transportService = new TransportServiceImpl(transportRepo);
        assertEquals(transportService.addTransport(bus1), bus1);
    }

    @Test
    void removeTransport() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        List<Transport> transports = new ArrayList<>();
        TransportRepo transportRepo = new TransportRepoImpl(transports);
        TransportService transportService = new TransportServiceImpl(transportRepo);
        transportService.addTransport(bus1);
        assertEquals(transportService.removeTransport(bus1), bus1);
    }

    @Test
    void findTransportById() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        List<Transport> transports = new ArrayList<>();
        TransportRepo transportRepo = new TransportRepoImpl(transports);
        TransportService transportService = new TransportServiceImpl(transportRepo);
        transportService.addTransport(bus1);
        assertEquals(transportService.findTransportById(1), bus1);
    }

    @Test
    void findAllTransports() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Driver driver2 = new Driver(2, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        Transport tram2 = new Tram(3, "euro", 60, driver2,
                secondRoute, TRAM_DRIVER, 4);
        List<Transport> transports = new ArrayList<>();
        TransportRepo transportRepo = new TransportRepoImpl(transports);
        TransportService transportService = new TransportServiceImpl(transportRepo);
        transportService.addTransport(bus1);
        transportService.addTransport(tram2);
        assertEquals(transportService.findAllTransports(), transports);
    }

    @Test
    void findAllTransportsByModel() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Driver driver2 = new Driver(2, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        Transport tram2 = new Tram(3, "euro", 60, driver2,
                secondRoute, TRAM_DRIVER, 4);
        List<Transport> transports = new ArrayList<>();
        List<Transport> transports2 = new ArrayList<>();
        List<Transport> transports1 = new ArrayList<>();
        TransportRepo transportRepo = new TransportRepoImpl(transports);
        TransportService transportService = new TransportServiceImpl(transportRepo);
        transportService.addTransport(bus1);
        transportService.addTransport(tram2);
        transports1.add(bus1);
        transports2.add(tram2);
        assertEquals(transportService.findAllTransportsByModel("ikarus"), transports1);
        assertEquals(transportService.findAllTransportsByModel("euro"), transports2);
    }

    @Test
    void findAllTransportsNoDriver() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Driver driver2 = new Driver(2, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Transport bus1 = new Bus(1, "ikarus", 40, null,
                firstRoute, BUS_DRIVER, "pass", 2);
        Transport tram2 = new Tram(3, "euro", 60, driver2,
                secondRoute, TRAM_DRIVER, 4);
        List<Transport> transports = new ArrayList<>();
        transports.add(bus1);
        transports.add(tram2);
        TransportRepo transportRepo = new TransportRepoImpl(transports);
        TransportService transportService = new TransportServiceImpl(transportRepo);
        List<Transport> actual1 = new ArrayList<>();
        actual1.add(bus1);
        assertEquals(transportService.findAllTransportsNoDriver(), actual1);
    }

    @Test
    void assignTransportOnRoute() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Transport bus1 = new Bus(1, "ikarus", 40, null,
                null, BUS_DRIVER, "pass", 2);
        List<Transport> transports = new ArrayList<>();
        transports.add(bus1);
        TransportRepo transportRepo = new TransportRepoImpl(transports);
        TransportService transportService = new TransportServiceImpl(transportRepo);
        assertEquals(transportService.assignTransportOnRoute(bus1, firstRoute), null);
        Transport bus2 = new Bus(1, "ikarus", 40, driver1,
                null, BUS_DRIVER, "pass", 2);
        assertEquals(transportService.assignTransportOnRoute(bus2, firstRoute), bus2);
    }

    @Test
    void removeTransportFromRoute() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        Transport bus2 = new Bus(1, "ikarus", 40, driver1,
                null, BUS_DRIVER, "pass", 2);
        List<Transport> transports = new ArrayList<>();
        transports.add(bus1);
        TransportRepo transportRepo = new TransportRepoImpl(transports);
        TransportService transportService = new TransportServiceImpl(transportRepo);
        assertEquals(transportService.removeTransportFromRoute(bus1, secondRoute), null);
        assertEquals(transportService.removeTransportFromRoute(bus1, firstRoute), bus2);
    }
}