import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
/**
 * class map
 */
public class Map {
    // variable for write xml
    private XMLOutputFactory xmlOut = null;
    private XMLStreamWriter xmlWrite = null;

    private ArrayList<City> arraylistCities; //arrayList of all city of the map

    private int idPercorsoTeamTonatiuh[];
    private int idPercorsoTeamMetztli[];
    private int costTeamTonatiuh;
    private int costTeamMetztli;

    DijkstraAlgorithm dijkstraAlgorithm;

    public void conversionToCity(Element element){
        //input city
        /*for( : ){
            int id = 0;
            String name = null;
            Citydistance distance = null ;
            ArrayList<Citydistance> arrayListCityConnect = null;
            Coordinate coordinate = null;
            String scelta="";
            if(scelta.equals("id")){
                id = ;
            }else if(scelta.equals("name")){
                name =
            }

            coordinate.setX(Integer.parseInt());
            coordinate.setY(Integer.parseInt());
            coordinate.setH(Integer.parseInt())
            for(){
                distance.setId(Integer.parseInt());
                arrayListCityConnect.add(distance);
            }
            City city = new City(id,name,arrayListCityConnect,coordinate);
            arraylistCities.add(city);
        }

        // calc distance and high between all city linked
        for(City city : arraylistCities){
            for (int index = 0; index < city.getArrayListCityConnectDistance().size(); index++){
                int id = city.getArrayListCityConnectDistance().get(index).getId();
                City city1= arraylistCities.get(getCityIndex(id));
                city.getArrayListCityConnectDistance().get(index).setDistance(calcDistance(city,city1));
                city.getArrayListCityConnectDistance().get(index).setDistancehigh(calcDistanceHigh(city,city1));
            }
        }*/
    }

    public void calcStreetTeamTonatiuh(){
        //richiamo funzione per creazione percorso
        calcCostTonatiuh();
    }

    public void calcStreetTeamMetztli(){
        //richiamo funzione per creazione percorso
        calcCostMetztli();
    }

    /**
     * method to calc distance between two city in x,y whit the Euclidean formula
     *
     * @param city1 city number 1
     * @param city2 city number 2
     * @return distance between two city in x,y
     */
    private int calcDistance(City city1,City city2){
        return (int)Math.ceil(Math.sqrt(Math.pow(city2.getCoordinate().getX()-city1.getCoordinate().getX(),2)
                        +Math.pow(city2.getCoordinate().getY()-city1.getCoordinate().getY(),2)));
    }

    /**
     * method to calc different altitude  between two city
     *
     * @param city2 city number 1
     * @param city3 city number 2
     * @return different altitude  between two city
     */
    private int calcDistanceHigh(City city2,City city3){

        if(city2.getCoordinate().getH() ==  city3.getCoordinate().getH())return 0; //high is the same 0

        if(city2.getCoordinate().getH() == 0) return Math.abs(city3.getCoordinate().getH());

        if(city3.getCoordinate().getH() == 0) return Math.abs(city2.getCoordinate().getH());

        if(city2.getCoordinate().getH() > 0){
            if(city3.getCoordinate().getH() > 0){
                if(city2.getCoordinate().getH() > city3.getCoordinate().getH() ){
                    return city2.getCoordinate().getH()-city3.getCoordinate().getH();//high2 >0 && high3>0&& high2>high3
                }else{
                    return -city2.getCoordinate().getH()+city3.getCoordinate().getH();//high2 >0 && high3>0&& high2<high3
                }
            }else{
                //
                return city2.getCoordinate().getH() - city3.getCoordinate().getH();//high2>0 && high3<0
            }
        }else{
            if(city3.getCoordinate().getH() > 0){
                return -city2.getCoordinate().getH() + city3.getCoordinate().getH();//high2<0 && high3>0
            }else{
                if(city2.getCoordinate().getH() < city3.getCoordinate().getH()){
                    return (-city2.getCoordinate().getH()+city3.getCoordinate().getH());//high2<0 && high3<0 && high2<high3
                }else{
                    return (+city2.getCoordinate().getH()-city3.getCoordinate().getH());//high2<0 && high3<0 && high2>high3
                }
            }
        }
    }

    /**
     *method to calc cost of street team Tonatiuh
     * @return price of carburante
     */
    private void calcCostTonatiuh(){
        int cost = 0;
        for(int id = 0 ; id < idPercorsoTeamTonatiuh.length-1;id++){
            int iD = idPercorsoTeamTonatiuh[id];
            City city = arraylistCities.get(getCityIndex(iD));
            for (Citydistance  city1 : city.getArrayListCityConnectDistance()){
                int id2 = city1.getIdConnected();
                if(id2 == idPercorsoTeamTonatiuh[id+1]){
                    cost += city1.getDistance();
                }
            }
        }
        costTeamTonatiuh = cost;
    }

    /**
     *method to calc cost of street team Metztli
     * @return price of carburante
     */
    private void calcCostMetztli(){
        int cost = 0;
        for(int id = 0 ; id < idPercorsoTeamTonatiuh.length-1;id++){
            int iD = idPercorsoTeamTonatiuh[id];
            City city = arraylistCities.get(getCityIndex(iD));
            for (Citydistance  city1 : city.getArrayListCityConnectDistance()){
                int id2 = city1.getIdConnected();
                if(id2 == idPercorsoTeamTonatiuh[id+1]){
                    cost += city1.getDistancehigh();
                }
            }
        }
        costTeamMetztli = cost;
    }

    /**
     *method to stamp xml
     *
     * @param nameFile name of file output
     * @param encoding encoding of file
     * @return true if is stamp xml right
     *         false if is xml isn't right
     */
    public boolean xmlWrite(String nameFile, String encoding){
        try {
            xmlOut = XMLOutputFactory.newInstance();
            xmlWrite = xmlOut.createXMLStreamWriter(new FileOutputStream(nameFile), encoding);
            xmlWrite.writeStartDocument(encoding, "1.0");
            System.out.println("\nStart Write Doc " + nameFile);
        } catch (Exception e) {
            System.out.println("Error_writer:");
            System.out.println(e.getMessage());
        }

        try {
            xmlWrite.writeStartElement("routes"); // open tag xml
            xmlWrite.writeStartElement("route");//open team Tonatiuh
            xmlWrite.writeAttribute("team=", "Tonatiuh" );
            xmlWrite.writeAttribute("cost=",Integer.toString(costTeamTonatiuh));
            xmlWrite.writeAttribute("cities=",Integer.toString(idPercorsoTeamTonatiuh.length));

            for (Integer id : idPercorsoTeamTonatiuh) {//print all cities touch
                xmlWrite.writeStartElement("city");
                xmlWrite.writeAttribute("id=",id.toString());//print id of city
                xmlWrite.writeAttribute("name=",getNameOfCities(id));
                xmlWrite.writeEndElement();//close cities
            }
            xmlWrite.writeEndElement(); //close route
            xmlWrite.writeStartElement("route");//open team Metztli
            xmlWrite.writeAttribute("team=", "Metztli");
            xmlWrite.writeAttribute("cost=",Integer.toString(costTeamMetztli));
            xmlWrite.writeAttribute("cities=",Integer.toString(idPercorsoTeamMetztli.length) );

            for (Integer id : idPercorsoTeamMetztli) {//print cities touch
                xmlWrite.writeAttribute("id=",id.toString() );//print id of city
                xmlWrite.writeAttribute("name=",getNameOfCities(id));
                xmlWrite.writeEndElement();//close cities
            }
            xmlWrite.writeEndElement(); //close route
            xmlWrite.writeEndElement();//closed routes
            xmlWrite.writeEndElement();//close output
            xmlWrite.writeEndDocument(); //close document
            xmlWrite.flush(); // empty buffer
            xmlWrite.close(); // close all
            System.out.println("\nEnd Write Doc " + nameFile);
        } catch (Exception e) {

            System.out.println("Error_write");
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * method to get city of arrayList of cities
     * @param id int id of city
     * @return the city
     *          null if the city is not found but is impossible because there is check of input
     *
     */
    private int getCityIndex(int id){
        for (int index = 0; index <arraylistCities.size();index++) {
            if (arraylistCities.get(index).getId() == id){
                return index;
            }
        }
        return -1;
    }

    /**
     * method found name city whit id
     * @param id id of the city
     * @return name of city
     */
    private  String getNameOfCities(int id){
        for (City city :arraylistCities) {
            if (city.getId() == id){
                return city.getName();
            }
        }
        return "error";
    }
}
