package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    public Connection con;
    String username = "root";
    String password = "";
    String url = "jdbc:mysql://localhost/db";

    public void connect() throws ClassNotFoundException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection successful....");
        }
        catch (SQLException ex){
            System.out.println("Connection failed....");

        }
    }

}
