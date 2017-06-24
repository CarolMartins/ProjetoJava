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
           PreparedStatement ps = conn.prepareStatement ("insert into produto(CodigoBarra, StatusProduto,"
                                                         + "DescricaoProduto, Peso, PrecoCusto, MargemLucro, PrecoVenda,"
                                                         + "QuantidadeRecebida, EstoqueAtual, IdFornecedor, IdTipoCategoriaProduto,"
                                                         + " IdMarca, IdGrupo)" 
                                                         + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
           ps.setString(1, p.getCodigoBarra());
           ps.setBoolean(2, p.getStatusProduto());
           ps.setString(3, p.getDescricaoProduto());
           ps.setDouble(4, p.getPeso());
           ps.setDouble(5,p.getPrecoCusto());
           ps.setDouble(6,p.getMargemLucro());
           ps.setDouble(7, p.getPrecoVenda());
           ps.setInt(8, p.getQtdRecebida());
           ps.setInt(9, p.getEstoqueAtual());
           ps.setInt(10, p.getFornecedor().getId());
           ps.setInt(11, p.getTipoCategoria().getId());
           ps.setInt(12, p.getMarca().getId());
           ps.setInt(13, p.getGrupo().getId());
           
           ps.executeUpdate();
           
           ResultSet rs = ps.getGeneratedKeys();
           if(rs.next())
               p.setIdProduto(rs.getInt(1));
           
          conn.close();
           
    }catch (SQLException ex) {
           Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
       }   
}
    
    public void editar(Produto p){
        ConnectionFactory factory = new ConnectionFactory();
        Connection conn = factory.getConnection();        
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE produto set CodigoBarra = ?, StatusProduto= ?,"
                                                         + "DescricaoProduto = ?, Peso = ?, PrecoCusto = ?, MargemLucro = ?, PrecoVenda = ?,"
                                                         + "QuantidadeRecebida = ?, EstoqueAtual = ?, IdFornecedor = ?, IdTipoCategoriaProduto = ?,"
                                                         + " IdMarca = ?, IdGrupo = ?, QuantidadeRecebida = ? where idProduto  = ?");
            
           ps.setString(1, p.getCodigoBarra());
           ps.setBoolean(2, p.getStatusProduto());
           ps.setString(3, p.getDescricaoProduto());
           ps.setDouble(4, p.getPeso());
           ps.setDouble(5,p.getPrecoCusto());
           ps.setDouble(6,p.getMargemLucro());
           ps.setDouble(7, p.getPrecoVenda());
           ps.setInt(8, p.getQtdRecebida());
           ps.setInt(9, p.getEstoqueAtual());
           ps.setInt(10, p.getFornecedor().getId());
           ps.setInt(11, p.getTipoCategoria().getId());
           ps.setInt(12, p.getMarca().getId());
           ps.setInt(13, p.getGrupo().getId());
           ps.setInt(14, p.getQtdRecebida());
           ps.setInt(15, p.getIdProduto());
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
                         "join grupo on grupo.idGrupo = produto.idGrupo\n" +
                         "where produto.DescricaoProduto like ?\n" +
                         "order by produto.DescricaoProduto";
            ps = conn.prepareStatement(sql); 
            ps.setString(1, "%"+descricaoProduto+"%");
            resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                
                Produto p = new Produto();
                p.setIdProduto(resultSet.getInt("idProduto"));
                p.setCodigoBarra(resultSet.getString("CodigoBarra"));
                p.setStatusProduto(resultSet.getBoolean("StatusProduto"));
                p.setDescricaoProduto(resultSet.getString("DescricaoProduto"));
                p.setPeso(resultSet.getDouble("Peso"));
                p.setPrecoCusto(resultSet.getDouble("PrecoCusto"));
                p.setMargemLucro(resultSet.getDouble("MargemLucro"));
                p.setQtdRecebida(resultSet.getInt("QuantidadeRecebida"));
                p.setEstoqueAtual(resultSet.getInt("EstoqueAtual"));
                p.setPrecoVenda(resultSet.getFloat("precoVenda"));
                
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
    public List<Produto> listarProdutos(){
        
      List<Produto> produto = new ArrayList <>();
        
        try {
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            
            String sql = "select * \n" +
                         "from produto \n" +
                         "join fornecedor on produto.IdFornecedor = fornecedor.idFornecedor\n" +
                         "join tipocategoriaproduto on produto.IdTipoCategoriaProduto = tipocategoriaproduto.idTipoCategoriaProduto\n" +
                         "join marca on marca.idMarca = produto.IdMarca\n" +
                         "join grupo on grupo.idGrupo = produto.idGrupo\n" +
                         "order by produto.DescricaoProduto";
            ps = conn.prepareStatement(sql); 
            resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                
                Produto p = new Produto();
                p.setIdProduto(resultSet.getInt("idProduto"));
                p.setCodigoBarra(resultSet.getString("CodigoBarra"));
                p.setStatusProduto(resultSet.getBoolean("StatusProduto"));
                p.setDescricaoProduto(resultSet.getString("DescricaoProduto"));
                p.setPeso(resultSet.getDouble("Peso"));
                p.setPrecoCusto(resultSet.getDouble("PrecoCusto"));
                p.setMargemLucro(resultSet.getDouble("MargemLucro"));
                p.setQtdRecebida(resultSet.getInt("QuantidadeRecebida"));
                p.setEstoqueAtual(resultSet.getInt("EstoqueAtual"));
                p.setPrecoVenda(resultSet.getFloat("precoVenda"));
                
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
                
                p.setFornecedor(f);
                produto.add(p);
            }
               conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
}
        return produto;
}
    public int  buscarCodigo(String descricaoProduto){
        int id = 0;
      //List<Produto> produto = new ArrayList <>();
        
        try {
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            
            String sql = "select idProduto \n" +
                         "from produto \n" +
                         //"join fornecedor on produto.IdFornecedor = fornecedor.idFornecedor\n" +
                         //"join tipocategoriaproduto on produto.IdTipoCategoriaProduto = tipocategoriaproduto.idTipoCategoriaProduto\n" +
                         //"join marca on marca.idMarca = produto.IdMarca\n" +
                         //"join grupo on grupo.idGrupo = produto.idGrupo\n" +
                         "where produto.DescricaoProduto = ?\n" +
                         "order by produto.DescricaoProduto";
            ps = conn.prepareStatement(sql); 
            ps.setString(1, "%"+descricaoProduto+"%");
            resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                
                /*Produto p = new Produto();
                p.setIdProduto(resultSet.getInt("idProduto"));
               
                p.setDescricaoProduto(resultSet.getString("DescricaoProduto"));
                
                
                produto.add(p);*/
                id = resultSet.getInt("idProduto");
                System.out.println(id);
            }
               conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
}
        return id;
}
    
 public List<Produto> listarProdutoporCodigo(int Codigo){
        
      List<Produto> produtos = new ArrayList <>();
        try {
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            
            String sql = "select * \n" +
                         "from produto \n" +
                         "join fornecedor on produto.IdFornecedor = fornecedor.idFornecedor\n" +
                         "join tipocategoriaproduto on produto.IdTipoCategoriaProduto = tipocategoriaproduto.idTipoCategoriaProduto\n" +
                         "join marca on marca.idMarca = produto.IdMarca\n" +
                         "join grupo on grupo.idGrupo = produto.idGrupo\n" +
                         "where produto.idProduto = ?\n" +
                         "order by produto.idProduto";
            ps = conn.prepareStatement(sql); 
            ps.setString(1, Codigo+"");
            resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                
                Produto p = new Produto();
                p.setIdProduto(resultSet.getInt("idProduto"));
                p.setCodigoBarra(resultSet.getString("CodigoBarra"));
                p.setStatusProduto(resultSet.getBoolean("StatusProduto"));
                p.setDescricaoProduto(resultSet.getString("DescricaoProduto"));
                p.setPeso(resultSet.getDouble("Peso"));
                p.setPrecoCusto(resultSet.getDouble("PrecoCusto"));
                p.setMargemLucro(resultSet.getDouble("MargemLucro"));
                p.setQtdRecebida(resultSet.getInt("QuantidadeRecebida"));
                p.setEstoqueAtual(resultSet.getInt("EstoqueAtual"));
                p.setPrecoVenda(resultSet.getFloat("precovenda"));
                
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
                
                produtos.add(p);
            }   conn.close();
            
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return produtos;
        
 }
 
 
    public Produto buscarPorId(int Codigo){
        
      Produto p = null;
        try {
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            
            String sql = "select * \n" +
                         "from produto \n" +
                         "join fornecedor on produto.IdFornecedor = fornecedor.idFornecedor\n" +
                         "join tipocategoriaproduto on produto.IdTipoCategoriaProduto = tipocategoriaproduto.idTipoCategoriaProduto\n" +
                         "join marca on marca.idMarca = produto.IdMarca\n" +
                         "join grupo on grupo.idGrupo = produto.idGrupo\n" +
                         "where produto.idProduto = ?\n" +
                         "order by produto.idProduto";
            ps = conn.prepareStatement(sql); 
            ps.setString(1, Codigo+"");
            resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                
                p = new Produto();
                p.setIdProduto(resultSet.getInt("idProduto"));
                p.setCodigoBarra(resultSet.getString("CodigoBarra"));
                p.setStatusProduto(resultSet.getBoolean("StatusProduto"));
                p.setDescricaoProduto(resultSet.getString("DescricaoProduto"));
                p.setPeso(resultSet.getDouble("Peso"));
                p.setPrecoCusto(resultSet.getDouble("PrecoCusto"));
                p.setMargemLucro(resultSet.getDouble("MargemLucro"));
                p.setQtdRecebida(resultSet.getInt("QuantidadeRecebida"));
                p.setEstoqueAtual(resultSet.getInt("EstoqueAtual"));
                p.setPrecoVenda(resultSet.getFloat("precovenda"));
                
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
                f.setNomeFantasia(resultSet.getString("nomeFantasia"));
                
                p.setFornecedor(f);
                
            }   conn.close();
            
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return p;
        
    }
    
   public Produto buscarPorCodigoBarras(String CodigoBarra){
        
      Produto p = null;
        try {
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            
            String sql = "select * \n" +
                         "from produto \n" +
                         "join fornecedor on produto.IdFornecedor = fornecedor.idFornecedor\n" +
                         "join tipocategoriaproduto on produto.IdTipoCategoriaProduto = tipocategoriaproduto.idTipoCategoriaProduto\n" +
                         "join marca on marca.idMarca = produto.IdMarca\n" +
                         "join grupo on grupo.idGrupo = produto.idGrupo\n" +
                         "where produto.CodigoBarra = ?\n" +
                         "order by produto.idProduto";
            ps = conn.prepareStatement(sql); 
            ps.setString(1, CodigoBarra+"");
            resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                
                p = new Produto();
                p.setIdProduto(resultSet.getInt("idProduto"));
                p.setCodigoBarra(resultSet.getString("CodigoBarra"));
                p.setStatusProduto(resultSet.getBoolean("StatusProduto"));
                p.setDescricaoProduto(resultSet.getString("DescricaoProduto"));
                p.setPeso(resultSet.getDouble("Peso"));
                p.setPrecoCusto(resultSet.getDouble("PrecoCusto"));
                p.setMargemLucro(resultSet.getDouble("MargemLucro"));
                p.setQtdRecebida(resultSet.getInt("QuantidadeRecebida"));
                p.setEstoqueAtual(resultSet.getInt("EstoqueAtual"));
                p.setPrecoVenda(resultSet.getFloat("precovenda"));
                
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
                f.setNomeFantasia(resultSet.getString("nomeFantasia"));
                
                p.setFornecedor(f);
                
            }   conn.close();
            
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return p;
        
    }    
    
    public void excluir(Produto p){
        Connection conn = factory.getConnection();
        try {
            String sql = "delete from produto where idProduto = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, p.getIdProduto());
            ps.executeUpdate();
                       
            conn.close();
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao deletar " + ex);
            }      
        }
    
}

