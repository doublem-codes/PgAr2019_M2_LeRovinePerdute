/**
 * ROVINE PERDUTE
 * @author M2
 * @version 2.5
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n -----------------------START----------------------------------------------\n");
        SistemMap systemMap = new SistemMap();
        systemMap.systemInputMap();
        systemMap.systemMap();
        systemMap.systemOutStreet();
        System.out.println("\n -----------------------END----------------------------------------------\n");
    }
}
