package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private  String url="jdbc:mysql://localhost:3306/esprit";
    private  String user="root";
    private  String password="";

    private static DataSource data;

    private Connection con;

    private DataSource() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("cnx etablie");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static DataSource getInstance() {
        if (data == null) {
            data = new DataSource();
        }
        return data;
    }
    public Connection getConnection() {
        return con;
    }


    
}
