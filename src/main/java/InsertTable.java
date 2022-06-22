import View.View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTable {

    public static void insertTable() {
        Scanner scanner = new Scanner(System.in);

        View.showEnterTheCompanyName();
        String input = scanner.nextLine();

        Connection conn = null;
        Statement stmt = null;
        try{
            // Register JDBC driver
            Class.forName(Controller.JDBC_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(Controller.DB_URL);
            conn.setAutoCommit(true);


            // Execute a query
            stmt = conn.createStatement();
            String sql = "INSERT INTO COMPANY(name) VALUES('"+input+"')";
            stmt.executeUpdate(sql);

            System.out.println("The company was created!");

            // Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(stmt !=null) stmt.close();
            } catch(SQLException se2) {
            }
            try {
                if(conn !=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }
}
