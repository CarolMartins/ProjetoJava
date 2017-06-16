/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import Classes.GrupoProduto;
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
public class GrupoProdutoDAO {
    ConnectionFactory factory = new ConnectionFactory();
    Connection conn = factory.getConnection();
    
    public void salvar(GrupoProduto grupo){
        try {
            
            PreparedStatement ps = conn.prepareStatement("insert into grupo (Grupo) "
                                                         + "values (?)", PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, grupo.getGrupo());
            ps.executeUpdate();
            ResultSet rsCodigo = ps.getGeneratedKeys();
            if (rsCodigo.next())
                grupo.setId(rsCodigo.getInt(1));
            
            conn.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    public void excluir(GrupoProduto grupo){
        try {
            String sql = "delete from grupo where idGrupo = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, grupo.getId());
            ps.executeUpdate();
            conn.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao deletar " + ex);
            }    
    }
    public void editar(GrupoProduto grupo){
        try {
            String sql = ("UPDATE grupo set Grupo = ? where idGrupo = ?");
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, grupo.getGrupo());
            ps.setInt (2, grupo.getId());
            ps.executeUpdate();
            conn.close();
            
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar " + ex);
            }           
    }
    public List<GrupoProduto> listarGrupo(){
        List<GrupoProduto> grupo = new ArrayList <>();
        try {
            PreparedStatement ps = null;
            ResultSet rsCodigo = null;
            
            String sql = "select * from grupo";
            ps = conn.prepareStatement(sql); 
            rsCodigo = ps.executeQuery();
            
            while(rsCodigo.next()){
                
                GrupoProduto grupoProduto = new GrupoProduto();
                grupoProduto.setId(rsCodigo.getInt("idGrupo"));
                grupoProduto.setGrupo(rsCodigo.getString("Grupo"));
                
                grupo.add(grupoProduto);
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return grupo;
}
}
