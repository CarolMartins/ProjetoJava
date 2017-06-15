
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carolina
 */
public class ConnectionFactory {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/projetojava";
    private String user = "root";
    private String pass = "123456";
    
    public Connection getConnection(){
       
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, pass);
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro de Conexão", ex);
        }
    }
}
