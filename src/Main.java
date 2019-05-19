public class Main {

    private static final String xmlFileName5="StreetToRovine5.xml";
    private static final String xmlFileName12="StreetToRovine12.xml";
    private static final String xmlFileName50="StreetToRovine50.xml";
    private static final String xmlFileName200="StreetToRovine200.xml";
    private static final String xmlFileName2000="StreetToRovine2000.xml";
    private static final String xmlFileName10000="StreetToRovine10000.xml";

    public static void main(String[] args) {

        Map map5 = new Map();
        Map map12 = new Map();
        Map map50 = new Map();
        Map map200 = new Map();
        Map map2000 = new Map();
        Map map10000 = new Map();
        Reader lettore = new Reader();

        System.out.println("\n -----------------------READING FILE----------------------------------------------\n");

        //read the xml file, while the reader read the xml file it also check if parameters are wrong or right
        Element rootMap5 = lettore.read("PgAr_Map_5.txt", "city");
        Element rootMap12 = lettore.read("PgAr_Map_12.txt", "city");
        Element rootMap50 = lettore.read("PgAr_Map_50.txt", "city");
        Element rootMap200 = lettore.read("PgAr_Map_200.txt", "city");
        Element rootMap2000 = lettore.read("PgAr_Map_2000.txt", "city");
        Element rootMap10000 = lettore.read("PgAr_Map_10000.txt", "city");

        System.out.println("\n -----------------------CONVERSION FILE----------------------------------------------\n");
        map5.conversionToCity(rootMap5);
        map12.conversionToCity(rootMap12);
        map50.conversionToCity(rootMap50);
        map200.conversionToCity(rootMap200);
        map2000.conversionToCity(rootMap2000);
        map10000.conversionToCity(rootMap10000);
        System.out.println("\n -----------------------CALCULATE BETTER STREET TEAM TONATIUH----------------------------------------------\n");

        System.out.println("\n -----------------------CALCULATE BETTER STREET TEAM METZTLI----------------------------------------------\n");
        
        System.out.println("\n -----------------------SAVING FILE----------------------------------------------\n");
        if(map5.xmlWrite()){
            System.out.println("File "+ xmlFileName5+ "right generation");
        }else{
            System.out.println("File "+ xmlFileName5+ "not saved ! \t Some error has occurred");
        }
        if(map12.xmlWrite()){
            System.out.println("File "+ xmlFileName12+ "right generation");
        }else{
            System.out.println("File "+ xmlFileName12+ "not saved ! \t Some error has occurred");
        }
        if(map50.xmlWrite()){
            System.out.println("File "+ xmlFileName50+ "right generation");
        }else{
            System.out.println("File "+ xmlFileName50+ "not saved ! \t Some error has occurred");
        }
        if(map200.xmlWrite()){
            System.out.println("File "+ xmlFileName200+ "right generation");
        }else{
            System.out.println("File "+ xmlFileName200+ "not saved ! \t Some error has occurred");
        }
        if(map2000.xmlWrite()){
            System.out.println("File "+ xmlFileName2000+ "right generation");
        }else{
            System.out.println("File "+ xmlFileName2000+ "not saved ! \t Some error has occurred");
        }
        if(map10000.xmlWrite()){
            System.out.println("File "+ xmlFileName10000+ "right generation");
        }else{
            System.out.println("File "+ xmlFileName10000+ "not saved ! \t Some error has occurred");
        }
    }
}
