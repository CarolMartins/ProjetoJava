/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import Classes.Fornecedor;
import Classes.GrupoProduto;
import Classes.MarcaProduto;
import Classes.Produto;
import Classes.TipoCategoriaProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author robert
 */
public class ProdutoDAO {
    ConnectionFactory factory = new ConnectionFactory();
    Connection conn = factory.getConnection();
    
    public void salvar(Produto p){
        try {
           PreparedStatement ps = conn.prepareStatement ("insert into produto(CodigoBarra, CodigoProduto, StatusProduto,"
                                                         + "DescricaoProduto, Peso, PrecoCusto, MargemLucro, PrecoVenda,"
                                                         + "QuantidadeRecebida, EstoqueAtual, IdFornecedor, IdTipoCategoriaProduto,"
                                                         + " IdMarca, IdGrupo, IdIcmcs)" 
                                                         + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
           ps.setInt(1, p.getCodigoBarra());
           ps.setInt(2, p.getCodigo());
           ps.setBoolean(3, p.getStatusProduto());
           ps.setString(3, p.getDescricaoProduto());
           ps.setDouble(5, p.getPeso());
           ps.setDouble(6,p.getPrecoCusto());
           ps.setDouble(7,p.getMargemLucro());
           ps.setDouble(8, p.getPrecoVenda());
           ps.setInt(9, p.getQtdRecebida());
           ps.setInt(10, p.getEstoqueAtual());
           ps.setInt(11, p.getFornecedor().getId());
           ps.setInt(12, p.getTipoCategoria().getId());
           ps.setInt(13, p.getMarca().getId());
           ps.setInt(13, p.getGrupo().getId());
           ps.setInt(15, p.getIcms().getId());
           
           ps.executeUpdate();
           
           ResultSet rs = ps.getGeneratedKeys();
           if(rs.next())
               p.setCodigo(rs.getInt(1));
           
          conn.close();
           
    }catch (SQLException ex) {
           Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
       }   
}
    
    public void editar(Produto p){
        
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE produto (CodigoBarra = ?, CodigoProduto = ?, StatusProduto= ?,"
                                                         + "DescricaoProduto = ?, Peso = ?, PrecoCusto = ?, MargemLucro = ?, PrecoVenda = ?,"
                                                         + "QuantidadeRecebida = ?, EstoqueAtual = ?, IdFornecedor = ?, IdTipoCategoriaProduto = ?,"
                                                         + " IdMarca = ?, IdGrupo = ?, IdIcmcs = ? where idProduto  = ?)");
            
           ps.setInt(1, p.getCodigoBarra());
           ps.setInt(2, p.getCodigo());
           ps.setBoolean(3, p.getStatusProduto());
           ps.setString(3, p.getDescricaoProduto());
           ps.setDouble(5, p.getPeso());
           ps.setDouble(6,p.getPrecoCusto());
           ps.setDouble(7,p.getMargemLucro());
           ps.setDouble(8, p.getPrecoVenda());
           ps.setInt(9, p.getQtdRecebida());
           ps.setInt(10, p.getEstoqueAtual());
           ps.setInt(11, p.getFornecedor().getId());
           ps.setInt(12, p.getTipoCategoria().getId());
           ps.setInt(13, p.getMarca().getId());
           ps.setInt(13, p.getGrupo().getId());
           ps.setInt(15, p.getIcms().getId());
           ps.executeUpdate();
           
           conn.close();
           
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar " + ex);
            }   
}
    public List<Produto> listarProdutoporDescricao(String descricaoProduto){
        
      List<Produto> produto = new ArrayList <>();
        
        try {
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            
            String sql = "select * \n" +
                         "from produto \n" +
                         "join fornecedor on produto.IdFornecedor = fornecedor.idFornecedor\n" +
                         "join tipocategoriaproduto on produto.IdTipoCategoriaProduto = tipocategoriaproduto.idTipoCategoriaProduto\n" +
                         "join marca on marca.idMarca = produto.IdMarca\n" +
                         "join grupo on grupo.idGrupo = produto.IdMarca\n" +
                         "where produto.DescricaoProduto like '%?%'\n" +
                         "order by produto.DescricaoProduto";
            ps = conn.prepareStatement(sql); 
            ps.setString(1, "%"+descricaoProduto+"%");
            resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                
                Produto p = new Produto();
                p.setIdProduto(resultSet.getInt("idProduto"));
                p.setCodigo(resultSet.getInt("CodigoProduto"));
                p.setCodigoBarra(resultSet.getInt("CodigoBarra"));
                p.setStatusProduto(resultSet.getBoolean("StatusProduto"));
                p.setDescricaoProduto(resultSet.getString("DescricaoProduto"));
                p.setPeso(resultSet.getDouble("Peso"));
                p.setPrecoCusto(resultSet.getDouble("PrecoCusto"));
                p.setMargemLucro(resultSet.getDouble("MargemLucro"));
                p.setQtdRecebida(resultSet.getInt("QuantidadeRecebida"));
                p.setEstoqueAtual(resultSet.getInt("EstoqueAtual"));
                
                TipoCategoriaProduto tipoCategoria = new TipoCategoriaProduto();
                tipoCategoria.setId(resultSet.getInt("idTipoCategoriaProduto"));
                tipoCategoria.setTipoCategoria(resultSet.getString("TipoCategoria"));
                
                p.setTipoCategoria(tipoCategoria);
                
                MarcaProduto marca = new MarcaProduto();
                marca.setId(resultSet.getInt("idMarca"));
                marca.setMarca(resultSet.getString("Marca"));
                
                p.setMarca(marca);
                
                GrupoProduto grupo = new GrupoProduto();
                grupo.setId(resultSet.getInt("idGrupo"));
                grupo.setGrupo(resultSet.getString("Grupo"));
                
                p.setGrupo(grupo);
                
                Fornecedor f = new Fornecedor();
                f.setId(resultSet.getInt("IdFornecedor"));
                
                p.getFornecedor();
                
                produto.add(p);
            }
               conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
}
        return produto;
}
 public List<Produto> listarProdutoporCodigo(int Codigo){
        
      List<Produto> produto = new ArrayList <>();
        try {
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            
            String sql = "select * \n" +
                         "from produto \n" +
                         "join fornecedor on produto.IdFornecedor = fornecedor.idFornecedor\n" +
                         "join tipocategoriaproduto on produto.IdTipoCategoriaProduto = tipocategoriaproduto.idTipoCategoriaProduto\n" +
                         "join marca on marca.idMarca = produto.IdMarca\n" +
                         "join grupo on grupo.idGrupo = produto.IdMarca\n" +
                         "where produto.DescricaoProduto like '%?%'\n" +
                         "order by produto.idProduto";
            ps = conn.prepareStatement(sql); 
            ps.setString(1, "%"+Codigo+"%");
            resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                
                Produto p = new Produto();
                p.setIdProduto(resultSet.getInt("idProduto"));
                p.setCodigo(resultSet.getInt("CodigoProduto"));
                p.setCodigoBarra(resultSet.getInt("CodigoBarra"));
                p.setStatusProduto(resultSet.getBoolean("StatusProduto"));
                p.setDescricaoProduto(resultSet.getString("DescricaoProduto"));
                p.setPeso(resultSet.getDouble("Peso"));
                p.setPrecoCusto(resultSet.getDouble("PrecoCusto"));
                p.setMargemLucro(resultSet.getDouble("MargemLucro"));
                p.setQtdRecebida(resultSet.getInt("QuantidadeRecebida"));
                p.setEstoqueAtual(resultSet.getInt("EstoqueAtual"));
                
                TipoCategoriaProduto tipoCategoria = new TipoCategoriaProduto();
                tipoCategoria.setId(resultSet.getInt("idTipoCategoriaProduto"));
                tipoCategoria.setTipoCategoria(resultSet.getString("TipoCategoria"));
                
                p.setTipoCategoria(tipoCategoria);
                
                MarcaProduto marca = new MarcaProduto();
                marca.setId(resultSet.getInt("idMarca"));
                marca.setMarca(resultSet.getString("Marca"));
                
                p.setMarca(marca);
                
                GrupoProduto grupo = new GrupoProduto();
                grupo.setId(resultSet.getInt("idGrupo"));
                grupo.setGrupo(resultSet.getString("Grupo"));
                
                p.setGrupo(grupo);
                
                Fornecedor f = new Fornecedor();
                f.setId(resultSet.getInt("IdFornecedor"));
                
                p.getFornecedor();
                
                produto.add(p);
            }   conn.close();
            
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return null;
        
 }
}

