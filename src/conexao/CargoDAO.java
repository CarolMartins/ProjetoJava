
package conexao;

import Classes.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author carolina
 */
public class CargoDAO {
    public void salvar(Cargo cargo){
        try {
            ConnectionFactory factory = new ConnectionFactory();
            Connection conn = factory.getConnection();
            PreparedStatement ps = conn.prepareStatement(" insert into cargo (Descricao, Salario, Comissao) " +
                                                         "values ( ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString (1, cargo.getDescricao());
            ps.setDouble(2, cargo.getSalario());
            ps.setDouble(3, cargo.getComissao());
            ps.executeUpdate();
            
            //Retornando o código do Id gerado e insere no cargo
            ResultSet rscodigo = ps.getGeneratedKeys();
            if(rscodigo.next())
                cargo.setId(rscodigo.getInt(1));
            
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
                                                     
    }
}
