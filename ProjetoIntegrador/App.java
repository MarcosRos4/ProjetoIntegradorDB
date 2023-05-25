package ContaCorrenteProjeto;
import ContaCorrenteProjeto.model.dao.FuncionariosDao;
import ContaCorrenteProjeto.view.AppView;
import ContaCorrenteProjeto.controller.EmpresaController;
import ContaCorrenteProjeto.controller.TransferenciaController;
import ContaCorrenteProjeto.model.dao.EmpresaDao;
import ContaCorrenteProjeto.view.MenuView;

public class App {

    static EmpresaDao empresaDao = new EmpresaDao();

    static FuncionariosDao funcionariosDao=new FuncionariosDao();
    // classe que representa o UI
    static AppView interfacegrafica = new AppView();
    // variavel para imput do usuario
    static String respostaString;

    static String nome,ie,cep,cnpj,id,rg,cpf,id_empresa;

    public static void main(String[] args) {

        new MenuView();

        interfacegrafica.imprimir("Deseja acessar as empresas(0) ou funcionarios(1)?\nResposta: ");
        respostaString = interfacegrafica.receberString();
        while (true) {

            if(respostaString.equals("0")){
                while (respostaString != "5") {
                
                    interfacegrafica.imprimir("O que deseja fazer?\nAdicionar Empresa(1) | Ver empresa(2) | Atualizar empresa(3) | Excluir empresa(4)| Sair(5): ");
                    respostaString = interfacegrafica.receberString();
                    // se 1 -  Criar
                    if (respostaString.equals("1")) {
                        interfacegrafica.imprimir("Digite o nome da empresa: ");
                        nome=interfacegrafica.receberString();

                        interfacegrafica.imprimir("Digite o cep da empresa: ");
                        cep=interfacegrafica.receberString();

                        interfacegrafica.imprimir("Digite o ie da empresa: ");
                        ie =interfacegrafica.receberString();

                        interfacegrafica.imprimir("Digite o cnpj da empresa: ");
                        cnpj=interfacegrafica.receberString();

                        empresaDao.inserirEmpresas( nome,  cnpj,  ie, cep);
                    }
                    // se 2 - Ver
                    else if(respostaString.equals("2")){
                        interfacegrafica.imprimir("Digite o ID da empresa: ");
                        System.out.println(empresaDao.getEmpresa(interfacegrafica.receberString()));
                    }
                    // se 3 - Atualizar
                    else if(respostaString.equals("3")){
                        interfacegrafica.imprimir("Digite o ID da empresa para atualizar: ");
                        id=interfacegrafica.receberString();

                        interfacegrafica.imprimir("Digite o novo nome da empresa: ");
                        nome=interfacegrafica.receberString();

                        interfacegrafica.imprimir("Digite o novo cep da empresa: ");
                        cep=interfacegrafica.receberString();

                        interfacegrafica.imprimir("Digite o novo ie da empresa: ");
                        ie =interfacegrafica.receberString();

                        interfacegrafica.imprimir("Digite o novo cnpj da empresa: ");
                        cnpj=interfacegrafica.receberString();

                        empresaDao.atualizarEmpresa(nome, cnpj, ie, cep, id);
                    }
                    // se 4 - Excluir
                    else if(respostaString.equals("4")){
                        interfacegrafica.imprimir("Digite o ID da empresa que sera excluida: ");
                        empresaDao.excluirByNumero_da_Empresa(interfacegrafica.receberString());
                    }
                    else if (respostaString.equals("5")) {
                        interfacegrafica.imprimir("Deseja fazer Login(0) ou Cadastrar nova Conta(1)?\nResposta: ");
                        respostaString = interfacegrafica.receberString();
                        break;
                    }
                    // se nenhuma das anteriores - mostra que a opção foi invalida e termina a execução do programa
                    else{
                        interfacegrafica.imprimir("Opção Inválida!");
                    }
                }
            }

            else if(respostaString.equals("1")){

                while (respostaString != "5") {

                    interfacegrafica.imprimir("O que deseja fazer?\nAdicionar Funcionario(a)(1) | Ver Funcionario(a)(2) | Atualizar Funcionario(a)(3) | Excluir Funcionario(a)(4)| Sair(5): ");
                    respostaString = interfacegrafica.receberString();
                    // se 1 -  Criar
                    if (respostaString.equals("1")) {
                        interfacegrafica.imprimir("Digite o nome da Funcionario(a): ");
                        nome=interfacegrafica.receberString();

                        interfacegrafica.imprimir("Digite o rg da Funcionario(a) Exemplo: 000000000\n: ");
                        rg=interfacegrafica.receberString();

                        interfacegrafica.imprimir("Digite o cpf da Funcionario(a) Exemplo :000.000.000-00\n: ");
                        cpf =interfacegrafica.receberString();

                        interfacegrafica.imprimir("Digite o id da empresa do Funcionario(a): ");
                        id_empresa=interfacegrafica.receberString();

                        funcionariosDao.inserirFuncionario( nome,  rg,  cpf, id_empresa);
                    }
                    // se 2 - Ver
                    else if(respostaString.equals("2")){
                        interfacegrafica.imprimir("Digite o ID do(a) funcionario(a): ");
                        System.out.println(funcionariosDao.getFuncionario(interfacegrafica.receberString()));
                    }
                    // se 3 - Atualizar
                    else if(respostaString.equals("3")){
                        interfacegrafica.imprimir("Digite o ID do(a) funcionario(a) para atualizar: ");
                        id=interfacegrafica.receberString();

                        interfacegrafica.imprimir("Digite o novo nome do(a) funcionario(a): ");
                        nome=interfacegrafica.receberString();

                        interfacegrafica.imprimir("Digite o novo cpf do(a) funcionario(a) Exemplo :000.000.000-00\n: ");
                        cpf=interfacegrafica.receberString();

                        interfacegrafica.imprimir("Digite o novo rg do(a) funcionario(a) Exemplo: 000000000\n: ");
                        rg =interfacegrafica.receberString();

                        interfacegrafica.imprimir("Digite o novo id da empresa do(a) funcionario(a): ");
                        id_empresa=interfacegrafica.receberString();

                        funcionariosDao.atualizarFuncionario(nome, cpf, rg, id_empresa, id);
                    }
                    // se 4 - Excluir
                    else if(respostaString.equals("4")){
                        interfacegrafica.imprimir("Digite o ID do(a) funcionario(a) que sera excluida: ");
                        funcionariosDao.excluirByNumero_do_Funcionario(interfacegrafica.receberString());
                    }
                    else if (respostaString.equals("5")) {
                        interfacegrafica.imprimir("Deseja fazer Login(0) ou Cadastrar nova Conta(1)?\nResposta: ");
                        respostaString = interfacegrafica.receberString();
                        break;
                    }
                    // se nenhuma das anteriores - mostra que a opção foi invalida e termina a execução do programa
                    else{
                        interfacegrafica.imprimir("Opção Inválida!");
                    }
                }

        }
            // se nenhuma das anteriores - mostra que a opção foi invalida e termina a execução do programa
            else{
            interfacegrafica.imprimir("Opção inválida!\n");
            interfacegrafica.imprimir("Deseja fazer Login(0) ou Cadastrar nova Conta(1)?\nResposta: ");
            respostaString = interfacegrafica.receberString();
        }
        
        }
    }
}
