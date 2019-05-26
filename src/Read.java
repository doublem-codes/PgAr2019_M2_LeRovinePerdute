import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Read {

    private String HEADER = " ";

    /**
     *
     * @param fileName : it contains the string of the xml file to read
     * @param strHeader: it contains the string of the header
     * @return : the element you are reading
     */

    public ArrayList<City> readXML(String fileName, String strHeader) {
        int id = 0;
        String name = null ;
        int x =0 ;
        int y=0;
        int h=0;
        ArrayList<Citydistance> citydistanceArrayList =new ArrayList<>();
        ArrayList<City> cities = new ArrayList<>();

        HEADER = strHeader;
        boolean setup = true;
        boolean imAtHeader = false;
        Element root = null;
        Element eHeader = null;
        Element genericItem = null;
        Attribute attribute = null;
        boolean temp = false;

        try {
            XMLInputFactory xmlif=XMLInputFactory.newInstance();
            XMLStreamReader xmlr = xmlif.createXMLStreamReader(fileName, new FileInputStream(fileName));
            while(xmlr.hasNext()) {
                switch(xmlr.getEventType()) {
                    case XMLStreamConstants.START_DOCUMENT:
                        setup = true;
                        imAtHeader = false;
                        System.out.println("Start Read Doc " + fileName);
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        String startTag = xmlr.getLocalName();
                        if(setup) {
                            root = new Element(startTag);
                            for(int i = 0; i < xmlr.getAttributeCount(); i++) {
                            }
                            setup = false;
                        }
                        else {

                            if(startTag.equals(HEADER)) {
                                eHeader = new Element(startTag);
                                for(int i = 0; i < xmlr.getAttributeCount(); i++) {
                                    switch (i){
                                        case 0:
                                            id=Integer.parseInt(xmlr.getAttributeValue(i));
                                            break;
                                        case 1:
                                            name = xmlr.getAttributeValue(i);
                                            break;
                                        case 2:
                                            x = Integer.parseInt(xmlr.getAttributeValue(i));
                                            break;
                                        case 3:
                                            y=Integer.parseInt(xmlr.getAttributeValue(i));
                                            break;
                                        case 4:
                                            h= Integer.parseInt(xmlr.getAttributeValue(i));
                                            break;
                                    }
                                }

                                root.getElementsRoot().add(eHeader);
                                imAtHeader = true;
                            }
                            else {
                                //link connected
                                imAtHeader = false;
                                for (int i = 0; i < xmlr.getAttributeCount(); i++) {
                                    Citydistance citydistance = new Citydistance();
                                    citydistance.setIdConnected(Integer.parseInt(xmlr.getAttributeValue(i)));
                                    citydistanceArrayList.add(citydistance);
                                }
                            }
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        String endTag = xmlr.getLocalName();
                        if(endTag.equals("city")){
                            ArrayList<Citydistance> citydistances = new ArrayList<Citydistance>(citydistanceArrayList);
                            Coordinate coordinate = new Coordinate(x,y,h);
                            City city = new City(id,name,citydistances,coordinate);
                            cities.add(city);
                            citydistanceArrayList.clear();
                        }
                        if(endTag.equals(root.getName())) {
                            System.out.println("End Read Doc " + fileName);
                        }
                        break;
                    case XMLStreamConstants.NOTATION_DECLARATION:
                        System.out.println("Inside "+xmlr.getText());
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String character = xmlr.getText();

                        if(character.trim().length()>0)
                            if(setup) {
                                root.setCharacter(character);
                            }
                            else {
                                if(imAtHeader) {
                                    eHeader.setCharacter(character);
                                }
                                else {
                                    genericItem.setCharacter(character);
                                }
                            }
                        break;
                    default:
                        break;
                }
                xmlr.next();
            }
        }
        catch(Exception e){
            System.err.println("Error detected");
            System.err.println(e.getMessage());
        }
        return cities;
    }

}
