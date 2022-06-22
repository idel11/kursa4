package Essential.task3.services;

import Essential.task3.models.Route;

import java.util.List;

public interface RouteService {

    public Route addRoute(Route route);

    public Route removeRoute(Route route);

    public Route findRouteById(int id);

    public List<Route> findAllRoutes();

    public List<Route> findRoutesNoTransport();

}
