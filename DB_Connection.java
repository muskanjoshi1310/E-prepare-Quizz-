package Eprepration;
import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {
    static Connection con; 

    public static Connection getConnection() {
        try {

            String mysqlJDBCDriver = "com.mysql.cj.jdbc.Driver"; 
            String url = "jdbc:mysql://localhost:3306/ epreparationsystem";
            String user = "root"; 
            String pass = "12345"; 
            Class.forName(mysqlJDBCDriver);
            con = DriverManager.getConnection(url, user, pass);
        } 
        catch (Exception e) {
            System.out.println("Connection Failed!");
        }

        return con;
    }
}