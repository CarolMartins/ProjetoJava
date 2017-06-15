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
public class Funcionario extends Pessoa{
    
    private Cargo cargo;
    private Double meta; 
    private String usuario;
    private String senha;
    private Boolean situacaoLogin;

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Double getMeta() {
        return meta;
    }

    public void setMeta(Double meta) {
        this.meta = meta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getSituacaoLogin() {
        return situacaoLogin;
    }

    public void setSituacaoLogin(Boolean situacaoLogin) {
        this.situacaoLogin = situacaoLogin;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    
    
}
