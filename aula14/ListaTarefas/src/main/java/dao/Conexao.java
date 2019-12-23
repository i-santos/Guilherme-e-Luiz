package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.postgresql.Driver;

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
        // environment = ambiente
        String url = System.getenv("JDBC_DATABASE_URL");
        return DriverManager.getConnection(url);

    }
}
