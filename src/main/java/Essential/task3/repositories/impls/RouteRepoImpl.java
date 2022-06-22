package Essential.task3.repositories.impls;

import Essential.task3.models.Route;
import Essential.task3.repositories.RouteRepo;
import java.util.List;

public class RouteRepoImpl implements RouteRepo {

    private final List<Route> array;

    public RouteRepoImpl(List<Route> array) {
        this.array = array;
    }

    @Override
    public Route add(Route route) {
        array.add(route);
        return route;
    }

    @Override
    public List<Route> getAll() {
        return array;
    }

    @Override
    public Route update(Route route) {
        for (Route r : array) {
            if (r.getId() == route.getId()) {
                r = route;
            }
        } return route;
    }

    @Override
    public Route remove(Route route) {
        array.remove(route);
        return route;
    }

}
