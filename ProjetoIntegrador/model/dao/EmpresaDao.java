package ContaCorrenteProjeto.model.dao;
// import das classes para a execução das querys e a obtenção das respostas
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpresaDao {
    // cria a conexão com o bando de dados
    Conexao conexao = new Conexao();
    // acessa as variaveis 
    Statement stm = conexao.getStm();
    ResultSet result = conexao.getResult();
    // imprime todas as contas disponíveis
    public void listarContas() {
        try {
            String minhaQuery = "SELECT * FROM contas ORDER BY nome";
            // executa a query 
            result = stm.executeQuery(minhaQuery);
            // enquanto houver uma resposta da query no Result, imprime os dados da conta
            while (result.next()) {
                System.out.println("ID: "+result.getString("id") + " - Nome: "+result.getString("nome") );
            }
        } catch(Exception e) {
            System.out.println("Erro na lista: "+ e);
        }
    }
    // insere uma nova conta à tabela contas
    public void inserirEmpresas(String nome, String cnpj, String ie, String cep) {
        try {
            String query = String.format(
                "INSERT INTO empresas (`id_empresas`, `cnpj_empresas`, `ie_empresas`, `cep_empresas`, `criacao_empresas`, `nome_empresas`)"+
                // valores numero_da_conta é gerado automaticamente pelo BD, o saldo default é 0
                " VALUES(default, '%s', %s, %s, default, %s);",cnpj,ie,cep,nome);
            stm.executeUpdate(query);
            System.out.println(String.format("Empresa %s Incluida com SUCESSO" , nome));
            
        } catch(Exception e) {
            System.out.println("Erro na Inclusao: "+ e);
        }
    }
    // altera o saldo de uma conta para um dado valor
    public void setSaldo(String numero_da_conta, String saldo) {
        try {
            String query = String.format("UPDATE contas SET saldo = %s WHERE numero_da_conta = %s;",
            saldo, numero_da_conta);
            stm.executeUpdate(query);
            System.out.println(String.format("Conta Numero: %s alterada com sucesso" , numero_da_conta));
        } catch(Exception e) {
            System.out.println("Erro na Alteracao: "+ e);
        }
    }
    // retorna o saldo atual de uma dada conta
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

            return "Nome: "+nome+"\nCNPJ: "+cnpj+"\nIE: "+ie+"\nCEP: "+cep+"\nDATA DA CRIAÇÂO: "+criacao;
        } catch(Exception e) {
            return "Empresa não encontrada: "+e.getMessage();
        }
    }
    // exclui uma conta a partir de um numero_da_conta
    public void excluirByNumero_da_Empresa(String numero_da_empresa) {
        try {
            String query = String.format("DELETE FROM empresas WHERE id_empresas = %s;", numero_da_empresa);
            stm.executeUpdate(query);
            System.out.println(String.format("ID: %s EXCLUIDO COM SUCESSO", numero_da_empresa));
            
        } catch(Exception e) {
            System.out.println("Erro na Exclusao: "+ e.getMessage());
        }
    }
    // retorna o nome de uma dada conta a partir do numero_da_conta
    public String getNome(String numero_da_conta){
        try {
            String minhaQuery = String.format("SELECT nome FROM contas WHERE numero_da_conta = %s", numero_da_conta);
            result = stm.executeQuery(minhaQuery);
            result.next();
            return result.getString(1);
        } catch(Exception e) {
            System.out.println("Conta não encontrada.");
            return null;
        }
    }

}
