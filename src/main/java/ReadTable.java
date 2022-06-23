import java.sql.*;

public class ReadTable {

    public static void readTable() {

        Connection conn = null;
        Statement stmt = null;

        try {
            // Register JDBC driver
            Class.forName(Controller.JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(Controller.DB_URL);

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT id, name FROM COMPANY";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");

                String name = rs.getString("name");

                //Display values
                System.out.print(id + ". " + name);
            }

            //Clean-up environment
            rs.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }
}
