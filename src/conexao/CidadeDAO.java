
package conexao;

import Classes.Cidade;
import Classes.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carolina
 */
public class CidadeDAO {
    ConnectionFactory factory = new ConnectionFactory();
    
    public List<Cidade> listarCidade(int idEstado){
        Connection conn = factory.getConnection();
        List<Cidade> cidades = new ArrayList <>();
        try {
            PreparedStatement ps = null;
            ResultSet rsCodigo = null;
            
            String sql = "select * from cidade where idEstado = ? order by NomeCidade asc";
            ps = conn.prepareStatement(sql); 
            ps.setInt(1, idEstado);
            rsCodigo = ps.executeQuery();
            
            while(rsCodigo.next()){
                
                Cidade c = new Cidade();
                c.setId(rsCodigo.getInt("idCidade"));
                c.setNomeCidade(rsCodigo.getString("NomeCidade"));
                
                cidades.add(c);
                
            }
            conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return cidades;
}
}
