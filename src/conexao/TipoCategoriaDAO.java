/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import Classes.TipoCategoriaProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author robert
 */
public class TipoCategoriaDAO {
    ConnectionFactory factory = new ConnectionFactory();
    Connection conn = factory.getConnection();
    
    public void salvar (TipoCategoriaProduto tipoCategoria){
        try {
            PreparedStatement ps = conn.prepareStatement("insert into tipocategoriaproduto (TipoCategoria) "
                                                         + "values (?)", PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, tipoCategoria.getTipoCategoria());
            ps.executeUpdate();
            ResultSet rsCodigo = ps.getGeneratedKeys();
            if (rsCodigo.next())
                tipoCategoria.setId(rsCodigo.getInt(1));
         conn.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }     
}
    public void excluir(TipoCategoriaProduto tipoCategoria){
        try {
            String sql = "delete from tipocategoriaproduto where idTipoCategoriaProduto = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, tipoCategoria.getId());
            ps.executeUpdate();
            
            conn.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao deletar " + ex);
            }               
    }
    
    public void editar(TipoCategoriaProduto tipoCategoria){
        try {
            String sql = ("UPDATE tipocategoriaproduto set TipoCategoria = ? where idTipoCategoriaProduto = ?");
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tipoCategoria.getTipoCategoria());
            ps.setInt (2, tipoCategoria.getId());
            ps.executeUpdate();
            
            conn.close();
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar " + ex);
              }           
    }
public List<TipoCategoriaProduto> listarTipoCategoria(){
        List<TipoCategoriaProduto> categoria = new ArrayList <>();
        try {
            PreparedStatement ps = null;
            ResultSet rsCodigo = null;
            
            String sql = "select * from tipocategoriaproduto order by TipoCategoria asc";
            ps = conn.prepareStatement(sql); 
            rsCodigo = ps.executeQuery();
            
            while(rsCodigo.next()){
                
                TipoCategoriaProduto tipoCategoria = new TipoCategoriaProduto();
                tipoCategoria.setId(rsCodigo.getInt("idTipoCategoriaProduto"));
                tipoCategoria.setTipoCategoria(rsCodigo.getString("TipoCategoria"));
                categoria.add(tipoCategoria);
                
            }
            conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return categoria;
}
}
