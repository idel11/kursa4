package Essential.task3.services.impls;

import Essential.task3.models.*;
import Essential.task3.repositories.RouteRepo;
import Essential.task3.repositories.TransportRepo;
import Essential.task3.repositories.impls.RouteRepoImpl;
import Essential.task3.repositories.impls.TransportRepoImpl;
import Essential.task3.services.RouteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static Essential.task3.models.DriverQualification.BUS_DRIVER;
import static Essential.task3.models.DriverQualification.TRAM_DRIVER;
import static org.junit.jupiter.api.Assertions.*;

class RouteServiceImplTest {

    static Driver driver1;
    static Driver driver2;
    static Route firstRoute;
    static Route secondRoute;
    static Transport bus1;
    static Transport tram2;
    static List<Transport> transports;
    static TransportRepo transportRepo;
    static List<Route> routes;
    static RouteRepo routeRepo;
    static RouteService routeService;



    @BeforeEach

    public void init() {
        driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        driver2 = new Driver(2, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        firstRoute = new Route(1, "Kyiv", "Poltava");
        secondRoute = new Route(2, "Odesa", "Lviv");
        bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        tram2 = new Tram(3, "euro", 60, driver2,
                null, TRAM_DRIVER, 4);
        transports = new ArrayList<>();
        transports.add(bus1);
        transports.add(tram2);
        transportRepo = new TransportRepoImpl(transports);
        routes = new ArrayList<>();
        routes.add(firstRoute);
        routes.add(secondRoute);
        routeRepo = new RouteRepoImpl(routes);
        routeService = new RouteServiceImpl(routeRepo, transportRepo);
    }

    @Test
    void addRoute() {
        routes.remove(firstRoute);
        assertEquals(firstRoute, routeService.addRoute(firstRoute));
    }

    @Test
    void removeRoute() {
        assertEquals(firstRoute, routeService.removeRoute(firstRoute));
    }

    @Test
    void findRouteById() {
        assertEquals(firstRoute, routeService.findRouteById(1));
        assertEquals(secondRoute, routeService.findRouteById(2));
    }

    @Test
    void findAllRoutes() {
        assertEquals(routeService.findAllRoutes(), routes);
    }

    @Test
    void findRoutesNoTransport() {
        List<Route> expected = new ArrayList<>();
        expected.add(secondRoute);
        assertEquals(routeService.findRoutesNoTransport(), expected);
    }
}