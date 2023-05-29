package ProjetoIntegrador.model.dao;
// import das classes para a execução das querys e a obtenção das respostas
import javax.swing.*;
import ProjetoIntegrador.Verificador;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpresaDao {
    // cria a conexão com o bando de dados
    Conexao conexao = new Conexao();
    // acessa as variaveis 
    Statement stm = conexao.getStm();
    ResultSet result = conexao.getResult();

    // insere uma nova empresa à tabela contas
    public void inserirEmpresas(String nome, String cnpj, String ie, String cep) {
        if (Verificador.verificarCNPJ(cnpj) && Verificador.verificadorCep(cep)) {
            try {
                String query = String.format(
                "INSERT INTO empresas (`id_empresas`, `cnpj_empresas`, `ie_empresas`, `cep_empresas`, `criacao_empresas`, `nome_empresas`)"+
                // valores numero_da_conta é gerado automaticamente pelo BD, o saldo default é 0
                " VALUES(default, '%s', '%s', '%s', default, '%s');",cnpj,ie,cep,nome);
                stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null,String.format("Empresa %s Incluida com SUCESSO" , nome));
                
            } catch(Exception e) {
                System.out.println("Erro na Inclusao: "+ e);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"CNPJ ou CEP invalido");
        }
    }

    public void atualizarEmpresa(String nome, String cnpj, String ie, String cep, String id) {
        try {
            String query = String.format("UPDATE empresas SET nome_empresas = '%s' WHERE id_empresas = %s;", nome, id);
            stm.executeUpdate(query);

            query = String.format("UPDATE empresas SET cnpj_empresas = '%s' WHERE id_empresas = %s;", cnpj, id);
            stm.executeUpdate(query);

            query = String.format("UPDATE empresas SET ie_empresas = '%s' WHERE id_empresas = %s;", ie, id);
            stm.executeUpdate(query);

            query = String.format("UPDATE empresas SET cep_empresas = '%s' WHERE id_empresas = %s;", cep, id);
            stm.executeUpdate(query);

            JOptionPane.showMessageDialog(null,String.format("Empresa Numero: %s alterada com sucesso" , id));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Erro na Alteracao: "+ e);

        }
    }

    public String getEmpresa(String numero_da_empresa) {
        String cnpj,ie,cep,criacao,nome;
        try {
            result = stm.executeQuery(String.format("SELECT * FROM joptionpanedb.empresas WHERE id_empresas = %s;",
            numero_da_empresa));
            result.next();
            cnpj=result.getString(2);
            ie=result.getString(3);
            cep=result.getString(4);
            criacao=result.getString(5);
            nome=result.getString(6);

            return String.format("<html>Nome: %s<br/>CEP: %s<br/>CNPJ: %s<br/>IE da empresa: %s<br/>DATA DA CRIAÇÂO: %s</html>",nome,cep,cnpj,ie,criacao);
        } catch(Exception e) {
            return "Empresa não encontrada: "+e.getMessage();
        }
    }

    public void excluirByNumero_da_Empresa(String numero_da_empresa) {
        try {
            String query = String.format("DELETE FROM empresas WHERE id_empresas = %s;", numero_da_empresa);
            stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null,String.format("ID: %s EXCLUIDO COM SUCESSO", numero_da_empresa));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Erro na Exclusao: "+ e.getMessage());

        }
    }
}
