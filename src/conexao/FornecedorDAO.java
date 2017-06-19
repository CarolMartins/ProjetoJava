
package conexao;

import Classes.Cidade;
import Classes.Estado;
import Classes.Fornecedor;
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
public class FornecedorDAO {
    
    ConnectionFactory factory = new ConnectionFactory();
    
    public void salvar(Fornecedor forn){
        Connection conn = factory.getConnection();        
            try {
                PreparedStatement ps = conn.prepareStatement ("INSERT INTO fornecedor (RazaoSocial, NomeFantasia,"
                        + " Cnpj, InscricaoEstadual, TelefoneComercial1, TelefoneComercial2, Email, Cep, idTipoLogradouro,"
                        + " Logradouro, Numero, Bairro, Complemento, Observacao, idCidade, dataCadastro, situacaoFornecedor)"
                        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, forn.getRazaoSocial());
                ps.setString(2, forn.getNomeFantasia());
                ps.setString(3, forn.getCnpj());
                ps.setString(4, forn.getIe());
                ps.setString(5, forn.getTelefoneContato1());
                ps.setString(6, forn.getTelefoneContato2());
                ps.setString(7, forn.getEmail());
                ps.setString(8, forn.getCep());
                ps.setInt(9, forn.getTipoLogradouro().getId());
                ps.setString(10, forn.getLogradouro());
                ps.setInt(11, forn.getNumero());
                ps.setString(12, forn.getBairro());
                ps.setString(13, forn.getComplemento());
                ps.setString(14, forn.getObservacoes());
                ps.setInt(15, forn.getCidade().getId());
                ps.setDate(16, new java.sql.Date(forn.getDataCadastro().getTime()));
                ps.setBoolean(17, forn.getSituacaoFornecedor());
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next())
                    forn.setId(rs.getInt(1));
                conn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }   
    }
    
    public void editar(Fornecedor forn){
        Connection conn = factory.getConnection();
        
            try {
                PreparedStatement ps = conn.prepareStatement("UPDATE fornecedor set RazaoSocial= ?, NomeFantasia = ?,"
                        + " Cnpj= ?, InscricaoEstadual= ?, TelefoneComercial1= ?, TelefoneComercial2= ?, Email= ?, Cep= ?,"
                        + " idTipoLogradouro= ?, Logradouro= ?, Numero= ?, Bairro= ?, Complemento= ?, "
                        + " Observacao= ?, idCidade= ?, situacaoFornecedor= ?"
                        + " where idFornecedor = ?");
                
           ps.setString(1, forn.getRazaoSocial());
           ps.setString(2, forn.getNomeFantasia());
           ps.setString(3, forn.getCnpj());
           ps.setString(4, forn.getIe());
           ps.setString(5, forn.getTelefoneContato1());
           ps.setString(6, forn.getTelefoneContato2());
           ps.setString(7, forn.getEmail());
           ps.setString(8, forn.getCep());
           ps.setInt(9, forn.getTipoLogradouro().getId());
           ps.setString(10, forn.getLogradouro());
           ps.setInt(11, forn.getNumero());
           ps.setString(12, forn.getBairro());
           ps.setString(13, forn.getComplemento());
           ps.setString(14, forn.getObservacoes());
           ps.setInt(15, forn.getCidade().getId());
           ps.setBoolean(16, forn.getSituacaoFornecedor());
           ps.setInt(17, forn.getId());
           ps.executeUpdate();
           
           conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar " + ex);
            }
    }
    
        public void excluir(Fornecedor forn){
            Connection conn = factory.getConnection();
            try {
                String sql = "delete from fornecedor where idFornecedor = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setLong(1, forn.getId());
                ps.executeUpdate();

                conn.close();
                JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar " + ex);
                }    
    }
        
    public List<Fornecedor> listarFornecedorPorNome(String nome){
        Connection conn = factory.getConnection();
        List<Fornecedor> fornecedores = new ArrayList <>();
        try {
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            
           String sql = "SELECT fornecedor.*, tipologradouro.Descricao as descricaoTipoLogradouro, tipologradouro.Sigla as siglatipologradouro,\n" +
                        "	   cidade.NomeCidade,\n" +
                        "       estado.idEstado, estado.NomeEstado, estado.Sigla as siglaestado\n" +
                        "FROM fornecedor\n" +
                        "join cidade on fornecedor.idCidade = Cidade.idCidade\n" +
                        "join tipologradouro on fornecedor.idTipoLogradouro = tipologradouro.idTipoLogradouro\n" +
                        "join estado on cidade.idEstado = estado.idEstado\n" +
                        "where fornecedor.NomeFantasia like ?\n" +
                        "order by fornecedor.NomeFantasia ";
           
            ps = conn.prepareStatement(sql); 
            ps.setString(1, "%"+nome+"%");
            resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                
                Fornecedor forn = new Fornecedor();
                forn.setId(resultSet.getInt("idFornecedor"));
                forn.setRazaoSocial(resultSet.getString("razaoSocial"));
                forn.setNomeFantasia(resultSet.getString("NomeFantasia"));
                forn.setCnpj(resultSet.getString("cnpj"));
                forn.setIe(resultSet.getString("InscricaoEstadual"));
                forn.setTelefoneContato1(resultSet.getString("TelefoneComercial1"));
                forn.setTelefoneContato2(resultSet.getString("TelefoneComercial2"));
                forn.setEmail(resultSet.getString("email"));
                forn.setCep(resultSet.getString("Cep"));
                
                TipoLogradouro tipoLogradouro = new TipoLogradouro();
                tipoLogradouro.setId(resultSet.getInt("idTipoLogradouro"));
                tipoLogradouro.setNome(resultSet.getString("descricaoTipoLogradouro"));
                
                forn.setTipoLogradouro(tipoLogradouro);
                                
                forn.setLogradouro(resultSet.getString("Logradouro"));
                forn.setNumero(resultSet.getInt("numero"));
                forn.setBairro(resultSet.getString("bairro"));
                forn.setComplemento(resultSet.getString("complemento"));
                forn.setObservacoes(resultSet.getString("observacao"));
                
                Estado estado = new Estado();
                estado.setId(resultSet.getInt("idEstado"));
                estado.setNomeEstado("nomeEstado");
                estado.setSigla("siglaEstado");
                
                Cidade cidade = new Cidade();
                cidade.setId(resultSet.getInt("idCidade"));
                cidade.setEstado(estado);
                cidade.setNomeCidade(resultSet.getString("nomeCidade"));
                
                forn.setCidade(cidade);
                
                forn.setDataCadastro(resultSet.getDate("DataCadastro"));    
                forn.setSituacaoFornecedor(resultSet.getBoolean("situacaoFornecedor")); 
                
                fornecedores.add(forn);
        }

        conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return fornecedores;
    }
    
    public List<Fornecedor> listarFornecedorPorCNPJ(String cnpj){
        Connection conn = factory.getConnection();
        List<Fornecedor> fornecedores = new ArrayList <>();
        try {
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            
           String sql = "SELECT fornecedor.*, tipologradouro.Descricao as descricaoTipoLogradouro, tipologradouro.Sigla as siglatipologradouro,\n" +
                        "	   cidade.NomeCidade,\n" +
                        "       estado.idEstado, estado.NomeEstado, estado.Sigla as siglaestado\n" +
                        "FROM fornecedor\n" +
                        "join cidade on fornecedor.idCidade = Cidade.idCidade\n" +
                        "join tipologradouro on fornecedor.idTipoLogradouro = tipologradouro.idTipoLogradouro\n" +
                        "join estado on cidade.idEstado = estado.idEstado\n" +
                        "where fornecedor.cnpj like ?\n" +
                        "order by fornecedor.NomeFantasia ";
           
            ps = conn.prepareStatement(sql); 
            ps.setString(1, "%"+cnpj+"%");
            resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                
                Fornecedor forn = new Fornecedor();
                forn.setId(resultSet.getInt("idFornecedor"));
                forn.setRazaoSocial(resultSet.getString("razaoSocial"));
                forn.setNomeFantasia(resultSet.getString("NomeFantasia"));
                forn.setCnpj(resultSet.getString("cnpj"));
                forn.setIe(resultSet.getString("InscricaoEstadual"));
                forn.setTelefoneContato1(resultSet.getString("TelefoneComercial1"));
                forn.setTelefoneContato2(resultSet.getString("TelefoneComercial2"));
                forn.setEmail(resultSet.getString("email"));
                forn.setCep(resultSet.getString("Cep"));
                
                TipoLogradouro tipoLogradouro = new TipoLogradouro();
                tipoLogradouro.setId(resultSet.getInt("idTipoLogradouro"));
                tipoLogradouro.setNome(resultSet.getString("descricaoTipoLogradouro"));
                
                forn.setTipoLogradouro(tipoLogradouro);
                                
                forn.setLogradouro(resultSet.getString("Logradouro"));
                forn.setNumero(resultSet.getInt("numero"));
                forn.setBairro(resultSet.getString("bairro"));
                forn.setComplemento(resultSet.getString("complemento"));
                forn.setObservacoes(resultSet.getString("observacao"));
                
                Estado estado = new Estado();
                estado.setId(resultSet.getInt("idEstado"));
                estado.setNomeEstado("nomeEstado");
                estado.setSigla("siglaEstado");
                
                Cidade cidade = new Cidade();
                cidade.setId(resultSet.getInt("idCidade"));
                cidade.setEstado(estado);
                cidade.setNomeCidade(resultSet.getString("nomeCidade"));
                
                forn.setCidade(cidade);
                
                forn.setDataCadastro(resultSet.getDate("DataCadastro"));    
                forn.setSituacaoFornecedor(resultSet.getBoolean("situacaoFornecedor")); 
                
                fornecedores.add(forn);
        }

        conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return fornecedores;
    }  
    
    public List<Fornecedor> listarFornecedorPorIE(String ie){
        Connection conn = factory.getConnection();
        List<Fornecedor> fornecedores = new ArrayList <>();
        try {
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            
           String sql = "SELECT fornecedor.*, tipologradouro.Descricao as descricaoTipoLogradouro, tipologradouro.Sigla as siglatipologradouro,\n" +
                        "	   cidade.NomeCidade,\n" +
                        "       estado.idEstado, estado.NomeEstado, estado.Sigla as siglaestado\n" +
                        "FROM fornecedor\n" +
                        "join cidade on fornecedor.idCidade = Cidade.idCidade\n" +
                        "join tipologradouro on fornecedor.idTipoLogradouro = tipologradouro.idTipoLogradouro\n" +
                        "join estado on cidade.idEstado = estado.idEstado\n" +
                        "where fornecedor.inscricaoestadual like ?\n" +
                        "order by fornecedor.NomeFantasia ";
           
            ps = conn.prepareStatement(sql); 
            ps.setString(1, "%"+ie+"%");
            resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                
                Fornecedor forn = new Fornecedor();
                forn.setId(resultSet.getInt("idFornecedor"));
                forn.setRazaoSocial(resultSet.getString("razaoSocial"));
                forn.setNomeFantasia(resultSet.getString("NomeFantasia"));
                forn.setCnpj(resultSet.getString("cnpj"));
                forn.setIe(resultSet.getString("InscricaoEstadual"));
                forn.setTelefoneContato1(resultSet.getString("TelefoneComercial1"));
                forn.setTelefoneContato2(resultSet.getString("TelefoneComercial2"));
                forn.setEmail(resultSet.getString("email"));
                forn.setCep(resultSet.getString("Cep"));
                
                TipoLogradouro tipoLogradouro = new TipoLogradouro();
                tipoLogradouro.setId(resultSet.getInt("idTipoLogradouro"));
                tipoLogradouro.setNome(resultSet.getString("descricaoTipoLogradouro"));
                
                forn.setTipoLogradouro(tipoLogradouro);
                                
                forn.setLogradouro(resultSet.getString("Logradouro"));
                forn.setNumero(resultSet.getInt("numero"));
                forn.setBairro(resultSet.getString("bairro"));
                forn.setComplemento(resultSet.getString("complemento"));
                forn.setObservacoes(resultSet.getString("observacao"));
                
                Estado estado = new Estado();
                estado.setId(resultSet.getInt("idEstado"));
                estado.setNomeEstado("nomeEstado");
                estado.setSigla("siglaEstado");
                
                Cidade cidade = new Cidade();
                cidade.setId(resultSet.getInt("idCidade"));
                cidade.setEstado(estado);
                cidade.setNomeCidade(resultSet.getString("nomeCidade"));
                
                forn.setCidade(cidade);
                
                forn.setDataCadastro(resultSet.getDate("DataCadastro"));    
                forn.setSituacaoFornecedor(resultSet.getBoolean("situacaoFornecedor")); 
                
                fornecedores.add(forn);
        }

        conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return fornecedores;
    }       
        
    public Fornecedor buscarPorId(Integer id){
        Connection conn = factory.getConnection();
        Fornecedor forn = null;
        try {
            PreparedStatement ps = null;
            ResultSet resultSet = null;

            String sql = "SELECT fornecedor.*, tipologradouro.Descricao as descricaoTipoLogradouro, tipologradouro.Sigla as siglatipologradouro,\n" +
                        "	   cidade.NomeCidade,\n" +
                        "       estado.idEstado, estado.NomeEstado, estado.Sigla as siglaestado\n" +
                        "FROM fornecedor\n" +
                        "join cidade on fornecedor.idCidade = Cidade.idCidade\n" +
                        "join tipologradouro on fornecedor.idTipoLogradouro = tipologradouro.idTipoLogradouro\n" +
                        "join estado on cidade.idEstado = estado.idEstado\n" +
                        "where fornecedor.idFornecedor = ?\n" +
                        "order by fornecedor.NomeFantasia ";;
            
            ps = conn.prepareStatement(sql); 
            ps.setString(1, id+ "");
            resultSet = ps.executeQuery();

            if(resultSet.next()){
                forn = new Fornecedor();
                forn.setId(resultSet.getInt("idFornecedor"));
                forn.setRazaoSocial(resultSet.getString("razaoSocial"));
                forn.setNomeFantasia(resultSet.getString("NomeFantasia"));
                forn.setCnpj(resultSet.getString("cnpj"));
                forn.setIe(resultSet.getString("InscricaoEstadual"));
                forn.setTelefoneContato1(resultSet.getString("TelefoneComercial1"));
                forn.setTelefoneContato2(resultSet.getString("TelefoneComercial2"));
                forn.setEmail(resultSet.getString("email"));
                forn.setCep(resultSet.getString("Cep"));
                
                TipoLogradouro tipoLogradouro = new TipoLogradouro();
                tipoLogradouro.setId(resultSet.getInt("idTipoLogradouro"));
                tipoLogradouro.setNome(resultSet.getString("descricaoTipoLogradouro"));
                tipoLogradouro.setSigla(resultSet.getString("siglatipologradouro"));
                
                forn.setTipoLogradouro(tipoLogradouro);
                                
                forn.setLogradouro(resultSet.getString("Logradouro"));
                forn.setNumero(resultSet.getInt("numero"));
                forn.setBairro(resultSet.getString("bairro"));
                forn.setComplemento(resultSet.getString("complemento"));
                forn.setObservacoes(resultSet.getString("observacao"));
                
                Estado estado = new Estado();
                estado.setId(resultSet.getInt("idEstado"));
                estado.setNomeEstado(resultSet.getString("nomeEstado"));
                estado.setSigla(resultSet.getString("siglaEstado"));
                forn.setEstado(estado);
                
                Cidade cidade = new Cidade();
                cidade.setId(resultSet.getInt("idCidade"));
                cidade.setNomeCidade(resultSet.getString("nomeCidade"));
                
                forn.setCidade(cidade);
                
                forn.setDataCadastro(resultSet.getDate("DataCadastro"));    
                forn.setSituacaoFornecedor(resultSet.getBoolean("situacaoFornecedor"));  

            }
        conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro SQL: " + ex);
        }
        return forn;
        } 
        }

