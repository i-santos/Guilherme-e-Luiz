package dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static String DB_URL = "jdbc:mysql://localhost:3306";
    private static String DB_USER = "root";
    private static String DB_PASS = "";
    
    private static Driver driver = null;

    public static Connection getConexao() {

        Connection conn = null;
        
        if(driver == null) {
            registrarDriver();
        }
        
        try {
            
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return conn;
    }

    private static void registrarDriver() {

        if (driver == null) {

            try {
                Driver _driver = new Driver();
                DriverManager.registerDriver(_driver);

                driver = _driver;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
