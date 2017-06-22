/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import Classes.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Classes.Estoque;
import Classes.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carolina
 */
public class EstoqueDAO {
    
    ConnectionFactory factory = new ConnectionFactory();
    
    public void salvar(Estoque estoque){
        
        try {
            Connection conn = factory.getConnection();
            PreparedStatement ps = conn.prepareStatement(" insert into estoque (idProduto, quantidade, dataentrada) " +
                                                         "values ( ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt (1, estoque.getProduto().getIdProduto());
            ps.setInt(2, estoque.getQuantidade());
            ps.setDate(3, new java.sql.Date(estoque.getDataEntrada().getTime()));
            ps.executeUpdate();
            
            //Retornando o código do Id gerado e insere no cargo
            ResultSet rscodigo = ps.getGeneratedKeys();
            if(rscodigo.next())
                estoque.setId(rscodigo.getInt(1));
            
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }                                                
    }
    
    public void editar(Estoque estoque){
        
        Connection conn = factory.getConnection();
        try {
            String sql = ("UPDATE estoque set idProduto = ?, quantidade = ? where idestoque = ?");
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, estoque.getProduto().getIdProduto());
            ps.setInt(2, estoque.getQuantidade());
            ps.setInt(3, estoque.getId());
            ps.executeUpdate();
            conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar " + ex);
              }           
    }
    
    public void excluir(Estoque estoque ){
        Connection conn = factory.getConnection();
        
        try {
            String sql = "delete from estoque where idestoque = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, estoque.getId());
            ps.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao deletar " + ex);
            }            
    }
    
    public List<Estoque> listarEstoque(){
        Connection conn = factory.getConnection();
        List<Estoque> estoques = new ArrayList <>();
        try {
            PreparedStatement ps = null;
            ResultSet rsCodigo = null;
            
            String sql = "select * from estoque \n" +
                         "join produto on estoque.idProduto = produto.idProduto \n" +
                         "order by DescricaoProduto asc";
            ps = conn.prepareStatement(sql); 
            rsCodigo = ps.executeQuery();
            
            while(rsCodigo.next()){
                
                Estoque e = new Estoque();
                e.setId(rsCodigo.getInt("idestoque"));
                Produto p = new Produto();
                p.setIdProduto(rsCodigo.getInt("idProduto"));
                p.setDescricaoProduto(rsCodigo.getString("descricaoProduto"));
                e.setProduto(p);
                e.setQuantidade(rsCodigo.getInt("quantidade"));
                e.setDataEntrada(rsCodigo.getDate("dataentrada"));
                
                estoques.add(e);
                
            }
            conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return estoques;
    }
}
