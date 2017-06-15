
package conexao;

import Classes.Estado;
import Classes.TipoLogradouro;
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
public class EstadoDAO {
   ConnectionFactory factory = new ConnectionFactory();
    
    public List<Estado> listarEstado(){
         Connection conn = factory.getConnection();
        List<Estado> estados = new ArrayList <>();
        try {
            PreparedStatement ps = null;
            ResultSet rsCodigo = null;
            
            String sql = "select * from estado order by Sigla asc";
            ps = conn.prepareStatement(sql); 
            rsCodigo = ps.executeQuery();
            
            while(rsCodigo.next()){
                
                Estado estado = new Estado();
                estado.setId(rsCodigo.getInt("idEstado"));
                estado.setSigla(rsCodigo.getString("Sigla"));
                estado.setNomeEstado(rsCodigo.getString("NomeEstado"));
                estados.add(estado);
                
            }
            conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return estados;
}
}
