
package conexao;

import Classes.Cargo;
import Classes.Cidade;
import Classes.Estado;
import Classes.Funcionario;
import Classes.TipoLogradouro;
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
 * @author carolina
 */
public class FuncionarioDAO {
  
   ConnectionFactory factory = new ConnectionFactory();
   
   
   
    public boolean logar(String usuario, String senha){
        Connection conn = factory.getConnection();
        try {
            
            
            //Cria um comando sql para enviar para o banco de dados
            PreparedStatement ps = conn.prepareStatement("select * from " +
                                                         " funcionario " +
                                                         " where usuario = ? and " +
                                                         "       senha = ? and situacaoLogin = 1");
            
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
       Connection conn = factory.getConnection();
       try {
           PreparedStatement ps = conn.prepareStatement ("insert into pessoa (Nome, DataNascimento, Sexo, Cpf, Rg,"
                   + "TelefoneResidencial, TelefoneCelular, Email, Cep, idTipoLogradouro,"
                   + "Logradouro, Numero, Bairro, Complemento, Observacao, IdCidade)"
                   + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
           ps.setString(1, f.getNome());
           ps.setDate(2, new java.sql.Date(f.getDatanascimento().getTime()));
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
           
           ps = conn.prepareStatement("insert into funcionario (idFuncionario, meta, usuario, senha, situacaoLogin, idCargo)" + 
                                      "values (?, ?, ?, ?, ?, ?)");
           ps.setInt(1, f.getId());
           ps.setDouble (2, f.getMeta());
           ps.setString(3, f.getUsuario());
           ps.setString(4, f.getSenha());
           ps.setBoolean(5, f.getSituacaoLogin());
           ps.setInt(6, f.getCargo().getId());
           ps.executeUpdate();
           
           conn.close();
           
       } catch (SQLException ex) {
           Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
       }          
    }
    
    public void editar(Funcionario f){
        Connection conn = factory.getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE pessoa (Nome = ?, DataNascimento = ?, Sexo = ?, Cpf = ?, Rg = ?,"
                   + "TelefoneResidencial = ?, TelefoneCelular = ?, Email = ?, Cep = ?, idTipoLogradouro = ?,"
                   + "Logradouro = ?, Numero = ?, Bairro = ?, Complemento = ?, Observacao = ?, IdCidade = ? where idPessoa = ?)");
            
            ps.setString(1, f.getNome());
            ps.setDate(2, new java.sql.Date(f.getDatanascimento().getTime()));
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
            ps.setInt(17, f.getId());
            ps.executeUpdate();
            
            ps = conn.prepareStatement("Update funcionario (meta = ?, usuario = ?, senha = ?, situacaoLogin = ?, " +
                                             " idCargo = ? where idFuncionario = ?)");                    
            
            ps.setDouble (1, f.getMeta());
            ps.setString(2, f.getUsuario());
            ps.setString(3, f.getSenha());
            ps.setBoolean(4, f.getSituacaoLogin());
            ps.setInt(5, f.getCargo().getId());
            ps.setInt(6, f.getId());
            ps.executeUpdate();
            conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar " + ex);
              }           
    }
    
    public List<Funcionario> listarFuncionario(){
        Connection conn = factory.getConnection();
        List<Funcionario> funcionarios = new ArrayList <>();
        try {
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            
            String sql = "select *, \n" +
                         "       tipologradouro.descricao as descricaoTipoLogradouro,\n" +
                         "       estado.Sigla as siglaEstado,\n" +
                         "       cargo.descricao as descricaoCargo\n" +
                         "from pessoa\n" +
                         "left join funcionario on pessoa.idPessoa = funcionario.idFuncionario\n" +
                         "left join tipologradouro on pessoa.idTipoLogradouro = tipologradouro.idTipoLogradouro\n" +
                         "left join cargo on cargo.idCargo = funcionario.idCargo\n" +
                         "left join cidade on cidade.idCidade = pessoa.IdCidade\n" +
                         "left join estado on estado.idEstado = cidade.IdEstado\n" +
                         "order by pessoa.nome asc";
            ps = conn.prepareStatement(sql); 
            resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                
                Funcionario f = new Funcionario();
                f.setId(resultSet.getInt("idFuncionario"));
                f.setNome(resultSet.getString("nome"));
                f.setDatanascimento(resultSet.getDate("dataNascimento"));
                f.setSexo(resultSet.getString("sexo"));
                f.setCpf(resultSet.getString("cpf"));
                f.setRg(resultSet.getString("rg"));
                f.setTelefoneresidencial(resultSet.getString("Telefoneresidencial"));
                f.setTelefoneCelular(resultSet.getString("TelefoneCelular"));
                f.setEmail(resultSet.getString("email"));
                f.setCep(resultSet.getString("cep"));
                
                TipoLogradouro tipoLogradouro = new TipoLogradouro();
                tipoLogradouro.setId(resultSet.getInt("idTipoLogradouro"));
                tipoLogradouro.setNome(resultSet.getString("descricaoTipoLogradouro"));
                
                f.setTipoLogradouro(tipoLogradouro);
                
                f.setLogradouro(resultSet.getString("logradouro"));
                f.setNumero(resultSet.getInt("numero"));
                f.setBairro(resultSet.getString("bairro"));
                f.setComplemento(resultSet.getString("complemento"));
                
                Estado estado = new Estado();
                estado.setId(resultSet.getInt("idEstado"));
                estado.setNomeEstado("nomeEstado");
                estado.setSigla("siglaEstado");
                
                Cidade cidade = new Cidade();
                cidade.setId(resultSet.getInt("idCidade"));
                cidade.setEstado(estado);
                cidade.setNomeCidade(resultSet.getString("nomeCidade"));
                
                f.setCidade(cidade);
                f.setMeta(resultSet.getDouble("meta"));
                f.setUsuario(resultSet.getString("usuario"));
                f.setSenha(resultSet.getString("senha"));
                
                Cargo cargo = new Cargo();
                cargo.setComissao(resultSet.getDouble("comissao"));
                cargo.setDescricao(resultSet.getString("descricaoCargo"));
                cargo.setSalario(resultSet.getDouble("salario"));
                cargo.setId(resultSet.getInt("idCargo"));
                
                f.setCargo(cargo);
                
                funcionarios.add(f);
                
            }
            conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return funcionarios;
    }
}
