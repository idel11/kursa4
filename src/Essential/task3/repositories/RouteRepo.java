package Essential.task3.repositories;

import Essential.task3.models.Driver;
import Essential.task3.models.Route;

import java.util.ArrayList;

public interface RouteRepo {

    public void addRoute(Route route);

    public ArrayList<Route> getAllRoutes();

    public void updateRoute(Route route);

    public void removeRoute(Route route);

}
