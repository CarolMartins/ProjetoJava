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
public class Cliente extends Pessoa{
    
    private int idCliente;
    private Boolean situacaoCliente;

    public Boolean getSituacaoCliente() {
        return situacaoCliente;
    }

    public void setSituacaoCliente(Boolean situacaoCliente) {
        this.situacaoCliente = situacaoCliente;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
    
    
    
}
