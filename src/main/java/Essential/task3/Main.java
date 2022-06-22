package Essential.task3;

import Essential.task3.models.*;
import Essential.task3.repositories.impls.DriverRepoImpl;
import Essential.task3.repositories.impls.RouteRepoImpl;
import Essential.task3.repositories.impls.TransportRepoImpl;
import Essential.task3.services.impls.DriverServiceImpl;
import Essential.task3.services.impls.RouteServiceImpl;
import Essential.task3.services.impls.TransportServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static Essential.task3.models.DriverQualification.BUS_DRIVER;
import static Essential.task3.models.DriverQualification.TRAM_DRIVER;


public class Main {
    public static void main(String[] args) {

        Driver driver1 = new Driver(1, "Kolya", "Ly", "777 77 77", BUS_DRIVER);
        Driver driver2 = new Driver(2, "Tolya", "My", "555 55 55", TRAM_DRIVER);
        List<Driver> driversArray = new ArrayList<>();
        driversArray.add(driver1);
        driversArray.add(driver2);

        Route firstRoute = new Route(1, "Kyiv", "Poltava");
        Route secondRoute = new Route(2, "Odesa", "Lviv");
        Route thirdRoute = new Route(3, "Lviv", "Kyiv");
        List<Route> routesArray = new ArrayList<>();
        routesArray.add(firstRoute);
        routesArray.add(secondRoute);
        routesArray.add(thirdRoute);

        Transport bus1 = new Bus(1, "ikarus", 40, driver1,
                firstRoute, BUS_DRIVER, "pass", 2);
        Transport bus2 = new Bus(2, "mers", 40, null,
                firstRoute, BUS_DRIVER, "pass", 2);
        Transport tram1 = new Tram(3, "euro", 60, driver2,
                secondRoute, TRAM_DRIVER, 4);

        List<Transport> transArray = new ArrayList<>();
        transArray.add(bus1);
        transArray.add(bus2);
        transArray.add(tram1);

        TransportRepoImpl ttrr = new TransportRepoImpl(transArray);
        DriverRepoImpl ddrr = new DriverRepoImpl(driversArray);
        RouteRepoImpl rroo = new RouteRepoImpl(routesArray);

        DriverServiceImpl drsrv = new DriverServiceImpl(ddrr, ttrr);
        RouteServiceImpl rsv = new RouteServiceImpl(rroo,ttrr);
        TransportServiceImpl trsrv = new TransportServiceImpl(ttrr);

        System.out.println("===================== test driver service ====================");
        System.out.println(drsrv.findTransportNoDriver());
        drsrv.assignDriverToTransport(bus2, driver1);
        System.out.println(drsrv.findTransportNoDriver());
        System.out.println(drsrv.findAllDriversByRoute(secondRoute));
        System.out.println(drsrv.findDriverBySurname("My"));
        System.out.println(drsrv.findDriverById(1));
        System.out.println();


        System.out.println("==================== test route service =====================");
        System.out.println(rsv.findRouteById(2));
        System.out.println(rsv.findAllRoutes());
        rsv.removeRoute(secondRoute);
        System.out.println(rsv.findAllRoutes());
        rsv.addRoute(secondRoute);
        System.out.println(rsv.findAllRoutes());
        System.out.println(rsv.findRoutesNoTransport());
        System.out.println();


        System.out.println("==================== test transport service =====================");

        routesArray.add(firstRoute);
        routesArray.add(secondRoute);
        transArray.add(tram1);
        System.out.println(rsv.findAllRoutes());
        System.out.println(trsrv.findAllTransports());
        System.out.println(drsrv.findAllDrivers());

        System.out.println(trsrv.findAllTransportsByModel("ikarus"));
        System.out.println(trsrv.findTransportById(2));

        Transport tram4 = new Tram(4, "ukr", 50, null,
                null, TRAM_DRIVER, 6);

        trsrv.addTransport(tram4);
        System.out.println(trsrv.findTransportById(4));

        trsrv.assignTransportOnRoute(firstRoute);
        System.out.println(trsrv.findAllTransportsByModel("ukr"));

        drsrv.assignDriverToTransport(tram4, driver2);
        trsrv.assignTransportOnRoute(firstRoute);
        System.out.println(trsrv.findAllTransportsByModel("ukr"));

        trsrv.removeTransportFromRoute(tram4,firstRoute);
        System.out.println(trsrv.findTransportById(4));

        trsrv.removeTransportFromRoute(bus2,firstRoute);
        System.out.println(trsrv.findTransportById(2));


    }
}
