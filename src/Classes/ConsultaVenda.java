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
public class ConsultaVenda {
    
    private Funcionario id;
    private Funcionario nome; 
    private Venda valorTotalVenda;
    private Funcionario meta;

    public Funcionario getId() {
        return id;
    }

    public void setId(Funcionario id) {
        this.id = id;
    }

    public Funcionario getNome() {
        return nome;
    }

    public void setNome(Funcionario nome) {
        this.nome = nome;
    }

    public Venda getValorTotalVenda() {
        return valorTotalVenda;
    }

    public void setValorTotalVenda(Venda valorTotalVenda) {
        this.valorTotalVenda = valorTotalVenda;
    }

    public Funcionario getMeta() {
        return meta;
    }

    public void setMeta(Funcionario meta) {
        this.meta = meta;
    }
    
    
   
}
