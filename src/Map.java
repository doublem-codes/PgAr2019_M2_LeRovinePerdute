import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * class map
 */
public class Map {
    // variable for write xmlc
    private XMLOutputFactory xmlOut = null;
    private XMLStreamWriter xmlWrite = null;
    private ArrayList<City> arraylistCities; //arrayList of all city of the map
    private Integer idPercorsoTeamTonatiuh[];
    private Integer idPercorsoTeamMetztli[];

    public void conversionToCity(Element element){

    }

    public int calcoloCarburanteTonatiuh(){

        return 0;
    }
    public int calcoloCarburanteMetztli(){

        return 0;
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
        } catch (Exception e) {
            System.out.println("Error_writer:");
            System.out.println(e.getMessage());
        }

        try {
            xmlWrite.writeStartElement("routes"); // open tag xml
            xmlWrite.writeStartElement("route");//open team Tonatiuh
            xmlWrite.writeAttribute("team=", "Tonatiuh" );
            xmlWrite.writeAttribute("cost=",Integer.toString(calcoloCarburanteTonatiuh()));
            xmlWrite.writeAttribute("cities=",Integer.toString(idPercorsoTeamTonatiuh.length));

            for (int i = 0; i < idPercorsoTeamTonatiuh.length; i++) {//print all cities touch
                xmlWrite.writeStartElement("city");
                xmlWrite.writeAttribute("id=",idPercorsoTeamTonatiuh[i].toString());//print id of city
                xmlWrite.writeAttribute("name=",getNameOfCities(idPercorsoTeamTonatiuh[i]));
                xmlWrite.writeEndElement();//close cities
            }
            xmlWrite.writeEndElement(); //close route
            xmlWrite.writeStartElement("route");//open team Metztli
            xmlWrite.writeAttribute("team=", "Metztli");
            xmlWrite.writeAttribute("cost=",Integer.toString(calcoloCarburanteMetztli()));
            xmlWrite.writeAttribute("cities=",Integer.toString(idPercorsoTeamMetztli.length) );

            for (int i = 0; i < idPercorsoTeamMetztli.length; i++) {//print cities touch
                xmlWrite.writeAttribute("id=",idPercorsoTeamMetztli[i].toString() );//print id of city
                xmlWrite.writeAttribute("name=",getNameOfCities(idPercorsoTeamMetztli[i]));
                xmlWrite.writeEndElement();//close cities
            }
            xmlWrite.writeEndElement(); //close route
            xmlWrite.writeEndElement();//closed routes4
            xmlWrite.writeEndElement();//close output
            xmlWrite.writeEndDocument(); //close document
            xmlWrite.flush(); // empty buffer
            xmlWrite.close(); // close all
            return true;

        } catch (Exception e) {

            System.out.println("Error_write");
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * method found name city whit id
     * @param id id of the city
     * @return name of city
     */
    public String getNameOfCities(int id){
        for (City city :arraylistCities) {
            if (city.getId() == id){
                return city.getName();
            }
        }
        return "error";
    }
}
