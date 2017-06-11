
package conexao;

import Classes.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carolina
 */
public class FuncionarioDAO {
  
   ConnectionFactory factory = new ConnectionFactory();
   Connection conn = factory.getConnection();
   
   
    public boolean logar(String usuario, String senha){
        try {
            
            
            //Cria um comando sql para enviar para o banco de dados
            PreparedStatement ps = conn.prepareStatement("select * from " +
                                                         " funcionario " +
                                                         " where usuario = ? and " +
                                                         "       senha = ?");
            
            //Substitui variaveis pelos valores informados pelo usuário
            ps.setString(1, usuario);
            ps.setString(2, senha);
            //Enviar comando para o banco de dados e retorna o resultado (ResultSet)
            ResultSet rs = ps.executeQuery();
            //Verifica se foi retornado algum resultado,
            //Se sim, então o usuário existe, caso contrário, usuário não existe
            boolean resp = rs.next();
            //Fecha Conexão
            conn.close();
            
            return resp;
        } catch (SQLException ex) {
            throw new RuntimeException("Problemas ao buscar usuário!");
        }
    }
    
    
    public void salvar(Funcionario f){
       try {
           PreparedStatement ps = conn.prepareStatement ("insert into pessoa (Nome, DataNascimento, Sexo, Cpf, Rg,"
                   + "TelefoneResidencial, TelefoneCelular, Email, Cep, idTipoLogradouro"
                   + "Logradouro, Numero, Bairro, Complemento, Observacao, IdCidade"
                   + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
           ps.setString(1, f.getNome());
           ps.setDate(2, (java.sql.Date) f.getDatanascimento());
           ps.setString(3, f.getSexo());
           ps.setString(4, f.getCpf());
           ps.setString(5, f.getRg());
           ps.setString(6, f.getTelefoneresidencial());
           ps.setString(7, f.getTelefoneCelular());
           ps.setString(8, f.getEmail());
           ps.setString(9, f.getCep());
           ps.setInt(10,f.getTipoLogradouro().getId());
           ps.setString(11, f.getLogradouro());
           ps.setInt(12, f.getNumero());
           ps.setString(13, f.getBairro());
           ps.setString(14, f.getComplemento());
           ps.setString(15, f.getObservacoes());
           ps.setInt(16, f.getCidade().getId());
           ps.executeUpdate();
           
           ResultSet rs = ps.getGeneratedKeys();
           if(rs.next())
               f.setId(rs.getInt(1));
           
           ps = conn.prepareStatement("insert into funcionario (meta, usuario, senha, situacaoLogin, idCargo)" + 
                                      "values (?, ?, ?, ?, ?)");
           ps.setDouble (1, f.getMeta());
           ps.setString(2, f.getUsuario());
           ps.setString(3, f.getSenha());
           ps.setBoolean(4, f.getSituacaoLogin());
           ps.setInt(5, f.getCargo().getId());
           ps.executeUpdate();
           
           conn.close();
           
       } catch (SQLException ex) {
           Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
                
    }
}
