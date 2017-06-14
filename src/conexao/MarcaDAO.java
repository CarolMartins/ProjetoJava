/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import Classes.MarcaProduto;
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
public class MarcaDAO {
    ConnectionFactory factory = new ConnectionFactory();
    Connection conn = factory.getConnection();
    
    public void salvar(MarcaProduto marca){
        try {
            PreparedStatement ps = conn.prepareStatement("insert into marca (Marca)" 
                                     + "values (?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, marca.getMarca());
            ps.executeUpdate();
            ResultSet rsCodigo = ps.getGeneratedKeys();
            if (rsCodigo.next())
                marca.setId(rsCodigo.getInt(1));
                
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }      
    }
    
    public void excluir(MarcaProduto marca){
        try {
            String sql = "delete from marca where idMarca = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, marca.getId());
            ps.executeUpdate();
            conn.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao deletar " + ex);
            }    
    }
    public void editar(MarcaProduto marca){
        try {
            String sql = ("UPDATE marca set Marca = ? where idMarca = ?");
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, marca.getMarca());
            ps.setInt (2, marca.getId());
            ps.executeUpdate();
            conn.close();
            
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar " + ex);
            }           
    }

    /**
     *
     * @return
     */
    public List<MarcaProduto> listarMarca(){
        List<MarcaProduto> marca = new ArrayList <>();
        try {
            PreparedStatement ps = null;
            ResultSet rsCodigo = null;
            
            String sql = "select * from marca";
            ps = conn.prepareStatement(sql); 
            rsCodigo = ps.executeQuery();
            
            while(rsCodigo.next()){
                
                MarcaProduto marcaProduto = new MarcaProduto();
                marcaProduto.setId(rsCodigo.getInt("idMarca"));
                marcaProduto.setMarca(rsCodigo.getString("Marca"));
                
               marca.add(marcaProduto);   
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return marca;
}
}
