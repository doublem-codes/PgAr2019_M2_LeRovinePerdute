public class SistemMap {
    //name of file of input
    private String xmlInputFileName5 = "PgAr_Map_5.txt";
    private String xmlInputFileName12 = "PgAr_Map_12.txt";
    private String xmlInputFileName50 = "PgAr_Map_50.txt";
    private String xmlInputFileName200 = "PgAr_Map_200.txt";
    private String xmlInputFileName2000 = "PgAr_Map_2000.txt";
    private String xmlInputFileName10000 = "PgAr_Map_10000.txt";

    //name of file of output
    private String xmlOutputFileName5 = "StreetToRovine5.xml";
    private String xmlOutputFileName12 = "StreetToRovine12.xml";
    private String xmlOutputFileName50 = "StreetToRovine50.xml";
    private String xmlOutputFileName200 = "StreetToRovine200.xml";
    private String xmlOutputFileName2000 = "StreetToRovine2000.xml";
    private String xmlOutputFileName10000 = "StreetToRovine10000.xml";

    // all type of map for this program;
    Map map5 = new Map(); //map dimension 5
    Map map12 = new Map(); //map dimension12
    Map map50 = new Map(); //map dimension50
    Map map200 = new Map(); //map dimension 200
    Map map2000 = new Map(); //map dimension 2000
    Map map10000 = new Map(); //map dimension 10000

    //element for each map
    Element rootMap5 ; // element map 5
    Element rootMap12 ; // element map 12
    Element rootMap50 ; // element map 50
    Element rootMap200 ; // element map 200
    Element rootMap2000 ; // element map 2000
    Element rootMap10000 ; // element map 10000

    /**
     * method to read xml file of different map
     */
    public void systemInputMap(){
        Reader lettore = new Reader();
        System.out.println("\n -----------------------READING FILE----------------------------------------------\n");
        //read the xml file, while the reader read the xml file it also check if parameters are wrong or right
        rootMap5 = lettore.read(xmlInputFileName5, "city");
        rootMap12 = lettore.read(xmlInputFileName12, "city");
        rootMap50 = lettore.read(xmlInputFileName50, "city");
        rootMap200 = lettore.read(xmlInputFileName200, "city");
        rootMap2000 = lettore.read(xmlInputFileName2000, "city");
        rootMap10000 = lettore.read(xmlInputFileName10000, "city");
    }

    /**
     * method to convert Element in map and then calculate the better street for each team
     */
    public void systemMap() {

        System.out.println("\n -----------------------CONVERSION FILE----------------------------------------------\n");
        map5.conversionToCity(rootMap5);
        map12.conversionToCity(rootMap12);
        map50.conversionToCity(rootMap50);
        map200.conversionToCity(rootMap200);
        map2000.conversionToCity(rootMap2000);
        map10000.conversionToCity(rootMap10000);

        System.out.println("\n -----------------------CALCULATE BETTER STREET TEAM TONATIUH----------------------------------------------\n");
        map5.calcStreetTeamTonatiuh();
        map12.calcStreetTeamTonatiuh();
        map50.calcStreetTeamTonatiuh();
        map200.calcStreetTeamTonatiuh();
        map2000.calcStreetTeamTonatiuh();
        map10000.calcStreetTeamTonatiuh();

        System.out.println("\n -----------------------CALCULATE BETTER STREET TEAM METZTLI----------------------------------------------\n");
        map5.calcStreetTeamMetztli();
        map12.calcStreetTeamMetztli();
        map50.calcStreetTeamMetztli();
        map200.calcStreetTeamMetztli();
        map2000.calcStreetTeamMetztli();
        map10000.calcStreetTeamMetztli();
    }

    /**
     * method to print all file of output whit his street
     */
    public void systemOutStreet(){
        System.out.println("\n -----------------------SAVING FILE----------------------------------------------\n");
        if (map5.xmlWrite(xmlOutputFileName5, "utf-8")) {
            System.out.println("File " + xmlOutputFileName5 + "right generation");
        } else {
            System.out.println("File " + xmlOutputFileName5 + "not saved ! \t Some error has occurred");
        }
        if (map12.xmlWrite(xmlOutputFileName12, "utf-8")) {
            System.out.println("File " + xmlOutputFileName12 + "right generation");
        } else {
            System.out.println("File " + xmlOutputFileName12 + "not saved ! \t Some error has occurred");
        }
        if (map50.xmlWrite(xmlOutputFileName50, "utf-8")) {
            System.out.println("File " + xmlOutputFileName50 + "right generation");
        } else {
            System.out.println("File " + xmlOutputFileName50 + "not saved ! \t Some error has occurred");
        }
        if (map200.xmlWrite(xmlOutputFileName200, "utf-8")) {
            System.out.println("File " + xmlOutputFileName200 + "right generation");
        } else {
            System.out.println("File " + xmlOutputFileName200 + "not saved ! \t Some error has occurred");
        }
        if (map2000.xmlWrite(xmlOutputFileName2000, "utf-8")) {
            System.out.println("File " + xmlOutputFileName2000 + "right generation");
        } else {
            System.out.println("File " + xmlOutputFileName2000 + "not saved ! \t Some error has occurred");
        }
        if (map10000.xmlWrite(xmlOutputFileName10000, "utf-8")) {
            System.out.println("File " + xmlOutputFileName10000 + "right generation");
        } else {
            System.out.println("File " + xmlOutputFileName10000 + "not saved ! \t Some error has occurred");
        }
        System.out.println("\n -----------------------ALL FILE STAMP----------------------------------------------\n");
    }
}