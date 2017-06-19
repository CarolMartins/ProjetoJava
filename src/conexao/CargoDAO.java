
package conexao;

import Classes.Cargo;
import Classes.TipoLogradouro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author carolina
 */
public class CargoDAO {
    ConnectionFactory factory = new ConnectionFactory();
    
    public void salvar(Cargo cargo){
        try {
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
    
    public List<Cargo> listarCargo(){
        Connection conn = factory.getConnection();
        List<Cargo> cargo = new ArrayList <>();
        try {
            PreparedStatement ps = null;
            ResultSet rsCodigo = null;
            
            String sql = "select * from cargo order by Descricao asc";
            ps = conn.prepareStatement(sql); 
            rsCodigo = ps.executeQuery();
            
            while(rsCodigo.next()){
                
                Cargo c = new Cargo();
                c.setId(rsCodigo.getInt("idCargo"));
                c.setDescricao(rsCodigo.getString("Descricao"));
                c.setComissao(rsCodigo.getDouble("Comissao"));
                c.setSalario(rsCodigo.getDouble("Salario"));
                
                cargo.add(c);
                
            }
            conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return cargo;
    }

    public void editar(Cargo cargo){
        
        Connection conn = factory.getConnection();
        try {
            String sql = ("UPDATE cargo set Descricao = ?, Salario = ?, Comissao = ? where idCargo = ?");
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cargo.getDescricao());
            ps.setDouble(2, cargo.getSalario());
            ps.setDouble (3, cargo.getComissao());
            ps.setInt(4, cargo.getId());
            ps.executeUpdate();
            conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar " + ex);
              }           
    }
    
    public void excluir(Cargo cargo ){
        Connection conn = factory.getConnection();
        
        try {
            String sql = "delete from cargo where idCargo = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, cargo.getId());
            ps.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao deletar " + ex);
            }
                
                
    }
}

    
    

