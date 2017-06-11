/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author Carol
 */
public class Venda {
    
    private int numeroPedido;
    private Boolean tipoPedido;
    private Cliente cliente;
    private String codigoBarra;
    private Produto produto;
    private int quantidade;
    private double valorTotalVenda;
    private Produto precoVenda;
    private double valorTotalProduto;
    private Date DataVenda;
    private Funcionario funcionario;

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Boolean getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(Boolean tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
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

    
    
    
    
}
