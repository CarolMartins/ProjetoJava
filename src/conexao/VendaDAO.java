/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import Classes.Cliente;
import Classes.Funcionario;
import Classes.ItemVenda;
import Classes.Produto;
import Classes.TipoPagamento;
import Classes.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author connect
 */
public class VendaDAO {
    ConnectionFactory factory = new ConnectionFactory();
    Connection conn = factory.getConnection();
    
    public void salvar(Venda venda){
        try {
            //Insere a venda
            PreparedStatement ps = conn.prepareStatement("insert into venda (TipoPedido, ValorTotalVenda, idCliente, IdFuncionario, IdPagamento, DataVenda)" 
                                     + "values (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, venda.getTipoPedido());
            ps.setDouble(2, venda.getValorTotalVenda());
            ps.setInt(3, venda.getCliente().getIdCliente());
            ps.setInt(4, venda.getFuncionario().getId());
            ps.setInt(5, venda.getPagamento().getIdPagamento());
            ps.setDate(6, new java.sql.Date(venda.getDataVenda().getTime()));
            ps.executeUpdate();
            ResultSet rsCodigo = ps.getGeneratedKeys();
            if (rsCodigo.next())
                venda.setNumeroPedido(rsCodigo.getInt(1));
            
            //Inserir os itens da venda no banco
            List<ItemVenda> itens = venda.getItensVendas();
            for(int i=0; i<itens.size();i++){
                ItemVenda item = itens.get(i);
                ps = conn.prepareStatement("insert into itemvenda (idproduto, idvenda, quantidade, valorunitario, total)" 
                                         + "values (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1, item.getProduto().getIdProduto());
                ps.setInt(2, venda.getNumeroPedido());
                ps.setInt(3, item.getQuantidade());
                ps.setDouble(4, item.getValorUnitario());
                ps.setDouble(5, item.getTotal());
                ps.executeUpdate();
                
                //Altera estoque produto
                ps = conn.prepareStatement("update produto set EstoqueAtual = EstoqueAtual - ? where idProduto = ?");
                ps.setInt(1, item.getQuantidade());
                ps.setInt(2, item.getProduto().getIdProduto());
                ps.executeUpdate();
            }
                
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }      
    }
    
    public double retornaTotalVendaPorFuncionario(int idFuncionario){
        double total = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "select round(sum(ValorTotalVenda),2) as total\n" +
                            "from venda\n" +
                            "where idFuncionario = ?;");
            ps.setInt(1, idFuncionario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                total = rs.getDouble("total");
            }

        } catch (SQLException ex) {            
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return total;
    }
    
    public List<Venda> listar(Date dataInicio, Date dataFim){
        List<Venda> vendas = new ArrayList <>();
        try {
            PreparedStatement ps = null;
            ResultSet rsCodigo = null;
            
            String sql = "select venda.idVenda, venda.DataVenda, pessoa.Nome, pessoa.Cpf, round(venda.ValorTotalVenda,2) as valorTotal\n" +
                        "from venda\n" +
                        "join cliente on cliente.idCliente = venda.idCliente\n" +
                        "join pessoa on cliente.idCliente = pessoa.idPessoa\n" +
                        "where DataVenda between ? and ?\n" +
                        "order by venda.DataVenda\n" +
                        "; \n" +
                        "      ";
            ps = conn.prepareStatement(sql); 
            ps.setDate(1, new java.sql.Date(dataInicio.getTime()));
            ps.setDate(2, new java.sql.Date(dataFim.getTime()));
            rsCodigo = ps.executeQuery();
            
            while(rsCodigo.next()){
                
                Venda venda = new Venda();
                venda.setNumeroPedido(rsCodigo.getInt("idVenda"));
                venda.setDataVenda(rsCodigo.getDate("DataVenda"));
                
                Cliente cliente = new Cliente();
                cliente.setNome(rsCodigo.getString("Nome"));
                cliente.setCpf(rsCodigo.getString("Cpf"));
                venda.setCliente(cliente);
                venda.setValorTotalVenda(rsCodigo.getDouble("valorTotal"));
                
               vendas.add(venda);   
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return vendas;
    }
    
    public Venda buscarPorId(Integer id){
            Connection conn = factory.getConnection();
            Venda venda = null;
            try {
                PreparedStatement ps = null;
                ResultSet resultSet = null;

                String sql = "select v.idVenda as VendaId, v.DataVenda as VendaData, v.TipoPedido as VendaTipo, round(v.ValorTotalVenda,2) as VendaTotal,/*Venda*/\n" +
                             "       pcli.idPessoa as ClienteId, pcli.Nome as ClienteNome, pcli.Cpf as ClienteCpf,  /*Cliente*/\n" +
                             "       f.idFuncionario as FuncionarioId, pf.Nome as FuncionarioNome,  /**Funcionario*/\n" +
                             "       p.idProduto as ProdutoId, p.DescricaoProduto as ProdutoDescricao, i.quantidade as ProdutoQTD, /*Produtos*/\n" +
                             "	   round(p.PrecoVenda,2) as precoVenda, round(i.total,2) as total, p.CodigoBarra\n" +
                             "from venda as v\n" +
                             "join cliente as cli on cli.idCliente = v.idCliente\n" +
                             "join pessoa as pcli on cli.idCliente = pcli.idPessoa\n" +
                             
                             "join funcionario as f on f.idFuncionario = v.IdFuncionario\n" +
                             "join pessoa as pf on pf.idPessoa = f.idFuncionario\n" +
                             
                             "join itemvenda as i on i.idvenda = v.idVenda\n" +
                             "join produto as p on p.idProduto = i.idproduto\n" +
                        
                             "where v.idVenda = ?\n"+
                        
                             "order by v.DataVenda; ";
                ps = conn.prepareStatement(sql); 
                ps.setInt(1, id);
                resultSet = ps.executeQuery();

                if(resultSet.next()){
                    venda = new Venda();
                    
                    venda.setNumeroPedido(resultSet.getInt("VendaId"));
                    venda.setDataVenda(resultSet.getDate("VendaData"));
                    venda.setTipoPedido(resultSet.getString("VendaTipo"));

                    Funcionario vendedor = new Funcionario();
                    vendedor.setId(resultSet.getInt("FuncionarioId"));
                    vendedor.setNome(resultSet.getString("FuncionarioNome"));
                    
                    venda.setFuncionario(vendedor);
                    
                    Cliente cliente = new Cliente();
                    cliente.setNome(resultSet.getString("ClienteNome"));
                    cliente.setCpf(resultSet.getString("ClienteCpf"));
                    cliente.setId(resultSet.getInt("ClienteId"));
                    
                    venda.setCliente(cliente);
                    
                    venda.setValorTotalVenda(resultSet.getDouble("VendaTotal"));
                    
                    List<ItemVenda> listaItemVenda = new ArrayList<>();
                    do{
                        ItemVenda itemVenda = new ItemVenda();
                        itemVenda.setQuantidade(resultSet.getInt("ProdutoQTD"));
                        itemVenda.setTotal(resultSet.getDouble("total"));
                        itemVenda.setValorUnitario(resultSet.getFloat("precoVenda"));
                        
                        Produto produto = new Produto();
                        produto.setIdProduto(resultSet.getInt("ProdutoId"));
                        produto.setCodigoBarra(resultSet.getString("CodigoBarra"));
                        produto.setDescricaoProduto(resultSet.getString("ProdutoDescricao"));
                        
                        itemVenda.setProduto(produto);
                        
                        listaItemVenda.add(itemVenda);
                    }while (resultSet.next());
                    venda.setItensVendas(listaItemVenda);
                }
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException ("Erro SQL: " + ex);
            }
            return venda;
        }     
}
