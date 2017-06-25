/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import Classes.ItemVenda;
import Classes.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
}
