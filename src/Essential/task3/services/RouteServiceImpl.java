package Essential.task3.services;

import Essential.task3.models.Route;
import Essential.task3.models.Transport;
import Essential.task3.repositories.RouteRepoImpl;
import Essential.task3.repositories.TransportRepoImpl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RouteServiceImpl implements RouteService {

    @Override
    public void addRoute(@NotNull RouteRepoImpl rtm, Route route) {
        rtm.addRoute(route);
    }

    @Override
    public void removeRoute(@NotNull RouteRepoImpl rtm, Route route) {
        rtm.removeRoute(route);
    }

    @Override
    public Route getRouteById(@NotNull RouteRepoImpl rtm, int id) {
        for (Route r : rtm.getAllRoutes()) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Route> getAllRoutes(@NotNull RouteRepoImpl rtm) {
        return rtm.getAllRoutes();
    }

    @Override
    public ArrayList<Route> getRoutesNoTransport(@NotNull RouteRepoImpl rtm, @NotNull TransportRepoImpl tr) {
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
