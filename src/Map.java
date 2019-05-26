import javax.xml.stream.*;
import java.io.FileInputStream;
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
    private int indexRovinePerdute;
    private int costTeamTonatiuh;
    private int costTeamMetztli;
    //string comunication map
    private String calc = "calc street of rovine perdute for team ";
    private String teamT = "Totnatium of";
    private String teamM = "Metztli of";

    /**
     * method to all city of map
     * @param arraylistCities arrayList of city of map
     */
    public void setArraylistCities(ArrayList<City> arraylistCities) {
        this.arraylistCities = arraylistCities;
    }

    /**
     * method to check all city whit their id is different and to check the connection whit city are wright
     * find where is rovine perdute in arrayList
     * @param string name of kind of map work
     */
    public void conversionToCity(String string){
        System.out.println("\n -----------------------CONVERSION FILE----------------------------------------------\n");
        System.out.println("\n -----------------------CHECK FILE----------------------------------------------\n");

        //found rovine perdude id and position of array
        indexRovinePerdute = getCityIndex("Rovine Perdute");
        // calc distance and high between all city linked
        for(City city : arraylistCities){
            for (int index = 0; index < city.getArrayListCityConnectDistance().size(); index++){
                int id = city.getArrayListCityConnectDistance().get(index).getIdConnected();
                City city1= arraylistCities.get(getCityIndex(id));
                city.getArrayListCityConnectDistance().get(index).setDistance(calcDistance(city,city1));
                city.getArrayListCityConnectDistance().get(index).setDistancehigh(calcDistanceHigh(city,city1));
            }
        }
        System.out.println("\n -----------------------CALCULATE BETTER STREET TEAM TONATIUH----------------------------------------------\n");
        System.out.println(calc+teamT+string);
        idPercorsoTeamTonatiuh = dijkstraAlgorithmDistance();
        calcCostTonatiuh();
        System.out.println("\n -----------------------CALCULATE BETTER STREET TEAM METZTLI----------------------------------------------\n");
        System.out.println(calc+teamM+string);
        idPercorsoTeamMetztli = dijkstraAlgorithmDistanceHigh();
        calcCostMetztli();
    }

    /**
     * method whit dijkstra to found best street for team TONATIUH
     * @return id street
     */
    public int[] dijkstraAlgorithmDistance() {

        ArrayList<Integer> visitedNodes = new ArrayList<>();
        int []nodeFrom = new int[arraylistCities.size()];
        int []distance = new int[arraylistCities.size()];
        Integer node;
        maxDistance(distance);

        for(City city : arraylistCities){
            visitedNodes.add(city.getId());
        }
        distance[0] = 0;

        for(int i = 0; i<nodeFrom.length;i++) {
            nodeFrom[i] = -1;
        }

        for (int m = 0; m<arraylistCities.get(0).getArrayListCityConnectDistance().size(); m++){
            int id = arraylistCities.get(0).getArrayListCityConnectDistance().get(m).getIdConnected();
            if(arraylistCities.get(0).getArrayListCityConnectDistance().get(m).getDistance() < distance[id]){
                distance[id] = arraylistCities.get(0).getArrayListCityConnectDistance().get(m).getDistance();
                nodeFrom[id] = arraylistCities.get(0).getId();
            }
        }
        node = 0;
        visitedNodes.remove(node);

        while (visitedNodes.size() != 0){
            int index = distanceLess(distance, visitedNodes);


            int distances = distance[index];
            for (int m = 0; m < arraylistCities.get(index).getArrayListCityConnectDistance().size(); m++) {
                int id = arraylistCities.get(index).getArrayListCityConnectDistance().get(m).getIdConnected();
                if(id>index){
                if (arraylistCities.get(index).getArrayListCityConnectDistance().get(m).getDistance() + distances < distance[id]) {
                    distance[id] = arraylistCities.get(index).getArrayListCityConnectDistance().get(m).getDistance();
                    nodeFrom[id] = arraylistCities.get(index).getId();
                }}
            }


            node = index;
            visitedNodes.remove(node);
        }
        visitedNodes.clear();

        int  index = indexRovinePerdute;
        visitedNodes.add(indexRovinePerdute);


        do{
            visitedNodes.add(nodeFrom[index]);
            index = nodeFrom[index];
        }while(index != -1);

        int[] array = new int[visitedNodes.size()-1];
        index = visitedNodes.size()-2;
        for(Integer number :visitedNodes){
            array[index] = number;
            index--;
            if(index<0){
                break;
            }
        }
        return array;
    }

    /**
     * method whit dijkstra to found best street for team METZTLI
     * @return id street
     */
    public int[] dijkstraAlgorithmDistanceHigh() {

        ArrayList<Integer> visitedNodes = new ArrayList<>();
        int []nodeFrom = new int[arraylistCities.size()];
        int []distance = new int[arraylistCities.size()];
        Integer node;
        maxDistance(distance);

        for(City city : arraylistCities){
            visitedNodes.add(city.getId());
        }
        distance[0] = 0;

        for(int i = 0; i<nodeFrom.length;i++) {
            nodeFrom[i] = -1;
        }

        for (int m = 0; m<arraylistCities.get(0).getArrayListCityConnectDistance().size(); m++){
            int id = arraylistCities.get(0).getArrayListCityConnectDistance().get(m).getIdConnected();
            if(arraylistCities.get(0).getArrayListCityConnectDistance().get(m).getDistancehigh() < distance[id]){
                distance[id] = arraylistCities.get(0).getArrayListCityConnectDistance().get(m).getDistancehigh();
                nodeFrom[id] = arraylistCities.get(0).getId();
            }
        }
        node = 0;
        visitedNodes.remove(node);

        while (visitedNodes.size() != 0){
            int index = distanceLess(distance, visitedNodes);
            int distances = distance[index];
            for (int m = 0; m < arraylistCities.get(index).getArrayListCityConnectDistance().size(); m++) {
                int id = arraylistCities.get(index).getArrayListCityConnectDistance().get(m).getIdConnected();
                if (id > index) {
                    if (arraylistCities.get(index).getArrayListCityConnectDistance().get(m).getDistancehigh() + distances < distance[id]) {
                        distance[id] = arraylistCities.get(index).getArrayListCityConnectDistance().get(m).getDistancehigh();
                        nodeFrom[id] = arraylistCities.get(index).getId();
                    }
                }
            }
            node = index;
            visitedNodes.remove(node);
        }
        visitedNodes.clear();
        int  index = indexRovinePerdute;
        visitedNodes.add(indexRovinePerdute);

        do{
            visitedNodes.add(nodeFrom[index]);
            index = nodeFrom[index];
        }while(index != -1);

        int[] array = new int[visitedNodes.size()-1];
        index = visitedNodes.size()-2;
        for(Integer number :visitedNodes){
            array[index] = number;
            index--;
            if(index<0){
                break;
            }
        }
        return array;
    }

    /**
     * mrthod to found position whit less value of
     * @param array input of array
     * @param visit city remains to visit
     * @return index
     */
    private int distanceLess(int []array,ArrayList<Integer>visit){

        int max= array[visit.get(0)];
        int index = visit.get(0);

        for(int i = 2;i<array.length;i++){
            if(max>array[i]){
                boolean check = false;
                for(Integer num : visit){
                    if(num == i){
                        check = true;
                        break;
                    }
                }
                if(check) {
                    max = array[i];
                    index = i;
                }
            }
        }
        return index;
    }

    /**
     * method to full array distance whit infinitive
     * @param distance array input
     */
    private void maxDistance ( int[] distance){
        if (distance != null) {
            distance[0] = 0;
            for (int i = 0; i < distance.length; i++) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

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
     */
    private void calcCostTonatiuh(){
        int cost = 0;
        for(int id = 0 ; id < idPercorsoTeamTonatiuh.length-1;id++){
            int iD = idPercorsoTeamTonatiuh[id];
            City city = arraylistCities.get(getCityIndex(iD));
            for (Citydistance  city1 : city.getArrayListCityConnectDistance()){
                if(city1.getIdConnected()== idPercorsoTeamTonatiuh[id+1]){
                    cost += city1.getDistance();
                }
            }
        }
        costTeamTonatiuh = cost;
    }

    /**
     *method to calc cost of street team Metztli
     */
    private void calcCostMetztli(){
        int cost = 0;
        for(int id = 0 ; id < idPercorsoTeamTonatiuh.length-1;id++){
            for (Citydistance  city1 : arraylistCities.get(getCityIndex(idPercorsoTeamTonatiuh[id])).getArrayListCityConnectDistance()){
                if(city1.getIdConnected() == idPercorsoTeamTonatiuh[id+1]){
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
            xmlWrite.writeAttribute("team", "Tonatiuh" );
            xmlWrite.writeAttribute("cost",Integer.toString(costTeamTonatiuh));
            xmlWrite.writeAttribute("cities",Integer.toString(idPercorsoTeamTonatiuh.length));
            for (Integer id : idPercorsoTeamTonatiuh) {//print all cities touch
                xmlWrite.writeStartElement("city");
                xmlWrite.writeAttribute("id",id.toString());//print id of city
                xmlWrite.writeAttribute("name",getNameOfCities(id));
                xmlWrite.writeEndElement();//close cities
            }
            xmlWrite.writeEndElement(); //close route

            xmlWrite.writeStartElement("route");//open team Metztli
            xmlWrite.writeAttribute("team", "Metztli");
            xmlWrite.writeAttribute("cost",Integer.toString(costTeamMetztli));
            xmlWrite.writeAttribute("cities",Integer.toString(idPercorsoTeamMetztli.length) );

            for (Integer id1 : idPercorsoTeamMetztli) {//print cities touch
            xmlWrite.writeStartElement("city");
                xmlWrite.writeAttribute("id",id1.toString() );//print id of city
                xmlWrite.writeAttribute("name",getNameOfCities(id1));
                xmlWrite.writeEndElement();//close cities
            }
            xmlWrite.writeEndElement(); //close route
            xmlWrite.writeEndElement(); //close route
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
     * method to get index city of arrayList of cities
     * @param id int id of city
     * @return index of the city
     *          -1 if the city is not found but is impossible because there is check of input
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
     * method to get index city of arrayList of cities
     * @param name input name of city
     * @return index of the city
     *          -1 if the city is not found but is impossible because there is check of input
     */
    private int getCityIndex(String name){
        for (int index = 0; index <arraylistCities.size();index++) {
            if (arraylistCities.get(index).getName().equals(name)){
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

    /**
     * check max id of all city to change id equals
     * @return id max +1
     */
    private int foundMaxId(){
        int id = 0;
        for (City city : arraylistCities){
            if(id < city.getId() ) id = city.getId();
        }
        return id+1;
    }
    }