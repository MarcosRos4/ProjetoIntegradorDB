package ProjetoIntegrador.model.dao;

// import das classes para a execução das querys e a obtenção das respostas
import javax.swing.*;

import ProjetoIntegrador.viacep.dominio.Endereco;
import ProjetoIntegrador.viacep.servico.ServicoDeCep;

import java.sql.ResultSet;
import java.sql.Statement;

public class EnderecoDao {
    // cria a conexão com o bando de dados
    Conexao conexao = new Conexao();
    // acessa as variaveis 
    Statement stm = conexao.getStm();
    ResultSet result = conexao.getResult();

    // insere uma nova Endereco à tabela contas
    public void inserirEndereco(String cep) {
        try {
            Endereco endereco = ServicoDeCep.buscaEnderecoPelo(cep);
            String query = String.format(// valores idenderecos é gerado automaticamente pelo BD, o saldo default é 0
            "INSERT INTO enderecos(`idenderecos`,`cep`,`logradouro`,`complemento`,`bairro`,`cidade`,`uf`) VALUES (default, '%s', '%s', '%s', '%s', '%s', '%s');",
            cep, endereco.getLogradouro(), endereco.getComplemento(), endereco.getBairro(), endereco.getLocalidade(), endereco.getUf());
            stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null,String.format("CEP %s (%s) Incluido com SUCESSO" , cep, endereco.getLogradouro()));
            
        } catch(Exception e) {
            System.out.println("Erro na Inclusao: "+ e);
        }
    }

    public void atualizarEndereco(String idenderecos, String cep, String logradouro, String complemento, String bairro, String cidade, String uf) {
        try {
            String query = String.format(
            "UPDATE enderecos SET `cep` = %s, `logradouro` = %s, `complemento` = %s, `bairro` = %s, `cidade` = %s, `uf` = %s WHERE `idenderecos` = %s;)",
            cep, logradouro, complemento, bairro, cidade, uf, idenderecos);
            stm.executeUpdate(query);

            JOptionPane.showMessageDialog(null,String.format("Endereco Numero: %s alterada com sucesso" , idenderecos));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Erro na Alteracao: "+ e);

        }
    }

    public String getEndereco(String idendereco) {
        String cep, logradouro, complemento, bairro, cidade, uf;
        try {
            result = stm.executeQuery(String.format("SELECT * FROM enderecos WHERE idenderecos = %s;",
            idendereco));

            result.next();
            cep = result.getString(2);
            logradouro = result.getString(3);
            complemento = result.getString(4);
            bairro = result.getString(5);
            cidade = result.getString(6);
            uf = result.getString(7);

            return String.format("<html>Nome: %s<br/>CEP: %s<br/>LOGRADOURO: %s<br/>COMPLEMENTO: %s<br/>BAIRRO: %s<br/>CIDADE: %s<br/>UF: %s</html>",
            cep, logradouro, complemento, bairro, cidade, uf);
        } catch(Exception e) {
            return "Endereco não encontrada: "+e.getMessage();
        }
    }

    public void excluirByidendereco(String idendereco) {
        try {
            String query = String.format("DELETE FROM enderecos WHERE idenderecos = %s;", idendereco);
            stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null,String.format("ID: %s EXCLUIDO COM SUCESSO", idendereco));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Erro na Exclusao: "+ e.getMessage());

        }
    }
}
