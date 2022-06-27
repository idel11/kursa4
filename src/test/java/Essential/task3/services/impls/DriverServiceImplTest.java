package Essential.task3.services.impls;

import Essential.task3.models.*;
import Essential.task3.repositories.DriverRepo;
import Essential.task3.repositories.TransportRepo;
import Essential.task3.repositories.impls.DriverRepoImpl;
import Essential.task3.repositories.impls.TransportRepoImpl;
import Essential.task3.services.DriverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static Essential.task3.models.DriverQualification.BUS_DRIVER;
import static Essential.task3.models.DriverQualification.TRAM_DRIVER;
import static org.junit.jupiter.api.Assertions.*;

class DriverServiceImplTest {

    static Driver driver1;
    static Driver driver2;
    static Driver driver3;
    static Route firstRoute;
    static Route secondRoute;
    static Transport bus1;
    static Transport tram2;
    static Transport tram3;
    static List<Transport> transports;
    static TransportRepo transportRepo;
    static List<Driver> drivers;
    static DriverRepo driverRepo;
    static DriverService driverService;
    static List<Driver> expectedDrivers;
    static List<Transport> expectedTransports;


    @BeforeEach
    public void init(){
        driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        driver2 = new Driver(2, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        driver3 = new Driver(3, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        firstRoute = new Route(1, "Kyiv", "Poltava");
        secondRoute = new Route(2, "Odesa", "Lviv");
        bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        tram2 = new Tram(3, "euro", 60, driver2,
                secondRoute, TRAM_DRIVER, 4);
        tram3 = new Tram(3, "euro", 60, null,
                secondRoute, TRAM_DRIVER, 4);
        transports = new ArrayList<>();
        transports.add(bus1);
        transports.add(tram2);
        transports.add(tram3);
        drivers = new ArrayList<>();
        drivers.add(driver1);
        drivers.add(driver2);
        drivers.add(driver3);
        transportRepo = new TransportRepoImpl(transports);
        driverRepo = new DriverRepoImpl(drivers);
        driverService = new DriverServiceImpl(driverRepo, transportRepo);
        expectedDrivers = new ArrayList<>();
        expectedTransports = new ArrayList<>();
    }

    @Test
    public void addDriver() {
        drivers.remove(driver1);
        assertEquals(driver1, driverService.addDriver(driver1));
    }

    @Test
    public void removeDriver() {
        assertEquals(null, driverService.removeDriver(driver1));
        assertEquals(driver3, driverService.removeDriver(driver3));
    }

    @Test
    public void findDriverById() {
        assertEquals(driverService.findDriverById(1), driver1);
    }

    @Test
    public void findDriverBySurname() {
        assertEquals(driverService.findDriverBySurname("Ly"), driver1);
    }

    @Test
    public void findAllDrivers() {
        expectedDrivers.add(driver1);
        expectedDrivers.add(driver2);
        expectedDrivers.add(driver3);
        assertEquals(expectedDrivers,driverService.findAllDrivers());
    }

    @Test
    public void findAllDriversByRoute() {
        expectedDrivers.add(driver1);
        assertEquals(expectedDrivers, driverService.findAllDriversByRoute(firstRoute));
    }

    @Test
    public void findTransportNoDriver() {
        expectedTransports.add(tram3);
        assertEquals(expectedTransports, driverService.findTransportNoDriver());
    }

    @Test
    public void assignDriverToTransport() {
        assertEquals(driver3, driverService.assignDriverToTransport(tram3, driver3));
        assertEquals(null, driverService.assignDriverToTransport(tram2, driver1));
    }
}