package ProjetoIntegrador;

import ProjetoIntegrador.viacep.servico.ServicoDeCep;

public class Verificador {
    
    public boolean verificarRG(String rg){//tem q ser inserido como "000000000"
        int soma=0;
        int mult=9;
        int resto;
        int verificador;

        if(rg.charAt(8)=='x' || rg.charAt(8)=='X')
            verificador = 10;
        else
            verificador= rg.charAt(8)-'0';

        for(int i=0;i<rg.length()-1;i++){
            soma+=((rg.charAt(i)-'0')*mult);
            mult--;
        }

        resto=soma%11;

        if(resto==verificador)
            return true;

        return false;
    }
    public boolean verificarCPF(String cpf){//Precisa inserir o CPF como "000.000.000-00"
         String S1,S2,S3,S4,S5,S6,S7,S8,S9, confere = "";
         int N1, N2 , N3,N4, N5, N6, N7,N8,N9, verificador1, verificador2;
         S1= cpf.substring(0, 1); N1 = Integer.parseInt(S1);
         S2= cpf.substring(1, 2); N2 = Integer.parseInt(S2);
         S3= cpf.substring(2, 3); N3 = Integer.parseInt(S3);
         S4= cpf.substring(4, 5); N4 = Integer.parseInt(S4);
         S5= cpf.substring(5,6); N5 = Integer.parseInt(S5);
         S6= cpf.substring(6, 7); N6 = Integer.parseInt(S6);
         S7= cpf.substring(8, 9); N7 = Integer.parseInt(S7);
         S8= cpf.substring(9, 10); N8 = Integer.parseInt(S8);
         S9= cpf.substring(10, 11); N9 = Integer.parseInt(S9);

         verificador1 = (N1 * 10 + N2 * 9 + N3 * 8 + N4 * 7 + N5 * 6 + N6 * 5 + N7 * 4 + N8 * 3 + N9 * 2);
         if ((verificador1 % 11) < 2)
             verificador1 = 0;
         else
             verificador1 = 11 - (verificador1 % 11);

         verificador2 = (N1 * 11 + N2 * 10 + N3 * 9 + N4 * 8 + N5 * 7 + N6 * 6 + N7 * 5 + N8 * 4 + N9 * 3 + verificador1 *2);
         if ((verificador2 % 11) < 2)
             verificador2 = 0;
         else
             verificador2 = 11 - (verificador2 % 11);

         confere = (S1 + S2 + S3 + "." + S4 + S5 + S6 + "."+ S7+ S8 + S9 +"-"+verificador1+""+verificador2);





         if (confere.equals(cpf) ){
             return true;
         }
         else
             return false;
     }
    public static boolean verificarCNPJ(String cnpj){//Precisa inserir o CNPJ como "00.000.000/0000-00"
        String S1,S2,S3,S4,S5,S6,S7,S8,S9, S10, S11, S12, confere = "";
        int N1, N2 , N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, verificador1, verificador2;
        S1= cnpj.substring(0, 1); N1 = Integer.parseInt(S1);
        S2= cnpj.substring(1, 2); N2 = Integer.parseInt(S2);

        S3= cnpj.substring(3, 4); N3 = Integer.parseInt(S3);
        S4= cnpj.substring(4, 5); N4 = Integer.parseInt(S4);
        S5= cnpj.substring(5, 6); N5 = Integer.parseInt(S5);

        S6= cnpj.substring(7, 8); N6 = Integer.parseInt(S6);
        S7= cnpj.substring(8, 9); N7 = Integer.parseInt(S7);
        S8= cnpj.substring(9, 10); N8 = Integer.parseInt(S8);

        S9= cnpj.substring(11, 12); N9 = Integer.parseInt(S9);
        S10= cnpj.substring(12, 13); N10 = Integer.parseInt(S10);
        S11= cnpj.substring(13, 14); N11 = Integer.parseInt(S11);
        S12= cnpj.substring(14, 15); N12 = Integer.parseInt(S12);

        verificador1 = (N12 * 2 + N11 * 3 + N10 * 4 + N9 * 5 + N8 * 6 + N7 * 7 + N6 * 8 + N5 * 9 + N4 * 2 + N3 * 3 + N2 * 4 + N1 * 5);
        if ((verificador1 % 11) < 2)
            verificador1 = 0;
        else
            verificador1 = 11 - (verificador1 % 11);

        verificador2 = (verificador1 * 2 + N12 * 3 + N11 * 4 + N10 * 5 + N9 * 6 + N8 * 7 + N7 * 8 + N6 * 9 + N5 * 2 + N4 * 3 + N3 * 4 + N2 * 5 + N1 * 6);
        if ((verificador2 % 11) < 2)
            verificador2 = 0;
        else
            verificador2 = 11 - (verificador2 % 11);

        confere = (S1 + S2 + "." + S3 + S4 + S5 + "." + S6 + S7 + S8 + "/" + S9 + S10 + S11 + S12 + "-" + verificador1+""+verificador2);


        if (confere.equals(cnpj) ){
            return true;
        }
        else
            return false;

    }
    public static boolean verificadorCep(String cep) {

        ServicoDeCep servico = new ServicoDeCep();
        try {
            ServicoDeCep.buscaEnderecoPelo(cep);
        } catch (Exception e) {
            
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
