/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Carol
 */
public class Venda {
    
    private int numeroPedido;
    private String tipoPedido;
    private Cliente cliente;
    private Produto produto;
    private int quantidade;
    private double valorTotalVenda;
    private Produto precoVenda;
    private double valorTotalProduto;
    private Date DataVenda;
    private Funcionario funcionario;
    private Pagamento pagamento;
    private List<ItemVenda> itensVendas;

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValortotalVenda() {
        return valorTotalVenda;
    }

    public void setValortotalVenda(double valortotalVenda) {
        this.valorTotalVenda = valortotalVenda;
    }

    public Produto getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Produto precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getValorTotalProduto() {
        return valorTotalProduto;
    }

    public void setValorTotalProduto(double valorTotalProduto) {
        this.valorTotalProduto = valorTotalProduto;
    }

    public double getValorTotalVenda() {
        return valorTotalVenda;
    }

    public void setValorTotalVenda(double valorTotalVenda) {
        this.valorTotalVenda = valorTotalVenda;
    }

    public Date getDataVenda() {
        return DataVenda;
    }

    public void setDataVenda(Date DataVenda) {
        this.DataVenda = DataVenda;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public List<ItemVenda> getItensVendas() {
        return itensVendas;
    }

    public void setItensVendas(List<ItemVenda> itensVendas) {
        this.itensVendas = itensVendas;
    }
}
