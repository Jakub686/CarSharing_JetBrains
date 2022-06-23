import java.sql.*;

public class IsTableEmpty {
    public static void isTableEmpty(){

        Connection conn = null;
        Statement stmt = null;

        try {
            //Register JDBC driver
            Class.forName(Controller.JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(Controller.DB_URL);

            // Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT count(*), FROM COMPANY";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            //Executing the query
            rs = stmt.executeQuery(sql);
            //Retrieving the result
            rs.next();
            int count = rs.getInt(1);
            if(count == 0)
                System.out.println("The company list is empty!");


            // Clean-up environment
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
