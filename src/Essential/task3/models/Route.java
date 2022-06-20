package Essential.task3.models;

public class Route {
    private int id;
    private String startPoint;
    private String finishPoint;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getFinishPoint() {
        return finishPoint;
    }

    public void setFinishPoint(String finishPoint) {
        this.finishPoint = finishPoint;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", startPoint='" + startPoint + '\'' +
                ", finishPoint='" + finishPoint + '\'' +
                '}';
    }

    public Route(int id, String startPoint, String finishPoint) {
        this.id = id;
        this.startPoint = startPoint;
        this.finishPoint = finishPoint;
    }
}
