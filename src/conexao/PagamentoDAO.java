/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import Classes.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author connect
 */
public class PagamentoDAO {
    ConnectionFactory factory = new ConnectionFactory();
    Connection conn = factory.getConnection();
    
    public void salvar(Pagamento pagamento){
        try {
            PreparedStatement ps = conn.prepareStatement("insert into pagamento (ValorRecebido, Troco, idTipoPagamento)" 
                                     + "values (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, pagamento.getValorRecebido());
            ps.setDouble(2, pagamento.getTroco());
            ps.setInt(3, pagamento.getTipoPagamento().getId());
            ps.executeUpdate();
            ResultSet rsCodigo = ps.getGeneratedKeys();
            if (rsCodigo.next())
                pagamento.setIdPagamento(rsCodigo.getInt(1));
                
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }      
    }
}
