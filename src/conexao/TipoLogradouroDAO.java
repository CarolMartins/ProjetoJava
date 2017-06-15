
package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Classes.TipoLogradouro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carolina
 */
public class TipoLogradouroDAO {
    ConnectionFactory factory = new ConnectionFactory();
    Connection conn = factory.getConnection();
    
    public void salvar(TipoLogradouro tipoLogradouro){
        try {
            
            PreparedStatement ps = conn.prepareStatement("insert into tipologradouro (Sigla, Descricao) "
                                                         + "values (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, tipoLogradouro.getSigla());
            ps.setString(2, tipoLogradouro.getNome());
            ps.executeUpdate();
            ResultSet rsCodigo = ps.getGeneratedKeys();
            if (rsCodigo.next())
                tipoLogradouro.setId(rsCodigo.getInt(1));
            
            conn.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void excluir(TipoLogradouro tipoLogradouro){
        try {
            String sql = "delete from tipologradouro where idTipoLogradouro = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, tipoLogradouro.getId());
            ps.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao deletar " + ex);
            }
                
                
    }
    
    public void editar(TipoLogradouro tipoLogradouro){
        
        
        try {
            String sql = ("UPDATE tipologradouro set Sigla = ?, Descricao = ? where idTipoLogradouro = ?");
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tipoLogradouro.getSigla());
            ps.setString(2, tipoLogradouro.getNome());
            ps.setInt (3, tipoLogradouro.getId());
            ps.executeUpdate();
            conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar " + ex);
              }           
    }
    
    
    public List<TipoLogradouro> listarTipoLogradouro(){
        List<TipoLogradouro> logradouro = new ArrayList <>();
        try {
            PreparedStatement ps = null;
            ResultSet rsCodigo = null;
            
            String sql = "select * from tipologradouro order by Sigla asc";
            ps = conn.prepareStatement(sql); 
            rsCodigo = ps.executeQuery();
            
            while(rsCodigo.next()){
                
                TipoLogradouro tipoLogradouro = new TipoLogradouro();
                tipoLogradouro.setId(rsCodigo.getInt("idTipoLogradouro"));
                tipoLogradouro.setSigla(rsCodigo.getString("Sigla"));
                tipoLogradouro.setNome(rsCodigo.getString("descricao"));
                logradouro.add(tipoLogradouro);
                
            }
            conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return logradouro;
}
}


    
        

