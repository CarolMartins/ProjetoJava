
package conexao;

import Classes.Cargo;
import Classes.Cidade;
import Classes.Cliente;
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
public class ClienteDAO {
    ConnectionFactory factory = new ConnectionFactory();
    
    public void salvar(Cliente c){
       Connection conn = factory.getConnection();
       try {
           PreparedStatement ps = conn.prepareStatement ("insert into pessoa (Nome, DataNascimento, Sexo, Cpf, Rg,"
                   + "TelefoneResidencial, TelefoneCelular, Email, Cep, idTipoLogradouro,"
                   + "Logradouro, Numero, Bairro, Complemento, Observacao, IdCidade, DataCadastro)"
                   + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
           ps.setString(1, c.getNome());
           ps.setDate(2, new java.sql.Date(c.getDatanascimento().getTime()));
           ps.setString(3, c.getSexo());
           ps.setString(4, c.getCpf());
           ps.setString(5, c.getRg());
           ps.setString(6, c.getTelefoneresidencial());
           ps.setString(7, c.getTelefoneCelular());
           ps.setString(8, c.getEmail());
           ps.setString(9, c.getCep());
           ps.setInt(10,c.getTipoLogradouro().getId());
           ps.setString(11, c.getLogradouro());
           ps.setInt(12, c.getNumero());
           ps.setString(13, c.getBairro());
           ps.setString(14, c.getComplemento());
           ps.setString(15, c.getObservacoes());
           ps.setInt(16, c.getCidade().getId());
           ps.setDate(17, new java.sql.Date(c.getDataCadastro().getTime()));
           ps.executeUpdate();
           
           ResultSet rs = ps.getGeneratedKeys();
           if(rs.next())
               c.setId(rs.getInt(1));
           
           ps = conn.prepareStatement("insert into cliente (idCliente, situacaoCliente)" + 
                                      "values (?, ?)");
           ps.setInt(1, c.getId());
           ps.setBoolean(2, c.getSituacaoCliente());
           ps.executeUpdate();
           
           conn.close();
    
       } catch (SQLException ex) {
           Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
       }          
    }
    
    public void editar(Cliente c){
        Connection conn = factory.getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE pessoa set Nome = ?, DataNascimento = ?, Sexo = ?, Cpf = ?, Rg = ?,"
                   + "TelefoneResidencial = ?, TelefoneCelular = ?, Email = ?, Cep = ?, idTipoLogradouro = ?,"
                   + "Logradouro = ?, Numero = ?, Bairro = ?, Complemento = ?, Observacao = ?, IdCidade = ? where idPessoa = ?");
            
            ps.setString(1, c.getNome());
            ps.setDate(2, new java.sql.Date(c.getDatanascimento().getTime()));
            ps.setString(3, c.getSexo());
            ps.setString(4, c.getCpf());
            ps.setString(5, c.getRg());
            ps.setString(6, c.getTelefoneresidencial());
            ps.setString(7, c.getTelefoneCelular());
            ps.setString(8, c.getEmail());
            ps.setString(9, c.getCep());
            ps.setInt(10,c.getTipoLogradouro().getId());
            ps.setString(11, c.getLogradouro());
            ps.setInt(12, c.getNumero());
            ps.setString(13, c.getBairro());
            ps.setString(14, c.getComplemento());
            ps.setString(15, c.getObservacoes());
            ps.setInt(16, c.getCidade().getId());
            ps.setInt(17, c.getId());
            ps.executeUpdate();
            
            ps = conn.prepareStatement("Update cliente set situacaoCliente = ? where idCliente = ?");                    
            
            ps.setBoolean(1, c.getSituacaoCliente());
            ps.setInt(2, c.getId());
            ps.executeUpdate();
            conn.close();
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar " + ex);
              }           
    }
    
    public void excluir(Cliente c){
        Connection conn = factory.getConnection();
        try {
            String sql = "delete from cliente where idCliente = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, c.getId());
            ps.executeUpdate();
            
            sql = "delete from pessoa where idPessoa = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, c.getId());
            ps.executeUpdate();
            
            conn.close();
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao deletar " + ex);
            }      
        }
    
    public List<Cliente> listarClientePorNome(String nome){
        Connection conn = factory.getConnection();
        List<Cliente> clientes = new ArrayList <>();
        try {
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            
            String sql = "select *, \n" +
                         "       tipologradouro.descricao as descricaoTipoLogradouro,\n" +
                         "       estado.Sigla as siglaEstado\n" +
                         "from pessoa\n" +
                         "join cliente on pessoa.idPessoa = cliente.idCliente\n" +
                         "left join tipologradouro on pessoa.idTipoLogradouro = tipologradouro.idTipoLogradouro\n" +
                         "left join cidade on cidade.idCidade = pessoa.IdCidade\n" +
                         "left join estado on estado.idEstado = cidade.IdEstado\n" +
                         "where pessoa.nome like ?\n"+
                         "order by pessoa.nome asc";
            ps = conn.prepareStatement(sql); 
            ps.setString(1, "%"+nome+"%");
            resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                
                Cliente c = new Cliente();
                c.setIdCliente(resultSet.getInt("idCliente"));
                c.setId(resultSet.getInt("idCliente"));
                c.setNome(resultSet.getString("nome"));
                c.setDatanascimento(resultSet.getDate("dataNascimento"));
                c.setSexo(resultSet.getString("sexo"));
                c.setCpf(resultSet.getString("cpf"));
                c.setRg(resultSet.getString("rg"));
                c.setTelefoneresidencial(resultSet.getString("Telefoneresidencial"));
                c.setTelefoneCelular(resultSet.getString("TelefoneCelular"));
                c.setEmail(resultSet.getString("email"));
                c.setCep(resultSet.getString("cep"));
                
                TipoLogradouro tipoLogradouro = new TipoLogradouro();
                tipoLogradouro.setId(resultSet.getInt("idTipoLogradouro"));
                tipoLogradouro.setNome(resultSet.getString("descricaoTipoLogradouro"));
                
                c.setTipoLogradouro(tipoLogradouro);
                
                c.setLogradouro(resultSet.getString("logradouro"));
                c.setNumero(resultSet.getInt("numero"));
                c.setBairro(resultSet.getString("bairro"));
                c.setComplemento(resultSet.getString("complemento"));
                
                Estado estado = new Estado();
                estado.setId(resultSet.getInt("idEstado"));
                estado.setNomeEstado("nomeEstado");
                estado.setSigla("siglaEstado");
                
                Cidade cidade = new Cidade();
                cidade.setId(resultSet.getInt("idCidade"));
                cidade.setEstado(estado);
                cidade.setNomeCidade(resultSet.getString("nomeCidade"));
                c.setCidade(cidade);
              
                clientes.add(c);
                
            }
            conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return clientes;
    }
        public List<Cliente> listarClientePorCpf(String cpf){
            Connection conn = factory.getConnection();
            List<Cliente> clientes = new ArrayList <>();
            try {
                PreparedStatement ps = null;
                ResultSet resultSet = null;

                String sql = "select *, \n" +
                             "       tipologradouro.descricao as descricaoTipoLogradouro,\n" +
                             "       estado.Sigla as siglaEstado\n" +
                             "from pessoa\n" +
                             "join cliente on pessoa.idPessoa = cliente.idCliente\n" +
                             "left join tipologradouro on pessoa.idTipoLogradouro = tipologradouro.idTipoLogradouro\n" +
                             "left join cidade on cidade.idCidade = pessoa.IdCidade\n" +
                             "left join estado on estado.idEstado = cidade.IdEstado\n" +
                             "where pessoa.cpf like ?\n"+
                             "order by pessoa.nome asc";
                ps = conn.prepareStatement(sql); 
                ps.setString(1, "%"+cpf+"%");
                resultSet = ps.executeQuery();

                while(resultSet.next()){

                    Cliente c = new Cliente();
                    c.setIdCliente(resultSet.getInt("idCliente"));
                    c.setId(resultSet.getInt("idCliente"));
                    c.setNome(resultSet.getString("nome"));
                    c.setDatanascimento(resultSet.getDate("dataNascimento"));
                    c.setSexo(resultSet.getString("sexo"));
                    c.setCpf(resultSet.getString("cpf"));
                    c.setRg(resultSet.getString("rg"));
                    c.setTelefoneresidencial(resultSet.getString("Telefoneresidencial"));
                    c.setTelefoneCelular(resultSet.getString("TelefoneCelular"));
                    c.setEmail(resultSet.getString("email"));
                    c.setCep(resultSet.getString("cep"));

                    TipoLogradouro tipoLogradouro = new TipoLogradouro();
                    tipoLogradouro.setId(resultSet.getInt("idTipoLogradouro"));
                    tipoLogradouro.setNome(resultSet.getString("descricaoTipoLogradouro"));

                    c.setTipoLogradouro(tipoLogradouro);

                    c.setLogradouro(resultSet.getString("logradouro"));
                    c.setNumero(resultSet.getInt("numero"));
                    c.setBairro(resultSet.getString("bairro"));
                    c.setComplemento(resultSet.getString("complemento"));

                    Estado estado = new Estado();
                    estado.setId(resultSet.getInt("idEstado"));
                    estado.setNomeEstado("nomeEstado");
                    estado.setSigla("siglaEstado");

                    Cidade cidade = new Cidade();
                    cidade.setId(resultSet.getInt("idCidade"));
                    cidade.setEstado(estado);
                    cidade.setNomeCidade(resultSet.getString("nomeCidade"));
                    c.setCidade(cidade);
 
                    clientes.add(c);

                }
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException ("Erro SQL: " + ex);
            }
            return clientes;
        }   
        
        public List<Cliente> listarClientePorRg(String rg){
        Connection conn = factory.getConnection();
        List<Cliente> clientes = new ArrayList <>();
        try {
            PreparedStatement ps = null;
            ResultSet resultSet = null;

            String sql = "select *, \n" +
                         "       tipologradouro.descricao as descricaoTipoLogradouro,\n" +
                         "       estado.Sigla as siglaEstado\n" +
                         "from pessoa\n" +
                         "join cliente on pessoa.idPessoa = cliente.idCliente\n" +
                         "left join tipologradouro on pessoa.idTipoLogradouro = tipologradouro.idTipoLogradouro\n" +
                         "left join cidade on cidade.idCidade = pessoa.IdCidade\n" +
                         "left join estado on estado.idEstado = cidade.IdEstado\n" +
                         "where pessoa.rg like ?\n"+
                         "order by pessoa.nome asc";
            ps = conn.prepareStatement(sql); 
            ps.setString(1, "%"+rg+"%");
            resultSet = ps.executeQuery();

            while(resultSet.next()){

                Cliente c = new Cliente();
                c.setIdCliente(resultSet.getInt("idCliente"));
                c.setId(resultSet.getInt("idCliente"));
                c.setNome(resultSet.getString("nome"));
                c.setDatanascimento(resultSet.getDate("dataNascimento"));
                c.setSexo(resultSet.getString("sexo"));
                c.setCpf(resultSet.getString("cpf"));
                c.setRg(resultSet.getString("rg"));
                c.setTelefoneresidencial(resultSet.getString("Telefoneresidencial"));
                c.setTelefoneCelular(resultSet.getString("TelefoneCelular"));
                c.setEmail(resultSet.getString("email"));
                c.setCep(resultSet.getString("cep"));

                TipoLogradouro tipoLogradouro = new TipoLogradouro();
                tipoLogradouro.setId(resultSet.getInt("idTipoLogradouro"));
                tipoLogradouro.setNome(resultSet.getString("descricaoTipoLogradouro"));

                c.setTipoLogradouro(tipoLogradouro);

                c.setLogradouro(resultSet.getString("logradouro"));
                c.setNumero(resultSet.getInt("numero"));
                c.setBairro(resultSet.getString("bairro"));
                c.setComplemento(resultSet.getString("complemento"));

                Estado estado = new Estado();
                estado.setId(resultSet.getInt("idEstado"));
                estado.setNomeEstado("nomeEstado");
                estado.setSigla("siglaEstado");

                Cidade cidade = new Cidade();
                cidade.setId(resultSet.getInt("idCidade"));
                cidade.setEstado(estado);
                cidade.setNomeCidade(resultSet.getString("nomeCidade"));
                c.setCidade(cidade);
                
                clientes.add(c);

            }
            conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return clientes;
    }  
        
    public Cliente buscarPorId(Integer id){
            Connection conn = factory.getConnection();
            Cliente c = null;
            try {
                PreparedStatement ps = null;
                ResultSet resultSet = null;

                String sql = "select *,\n" +
                             "       tipologradouro.descricao as descricaoTipoLogradouro,\n" +
                             "       estado.Sigla as siglaEstado\n" +
                             "from pessoa\n" +
                             "join cliente on pessoa.idPessoa = cliente.idCliente\n" +
                             "left join tipologradouro on pessoa.idTipoLogradouro = tipologradouro.idTipoLogradouro\n" +
                             "left join cidade on cidade.idCidade = pessoa.IdCidade\n" +
                             "left join estado on estado.idEstado = cidade.IdEstado\n" +
                             "where pessoa.idPessoa = ?\n"+
                             "order by pessoa.nome asc";
                ps = conn.prepareStatement(sql); 
                ps.setString(1, id+"");
                resultSet = ps.executeQuery();

                if(resultSet.next()){
                    c = new Cliente();
                    c.setIdCliente(resultSet.getInt("idCliente"));
                    c.setId(resultSet.getInt("idCliente"));
                    c.setNome(resultSet.getString("nome"));
                    c.setDatanascimento(resultSet.getDate("dataNascimento"));
                    c.setSexo(resultSet.getString("sexo"));
                    c.setCpf(resultSet.getString("cpf"));
                    c.setRg(resultSet.getString("rg"));
                    c.setTelefoneresidencial(resultSet.getString("Telefoneresidencial"));
                    c.setTelefoneCelular(resultSet.getString("TelefoneCelular"));
                    c.setEmail(resultSet.getString("email"));
                    c.setCep(resultSet.getString("cep"));
                    c.setDataCadastro((java.util.Date)resultSet.getDate("DataCadastro"));

                    TipoLogradouro tipoLogradouro = new TipoLogradouro();
                    tipoLogradouro.setId(resultSet.getInt("idTipoLogradouro"));
                    tipoLogradouro.setSigla(resultSet.getString("Sigla"));
                    tipoLogradouro.setNome(resultSet.getString("descricaoTipoLogradouro"));

                    c.setTipoLogradouro(tipoLogradouro);

                    c.setLogradouro(resultSet.getString("logradouro"));
                    c.setNumero(resultSet.getInt("numero"));
                    c.setBairro(resultSet.getString("bairro"));
                    c.setComplemento(resultSet.getString("complemento"));

                    Estado estado = new Estado();
                    estado.setId(resultSet.getInt("idEstado"));
                    estado.setNomeEstado(resultSet.getString("nomeEstado"));
                    estado.setSigla(resultSet.getString("siglaEstado"));
                    c.setEstado(estado);
                    Cidade cidade = new Cidade();
                    cidade.setId(resultSet.getInt("idCidade"));
                    cidade.setNomeCidade(resultSet.getString("nomeCidade"));
                    c.setCidade(cidade);
                    
                    if (resultSet.getInt("SituacaoCliente")==1)
                        c.setSituacaoCliente(true);
                    else if (resultSet.getInt("SituacaoCliente")==0)
                        c.setSituacaoCliente(false);
                    c.setObservacoes(resultSet.getString("Observacao"));
                    

                }
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException ("Erro SQL: " + ex);
            }
            return c;
        } 
}