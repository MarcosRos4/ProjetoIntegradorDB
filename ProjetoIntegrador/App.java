package ContaCorrenteProjeto;
import ContaCorrenteProjeto.view.AppView;
import ContaCorrenteProjeto.controller.EmpresaController;
import ContaCorrenteProjeto.controller.TransferenciaController;
import ContaCorrenteProjeto.model.dao.EmpresaDao;
public class App {
    // classe que faz as regras de negocio
    static EmpresaController empresaController;

    static TransferenciaController transferenciaController;
    // classe que altera o BD
    static EmpresaDao empresaDao = new EmpresaDao();
    // classe que representa o UI
    static AppView interfacegrafica = new AppView();
    // variavel para imput do usuario
    static String respostaString;

    static String nome,ie,cep,cnpj,id;

    public static void main(String[] args) {
        // o aplicativo começa com duas opções, ou logar com uma conta já existente ou criar uma nova conta

        interfacegrafica.imprimir("Deseja acessar as empresas(0) ou funcionarios(1)?\nResposta: ");
        respostaString = interfacegrafica.receberString();
        while (true) {
            // se escolher a opção 0 ele segue para o login e as opções de gerenciamento de conta
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
            // se 1 - cadastra uma nova conta
            else if(respostaString.equals("1")){

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
