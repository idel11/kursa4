package Essential.task3.services.impls;

import Essential.task3.models.*;
import Essential.task3.repositories.DriverRepo;
import Essential.task3.repositories.TransportRepo;
import Essential.task3.repositories.impls.DriverRepoImpl;
import Essential.task3.repositories.impls.TransportRepoImpl;
import Essential.task3.services.DriverService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static Essential.task3.models.DriverQualification.BUS_DRIVER;
import static Essential.task3.models.DriverQualification.TRAM_DRIVER;
import static org.junit.jupiter.api.Assertions.*;

class DriverServiceImplTest {

    @Test
    void addDriver() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Driver driver2 = new Driver(2, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        Transport tram2 = new Tram(3, "euro", 60, driver2,
                secondRoute, TRAM_DRIVER, 4);
        List<Transport> actual = new ArrayList<>();
        TransportRepo transportRepo = new TransportRepoImpl(actual);
        List<Driver> drivers = new ArrayList<>();
        DriverRepo driverRepo = new DriverRepoImpl(drivers);
        DriverService driverService = new DriverServiceImpl(driverRepo, transportRepo);
        List<Driver> expected = new ArrayList<>();
        expected.add(driver1);
        assertEquals(driverService.addDriver(driver1), driver1);
    }

    @Test
    void removeDriver() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Driver driver2 = new Driver(2, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        Driver driver3 = new Driver(3, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        Transport tram2 = new Tram(3, "euro", 60, driver2,
                secondRoute, TRAM_DRIVER, 4);
        List<Transport> actual = new ArrayList<>();
        actual.add(bus1);
        actual.add(tram2);
        TransportRepo transportRepo = new TransportRepoImpl(actual);
        List<Driver> drivers = new ArrayList<>();
        drivers.add(driver1);
        DriverRepo driverRepo = new DriverRepoImpl(drivers);
        DriverService driverService = new DriverServiceImpl(driverRepo, transportRepo);
        assertEquals(null, driverService.removeDriver(driver1));
        assertEquals(driver3, driverService.removeDriver(driver3));
    }

    @Test
    void findDriverById() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Driver driver2 = new Driver(2, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        Transport tram2 = new Tram(3, "euro", 60, driver2,
                secondRoute, TRAM_DRIVER, 4);
        List<Transport> actual = new ArrayList<>();
        TransportRepo transportRepo = new TransportRepoImpl(actual);
        List<Driver> drivers = new ArrayList<>();
        drivers.add(driver1);
        drivers.add(driver2);
        DriverRepo driverRepo = new DriverRepoImpl(drivers);
        DriverService driverService = new DriverServiceImpl(driverRepo, transportRepo);
        assertEquals(driverService.findDriverById(1), driver1);
    }

    @Test
    void findDriverBySurname() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Driver driver2 = new Driver(2, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        Transport tram2 = new Tram(3, "euro", 60, driver2,
                secondRoute, TRAM_DRIVER, 4);
        List<Transport> actual = new ArrayList<>();
        TransportRepo transportRepo = new TransportRepoImpl(actual);
        List<Driver> drivers = new ArrayList<>();
        drivers.add(driver1);
        drivers.add(driver2);
        DriverRepo driverRepo = new DriverRepoImpl(drivers);
        DriverService driverService = new DriverServiceImpl(driverRepo, transportRepo);
        assertEquals(driverService.findDriverBySurname("Ly"), driver1);
    }

    @Test
    void findAllDrivers() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Driver driver2 = new Driver(2, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        Transport tram2 = new Tram(3, "euro", 60, driver2,
                secondRoute, TRAM_DRIVER, 4);
        List<Transport> actual = new ArrayList<>();
        TransportRepo transportRepo = new TransportRepoImpl(actual);
        List<Driver> drivers = new ArrayList<>();
        drivers.add(driver1);
        drivers.add(driver2);
        DriverRepo driverRepo = new DriverRepoImpl(drivers);
        DriverService driverService = new DriverServiceImpl(driverRepo, transportRepo);
        List<Driver> expected = new ArrayList<>();
        expected.add(driver1);
        expected.add(driver2);
        assertEquals(driverService.findAllDrivers(), expected);
    }

    @Test
    void findAllDriversByRoute() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Driver driver2 = new Driver(2, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        Transport tram2 = new Tram(3, "euro", 60, driver2,
                secondRoute, TRAM_DRIVER, 4);
        List<Transport> actual = new ArrayList<>();
        actual.add(tram2);
        actual.add(bus1);
        TransportRepo transportRepo = new TransportRepoImpl(actual);
        List<Driver> drivers = new ArrayList<>();
        drivers.add(driver1);
        drivers.add(driver2);
        DriverRepo driverRepo = new DriverRepoImpl(drivers);
        DriverService driverService = new DriverServiceImpl(driverRepo, transportRepo);
        List<Driver> expected = new ArrayList<>();
        expected.add(driver1);
        assertEquals(expected, driverService.findAllDriversByRoute(firstRoute));
    }

    @Test
    void findTransportNoDriver() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Driver driver2 = new Driver(2, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        Transport tram2 = new Tram(3, "euro", 60, null,
                secondRoute, TRAM_DRIVER, 4);
        List<Transport> actual = new ArrayList<>();
        actual.add(tram2);
        actual.add(bus1);
        TransportRepo transportRepo = new TransportRepoImpl(actual);
        List<Driver> drivers = new ArrayList<>();
        drivers.add(driver1);
        drivers.add(driver2);
        DriverRepo driverRepo = new DriverRepoImpl(drivers);
        DriverService driverService = new DriverServiceImpl(driverRepo, transportRepo);
        List<Transport> expected = new ArrayList<>();
        expected.add(tram2);
        assertEquals(expected, driverService.findTransportNoDriver());
    }

    @Test
    void assignDriverToTransport() {
        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Driver driver2 = new Driver(2, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Transport bus1 = new Bus(1, "ikarus", 40, null,
                firstRoute, BUS_DRIVER, "pass", 2);
        Transport tram2 = new Tram(3, "euro", 60, null,
                secondRoute, TRAM_DRIVER, 4);
        List<Transport> actual = new ArrayList<>();
        actual.add(tram2);
        actual.add(bus1);
        TransportRepo transportRepo = new TransportRepoImpl(actual);
        List<Driver> drivers = new ArrayList<>();
        drivers.add(driver1);
        drivers.add(driver2);
        DriverRepo driverRepo = new DriverRepoImpl(drivers);
        DriverService driverService = new DriverServiceImpl(driverRepo, transportRepo);
        List<Transport> expected = new ArrayList<>();
        assertEquals(driver1, driverService.assignDriverToTransport(bus1, driver1));
        assertEquals(null, driverService.assignDriverToTransport(tram2, driver1));
    }
}