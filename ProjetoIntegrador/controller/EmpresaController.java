package ProjetoIntegrador.controller;
// importa classe que vai acessar o banco de dados
import ProjetoIntegrador.model.dao.EmpresaDao;

public class EmpresaController {
    // numero da conta que vai ser acessada
    private String numero_da_conta;
    private EmpresaDao empresa = new EmpresaDao();
    // construtor do objeto já define a conta acessada na instanciação
    public EmpresaController(String numero_da_conta){
        this.numero_da_conta = numero_da_conta;   
    }
    // recebe um valor float para sacar

}
