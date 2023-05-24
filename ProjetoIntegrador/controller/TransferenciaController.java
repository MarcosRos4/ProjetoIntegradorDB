package ContaCorrenteProjeto.controller;


import ContaCorrenteProjeto.model.dao.TransferenciasDao;

public class TransferenciaController {
    private String numero_da_conta;
    private TransferenciasDao transferencias = new TransferenciasDao();
    
    public TransferenciaController(String numero_da_conta){
        this.numero_da_conta = numero_da_conta;
    }



    public void mostrarTransferencias() {
        this.transferencias.getExtrato(this.numero_da_conta);
    }
}
