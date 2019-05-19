import java.util.ArrayList;

/**
 * class of definition one city
 */
public class City {
    private int id; // id of this city
    private String name; //name of city
    private ArrayList<Integer> arrayListCityConnect; // arrayList whit id of city whit is connect one city
    private Coordinate coordinate; // coordinate of city

    /**
     * method to generate a new city
     * @param id id of city
     * @param name name of city
     * @param arrayListCityConnect arrayList whit id of city whit is connect one city
     * @param coordinate insert the coordinate of city
     */
    public City(int id, String name, ArrayList<Integer> arrayListCityConnect, Coordinate coordinate) {
        this.id = id;
        this.name = name;
        this.arrayListCityConnect = arrayListCityConnect;
        this.coordinate = coordinate;
    }

    /**
     * method to get if of one city
     * @return id of city
     */
    public int getId() {
        return id;
    }

    /**
     * metho
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * method to get name of city
     * @return name of the city
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * method to get the connections of one city whit other
     * @return arrayList of connect city
     */
    public ArrayList<Integer> getArrayListCityConnect() {
        return arrayListCityConnect;
    }

    public void setArrayListCityConnect(ArrayList<Integer> arrayListCityConnect) {
        this.arrayListCityConnect = arrayListCityConnect;
    }

    /**
     * method to get the coordinate of one city
     * @return the coordinate of city
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
