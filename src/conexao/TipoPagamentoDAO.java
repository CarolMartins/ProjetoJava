/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;


import Classes.TipoPagamento;
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
public class TipoPagamentoDAO {
    ConnectionFactory factory = new ConnectionFactory();
    Connection conn = factory.getConnection();
    
   
    public List<TipoPagamento> listar(){
        List<TipoPagamento> tipoPagamentos = new ArrayList <>();
        try {
            PreparedStatement ps = null;
            ResultSet rsCodigo = null;
            
            String sql = "select * from tipopagamento";
            ps = conn.prepareStatement(sql); 
            rsCodigo = ps.executeQuery();
            
            while(rsCodigo.next()){
                
                TipoPagamento tipoPagamento = new TipoPagamento();
                tipoPagamento.setId(rsCodigo.getInt("idTipoPagamento"));
                tipoPagamento.setTipoPagamento(rsCodigo.getString("TipoPagamento"));
                
               tipoPagamentos.add(tipoPagamento);   
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return tipoPagamentos;
    }
}
