package Essential.task3.repositories;

import Essential.task3.models.Route;

import java.util.ArrayList;

public class RouteRepoImpl implements RouteRepo {

    ArrayList<Route> array = new ArrayList<>();

    public RouteRepoImpl(ArrayList<Route> array) {
        this.array = array;
    }

    @Override
    public void addRoute(Route route) {
        array.add(route);
    }

    @Override
    public ArrayList<Route> getAllRoutes() {
        return array;
    }

    @Override
    public void updateRoute(Route route) {
        for (Route r : array) {
            if (r.getId() == route.getId()) {
                r = route;
            }
        }
    }

    @Override
    public void removeRoute(Route route) {
        array.remove(route);
    }

}
