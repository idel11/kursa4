package Essential.task3.services.impls;

import Essential.task3.models.*;
import Essential.task3.repositories.RouteRepo;
import Essential.task3.repositories.TransportRepo;
import Essential.task3.repositories.impls.RouteRepoImpl;
import Essential.task3.repositories.impls.TransportRepoImpl;
import Essential.task3.services.RouteService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static Essential.task3.models.DriverQualification.BUS_DRIVER;
import static Essential.task3.models.DriverQualification.TRAM_DRIVER;
import static org.junit.jupiter.api.Assertions.*;

class RouteServiceImplTest {

    @Test
    void addRoute() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        List<Transport> transports = new ArrayList<>();
        TransportRepo transportRepo = new TransportRepoImpl(transports);
        List<Route> routes = new ArrayList<>();
        RouteRepo routeRepo = new RouteRepoImpl(routes);
        RouteService routeService = new RouteServiceImpl(routeRepo, transportRepo);
        assertEquals(routeService.addRoute(firstRoute), firstRoute);
    }

    @Test
    void removeRoute() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        List<Transport> transports = new ArrayList<>();
        TransportRepo transportRepo = new TransportRepoImpl(transports);
        List<Route> routes = new ArrayList<>();
        routes.add(firstRoute);
        RouteRepo routeRepo = new RouteRepoImpl(routes);
        RouteService routeService = new RouteServiceImpl(routeRepo, transportRepo);
        assertEquals(routeService.removeRoute(firstRoute), firstRoute);
    }

    @Test
    void findRouteById() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        List<Transport> transports = new ArrayList<>();
        TransportRepo transportRepo = new TransportRepoImpl(transports);
        List<Route> routes = new ArrayList<>();
        routes.add(firstRoute);
        routes.add(secondRoute);
        RouteRepo routeRepo = new RouteRepoImpl(routes);
        RouteService routeService = new RouteServiceImpl(routeRepo, transportRepo);
        assertEquals(routeService.findRouteById(1), firstRoute);
        assertEquals(routeService.findRouteById(2), secondRoute);
    }

    @Test
    void findAllRoutes() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        List<Transport> transports = new ArrayList<>();
        TransportRepo transportRepo = new TransportRepoImpl(transports);
        List<Route> routes = new ArrayList<>();
        routes.add(firstRoute);
        routes.add(secondRoute);
        RouteRepo routeRepo = new RouteRepoImpl(routes);
        RouteService routeService = new RouteServiceImpl(routeRepo, transportRepo);
        assertEquals(routeService.findAllRoutes(), routes);
    }

    @Test
    void findRoutesNoTransport() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Driver driver2 = new Driver(2, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                null, BUS_DRIVER, "pass", 2);
        Transport tram2 = new Tram(3, "euro", 60, driver2,
                secondRoute, TRAM_DRIVER, 4);
        List<Transport> transports = new ArrayList<>();
        transports.add(bus1);
        transports.add(tram2);
        TransportRepo transportRepo = new TransportRepoImpl(transports);
        List<Route> routes = new ArrayList<>();
        routes.add(firstRoute);
        routes.add(secondRoute);
        RouteRepo routeRepo = new RouteRepoImpl(routes);
        RouteService routeService = new RouteServiceImpl(routeRepo, transportRepo);
        List<Route> expected = new ArrayList<>();
        expected.add(firstRoute);
        assertEquals(routeService.findRoutesNoTransport(), expected);
    }
}