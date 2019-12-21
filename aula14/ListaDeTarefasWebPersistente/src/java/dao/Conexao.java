package dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Driver driver;

    private static void registrarDriver() {

        if (Conexao.driver == null) {

            try {
                Driver driver = new Driver();

                DriverManager.registerDriver(driver);

                Conexao.driver = driver;

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public static Connection abrirConexao() throws SQLException {

        registrarDriver();
        return DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
//        initDataSource();
//        return ds.getConnection();

    }

//    private static DataSource ds = null;
//
//    private static void initDataSource() {
//
//        if (ds == null) {
//            try {
//                Context ctx = new InitialContext();
//                DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MySQL");
//
//                Conexao.ds = ds;
//
//            } catch (NamingException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
}
