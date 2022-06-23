import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void createTable() {

        Connection conn = null;
        Statement stmt = null;
        try {
            // Register JDBC driver
            Class.forName(Controller.JDBC_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(Controller.DB_URL);

            // Execute a query
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS COMPANY " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " name VARCHAR(255) not NULL UNIQUE," +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);

            // Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try
        } //end try
    }
}
