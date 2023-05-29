package ProjetoIntegrador.model.dao;

import ProjetoIntegrador.Verificador;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class FuncionariosDao {
    // cria a conexão com o bando de dados
    Conexao conexao = new Conexao();
    // acessa as variaveis
    Statement stm = conexao.getStm();
    ResultSet result = conexao.getResult();
    Verificador verificador= new Verificador();

    // insere uma nova empresa à tabela contas
    public void inserirFuncionario(String nome, String rg, String cpf, String id_empresa) {

        if(verificador.verificarCPF(cpf) && verificador.verificarRG(rg)) {
            try {
                String query = String.format(
                        "INSERT INTO funcionarios (`id_funcionarios`, `rg_funcionarios`, `cpf_funcionarios`, `nome_funcionarios`, `criacao_funcionarios`, `empresas_id_empresas`)" +
                                // valores numero_da_conta é gerado automaticamente pelo BD, o saldo default é 0
                                " VALUES(default, '%s', '%s', '%s', default, '%s');", rg, cpf, nome, id_empresa);
                stm.executeUpdate(query);
                System.out.println(String.format("Funcionario(a) %s Incluido(a) com SUCESSO", nome));
                JOptionPane.showMessageDialog(null,String.format("Funcionario(a) %s Incluido(a) com SUCESSO", nome));


            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro na Inclusao: " + e);

            }
        }
        else
            JOptionPane.showMessageDialog(null,"CPF ou RG invalido");
    }

    public void atualizarFuncionario(String nome, String cpf, String rg, String id_empresa, String id) {

        if(verificador.verificarCPF(cpf) && verificador.verificarRG(rg)) {
        try {
            String query = String.format("UPDATE funcionarios SET nome_funcionarios = '%s' WHERE id_funcionarios = %s;", nome, id);
            stm.executeUpdate(query);

            query = String.format("UPDATE funcionarios SET cpf_funcionarios = '%s' WHERE id_funcionarios = %s;", cpf, id);
            stm.executeUpdate(query);

            query = String.format("UPDATE funcionarios SET rg_funcionarios = '%s' WHERE id_funcionarios = %s;", rg, id);
            stm.executeUpdate(query);

            query = String.format("UPDATE funcionarios SET empresas_id_empresas = '%s' WHERE id_funcionarios = %s;", id_empresa, id);
            stm.executeUpdate(query);

            System.out.println(String.format("Funcionario(a) Numero: %s alterado(a) com sucesso" , id));
        } catch(Exception e) {
            System.out.println("Erro na Alteracao: "+ e);
        }
        }
        else
            JOptionPane.showMessageDialog(null,"CPF ou RG invalido");
    }

    public String getFuncionario(String numero_do_funcionario) {
        String rg,cpf,nome,criacao,id_empresa;
        try {
            result = stm.executeQuery(String.format("SELECT * FROM joptionpanedb.funcionarios WHERE id_funcionarios = %s;",
                    numero_do_funcionario));
            result.next();
            rg=result.getString(2);
            cpf=result.getString(3);
            nome=result.getString(4);
            criacao=result.getString(5);
            id_empresa=result.getString(6);
            return String.format("<html>Nome: %s<br/>CPF: %s<br/>RG: %s<br/>ID da empresa: %s<br/>DATA DA CRIAÇÂO: %s</html>",nome,cpf,rg,id_empresa,criacao);
        } catch(Exception e) {
            return "Empresa não encontrada: "+e.getMessage();
        }
    }

    public void excluirByNumero_do_Funcionario(String numero_do_funcionario) {
        try {
            String query = String.format("DELETE FROM funcionarios WHERE id_funcionarios = %s;", numero_do_funcionario);
            stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null,String.format("ID: %s EXCLUIDO COM SUCESSO", numero_do_funcionario));

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Erro na Exclusao: "+ e.getMessage());
        }
    }
}
