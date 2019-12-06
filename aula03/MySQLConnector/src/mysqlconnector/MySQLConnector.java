package mysqlconnector;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class MySQLConnector {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o id do usuário: ");
        int id = scanner.nextInt();
        
        procurarUsuario(id);


    }
    
    static void inserirUsuario(String email, String senha) {
        try {
            
            Driver driver = new Driver();
            
            DriverManager.registerDriver(driver);
            
            // http://localhost:8080
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO cadastro_de_usuarios.usuarios (email, senha) VALUES (?, ?)");
            
            stmt.setString(1, email);
            stmt.setString(2, senha);            
            
            int linhasAlteradas = stmt.executeUpdate();
            
            if(linhasAlteradas > 0) {
                System.out.println("Usuário cadastrado com sucesso!");
            } else {
                System.out.println("Usuário não foi cadastrado. Aconteceu algum erro. Tente novamente");
            }
            
        } catch(Exception e) {
            
        }
    }
    
    static void listarUsuarios() {
        try {
            Driver driver = new Driver();
            
            DriverManager.registerDriver(driver);
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            
            PreparedStatement sql = conn.prepareStatement("SELECT * FROM cadastro_de_usuarios.usuarios");
            
            ResultSet rs = sql.executeQuery();
            
            while(rs.next()) {
                
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                
                System.out.println("Usuário:");
                System.out.println("\tId:\t\t" + id);
                System.out.println("\tEmail:\t\t" + email);
                System.out.println("\tSenha:\t\t" + senha);
            }
            
        } catch(SQLException e) {
            
        }
    }
    
    static void procurarUsuario(int id) {
        
        try {
            Driver driver = new Driver();
            
            DriverManager.registerDriver(driver);
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            
            PreparedStatement sql = conn.prepareStatement("SELECT * FROM cadastro_de_usuarios.usuarios WHERE id = ?");
            
            sql.setInt(1, id);
            
            ResultSet rs = sql.executeQuery();
            
            while(rs.next()) {
                
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                
                System.out.println("Usuário:");
                System.out.println("\tId:\t\t" + id);
                System.out.println("\tEmail:\t\t" + email);
                System.out.println("\tSenha:\t\t" + senha);
            }
            
        } catch(SQLException e) {
            
        }
    }

}
