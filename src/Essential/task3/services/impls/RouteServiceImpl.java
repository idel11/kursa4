package Essential.task3.services.impls;

import Essential.task3.models.Route;
import Essential.task3.models.Transport;
import Essential.task3.repositories.impls.RouteRepoImpl;
import Essential.task3.repositories.impls.TransportRepoImpl;
import Essential.task3.services.RouteService;

import java.util.ArrayList;

public class RouteServiceImpl implements RouteService {

    @Override
    public void addRoute(RouteRepoImpl rtm, Route route) {
        rtm.addRoute(route);
    }

    @Override
    public void removeRoute(RouteRepoImpl rtm, Route route) {
        rtm.removeRoute(route);
    }

    @Override
    public Route getRouteById(RouteRepoImpl rtm, int id) {
        for (Route r : rtm.getAllRoutes()) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Route> getAllRoutes(RouteRepoImpl rtm) {
        return rtm.getAllRoutes();
    }

    @Override
    public ArrayList<Route> getRoutesNoTransport(RouteRepoImpl rtm,TransportRepoImpl tr) {
        ArrayList<Route> temp = new ArrayList<>();
        ArrayList<Route> result = new ArrayList<>();
        result = rtm.getAllRoutes();
        for (Transport t : tr.getAllTransports()) {
            temp.add(t.getRoute());
        }
        result.removeAll(temp);
        return result;
    }
}
