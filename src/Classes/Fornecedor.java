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
public class Fornecedor {
    
    private int id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String ie;
    private String telefoneContato1;
    private String telefoneContato2;
    private String email;
    private TipoLogradouro tipoLogradouro;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private Cidade cidade;
    private Estado estado;
    private String observacoes;
    private Boolean situacaoFornecedor;
    private String cep;
    private Date DataCadastro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getTelefoneContato1() {
        return telefoneContato1;
    }

    public void setTelefoneContato1(String telefoneContato1) {
        this.telefoneContato1 = telefoneContato1;
    }

    public String getTelefoneContato2() {
        return telefoneContato2;
    }

    public void setTelefoneContato2(String telefoneContato2) {
        this.telefoneContato2 = telefoneContato2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Boolean getSituacaoFornecedor() {
        return situacaoFornecedor;
    }

    public void setSituacaoFornecedor(Boolean situacaoFornecedor) {
        this.situacaoFornecedor = situacaoFornecedor;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }
    
    

    @Override
    public String toString() {
        return this.razaoSocial;
    }
    
    
}
