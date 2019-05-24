/**
 * class whit the id of one city is connected and whit the distance of that city
 */
public class Citydistance {
    private int idConnected; //id of the city connected
    private int distance; // distance between
    private int distancehigh; // different altitude between two city

    public int getDistancehigh() {
        return distancehigh;
    }

    public void setDistancehigh(int distancehigh) {
        this.distancehigh = distancehigh;
    }

    public int getIdConnected() {
        return idConnected;
    }

    public void setIdConnected(int idConnected) {
        this.idConnected = idConnected;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
