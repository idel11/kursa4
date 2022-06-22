package Essential.task3.services.impls;

import Essential.task3.models.Route;
import Essential.task3.models.Transport;
import Essential.task3.repositories.RouteRepo;
import Essential.task3.repositories.TransportRepo;
import Essential.task3.services.RouteService;

import java.util.ArrayList;
import java.util.List;

public class RouteServiceImpl implements RouteService {

    private RouteRepo routeRepo;
    private TransportRepo transportRepo;

    public RouteServiceImpl(RouteRepo routeRepo, TransportRepo transportRepo) {
        this.routeRepo = routeRepo;
        this.transportRepo = transportRepo;
    }

    @Override
    public Route addRoute(Route route) {
        routeRepo.add(route);
        return route;
    }

    @Override
    public Route removeRoute(Route route) {
        routeRepo.remove(route);
        return route;
    }

    @Override
    public Route findRouteById(int id) {
        for (Route r : routeRepo.getAll()) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    @Override
    public List<Route> findAllRoutes() {
        return routeRepo.getAll();
    }

    @Override
    public List<Route> findRoutesNoTransport() {
        List<Route> temp = new ArrayList<>();
        List<Route> result = new ArrayList<>();
        result = routeRepo.getAll();
        for (Transport t : transportRepo.getAll()) {
            temp.add(t.getRoute());
        }
        result.removeAll(temp);
        return result;
    }
}
