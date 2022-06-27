package Essential.task3.services.impls;

import Essential.task3.models.*;
import Essential.task3.repositories.TransportRepo;
import Essential.task3.repositories.impls.TransportRepoImpl;
import Essential.task3.services.TransportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static Essential.task3.models.DriverQualification.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TransportServiceImplTest {
    static Driver driver1;
    static Driver driver2;
    static Route firstRoute;
    static Route secondRoute;
    static Transport bus1;
    static Transport tram2;
    static Transport tram3;
    static Transport tram4;
    static List<Transport> transports;
    static TransportRepo transportRepo;
    static TransportService transportService;


    @BeforeEach
    public void init(){
        driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        driver2 = new Driver(2, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        firstRoute = new Route(1, "Kyiv", "Poltava");
        secondRoute = new Route(2, "Odesa", "Lviv");
        bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        tram2 = new Tram(3, "euro", 60, driver2,
                secondRoute, TRAM_DRIVER, 4);
        tram3 = new Tram(3, "xxx", 60, null,
                secondRoute, TRAM_DRIVER, 4);
        tram4 = new Tram(3, "yyy", 60, driver2,
                null, TRAM_DRIVER, 4);
        transports = new ArrayList<>();
        transports.add(bus1);
        transports.add(tram2);
        transports.add(tram3);
        transports.add(tram4);
        transportRepo = new TransportRepoImpl(transports);
        transportService = new TransportServiceImpl(transportRepo);
    }

    @Test
    void addTransport() {
        assertEquals(tram2, transportService.addTransport(tram2));
    }

    @Test
    void removeTransport() {
        assertEquals(bus1, transportService.removeTransport(bus1));
    }

    @Test
    void findTransportById() {
        assertEquals(bus1, transportService.findTransportById(1));
    }

    @Test
    void findAllTransports() {
        assertEquals(transports, transportService.findAllTransports());
    }

    @Test
    void findAllTransportsByModel() {
        List<Transport> transports2 = new ArrayList<>();
        List<Transport> transports1 = new ArrayList<>();
        transports1.add(bus1);
        transports2.add(tram2);
        assertEquals(transportService.findAllTransportsByModel("ikarus"), transports1);
        assertEquals(transportService.findAllTransportsByModel("euro"), transports2);
    }

    @Test
    void findAllTransportsNoDriver() {
        List<Transport> expected = new ArrayList<>();
        expected.add(tram3);
        assertEquals(expected, transportService.findAllTransportsNoDriver());
    }

    @Test
    void assignTransportOnRoute() {
        assertEquals(null,transportService.assignTransportOnRoute(tram3, firstRoute));
        assertEquals(transportService.assignTransportOnRoute(tram4, firstRoute), tram4);
    }

    @Test
    void removeTransportFromRoute() {
        Transport tram5 = new Tram(3, "euro", 60, driver2,
                null, TRAM_DRIVER, 4);
        assertEquals(null, transportService.removeTransportFromRoute(bus1, secondRoute));
        assertEquals(tram5, transportService.removeTransportFromRoute(tram2, secondRoute));
    }
}