/**
 * class whit the id of one city is connected and whit the distance of that city
 */
public class Citydistance {
    private int idConnected; //id of the city connected
    private int distance; // distance between
    private int distancehigh; // different altitude between two city

    /**
     * method to get distancehigh
     * @return  distancehigh
     */
    public int getDistancehigh() {
        return distancehigh;
    }

    /**
     * method to set distancehigh
     * @param distancehigh distancehigh
     */
    public void setDistancehigh(int distancehigh) {
        this.distancehigh = distancehigh;
    }

    /**
     * method to get idConnected
     * @return idConnected
     */
    public int getIdConnected() {
        return idConnected;
    }

    /**
     * method to set idConnected
     * @param idConnected idConnected
     */
    public void setIdConnected(int idConnected) {
        this.idConnected = idConnected;
    }

    /**
     * method to get distance
     * @return distance
     */
    public int getDistance() {
        return distance;
    }

    /**
     * method to set distance
     * @param distance distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }
}
