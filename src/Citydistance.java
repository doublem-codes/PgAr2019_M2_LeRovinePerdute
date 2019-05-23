/**
 * class whit the id of one city is connected and whit the distance of that city
 */
public class Citydistance {
    private int id; //id of the city connected
    private int distance; // distance between
    private int distancehigh; // different altitude between two city

    public int getDistancehigh() {
        return distancehigh;
    }

    public void setDistancehigh(int distancehigh) {
        this.distancehigh = distancehigh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
