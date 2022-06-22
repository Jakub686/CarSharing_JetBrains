public class Controller {


    // JDBC driver name and database URL
    public static final String JDBC_DRIVER = "org.h2.Driver";
    public static final String DB_URL = "jdbc:h2:file:C:\\Users\\JJ\\IdeaProjects\\CarSharing_JetBrains\\src\\main\\java\\db\\h2";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public static void controller() {

        CreateTable.createTable();
        MenuMain.mainMenu();
    }
}
