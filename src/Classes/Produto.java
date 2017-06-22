/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Carol
 */
public class Produto {
    
    private int IdProduto;
    private String codigoBarra;
    private Boolean statusProduto;
    private String descricaoProduto;
    private TipoCategoriaProduto tipoCategoria;
    private MarcaProduto marca;
    private GrupoProduto grupo;
    private Fornecedor fornecedor;
    private double peso;
    private double precoCusto;
    private double margemLucro;
    private double precoVenda;
    private Icms icms;
    private int qtdRecebida;
    private int estoqueAtual;

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
    public Boolean getStatusProduto() {
        return statusProduto;
    }

    public void setStatusProduto(Boolean statusProduto) {
        this.statusProduto = statusProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public TipoCategoriaProduto getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(TipoCategoriaProduto tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public MarcaProduto getMarca() {
        return marca;
    }

    public void setMarca(MarcaProduto marca) {
        this.marca = marca;
    }

    public GrupoProduto getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoProduto grupo) {
        this.grupo = grupo;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(double margemLucro) {
        this.margemLucro = margemLucro;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Icms getIcms() {
        return icms;
    }

    public void setIcms(Icms icms) {
        this.icms = icms;
    }

    public int getQtdRecebida() {
        return qtdRecebida;
    }

    public void setQtdRecebida(int qtdRecebida) {
        this.qtdRecebida = qtdRecebida;
    }

    public int getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(int estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }

    @Override
    public String toString() {
        return this.descricaoProduto;
    }

    public int getIdProduto() {
        return IdProduto;
    }

    public void setIdProduto(int Id) {
        this.IdProduto = Id;
    }
   
    
    
    
    
}
