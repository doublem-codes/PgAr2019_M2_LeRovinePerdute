

public class Main {

    private static final String xmlFileName="codePerson.xml";

    public static void main(String[] args) {

        Reader lettore = new Reader();

        System.out.println("\n -----------------------READING FILE----------------------------------------------\n");

        //read the xml file, while the reader read the xml file it also check if parameters are wrong or right
        Element rootCommon = lettore.read("comuni.txt", "comune");
        Element rootCodeFiscal = lettore.read("codiciFiscali.txt", "codice");
        Element rootPerson = lettore.read("inputPersone.txt", "persona");

        //set the array from the reader to the ArrayList of Common, FiscalCode, Person


        //save the fiscalCode in an output xml file and print on console some Insights
        System.out.println("\n -----------------------SAVING FILE----------------------------------------------\n");
        //save the xml output
       /* if (systemcode.writeXmlOutput(xmlFileName,"utf-8")){
            System.out.println("File saved !" + "... as: "+ xmlFileName);

            //printing the insights
            int totalNumberOfFiscalCode = systemcode.getRightFiscalCode().size()+systemcode.getWrongFiscalCode().size();
            System.out.print("\n-\tNumber of right fiscal code: " + systemcode.getRightFiscalCode().size() + " / " + totalNumberOfFiscalCode + "\t" + (((float)systemcode.getRightFiscalCode().size()/(float)totalNumberOfFiscalCode)*100) + " %" +
                    "\n-\tNumber of wrong fiscal code: " + systemcode.getWrongFiscalCode().size() + " / " + totalNumberOfFiscalCode + "\t" + ((float)systemcode.getWrongFiscalCode().size()/(float)totalNumberOfFiscalCode)*100 + " %" +
                    "\n-\tNumber of unpaired fiscal code: " + systemcode.getUnpairedFiscalCode().size() + " / " + totalNumberOfFiscalCode + "\t" + ((float)systemcode.getUnpairedFiscalCode().size()/(float)totalNumberOfFiscalCode)*100 + " %"+
                    "\n\n-\tsee xml file output for more details");
        }else{
            System.out.println("File not saved !" + "Some error has occurred");
        }*/

    }
}
