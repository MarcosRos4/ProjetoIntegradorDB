package ProjetoIntegrador.viacep.servico;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import ProjetoIntegrador.viacep.Util;
import ProjetoIntegrador.viacep.dominio.Endereco;

public class ServicoDeCep {
    static String webService = "http://viacep.com.br/ws/";
    static int codigoSucesso = 200;

    public static Endereco buscaEnderecoPelo(String cep) throws Exception {
        String urlParaChamada = webService + cep + "/json";

        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = Util.converteJsonEmString(resposta);

            Gson gson = new Gson();
            Endereco endereco = gson.fromJson(jsonEmString, Endereco.class);

            return endereco;
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
    }

    public static void main(String[] args) {
        try{
            Endereco poggers= ServicoDeCep.buscaEnderecoPelo("04794000");
            System.out.println(poggers.getCep());
            System.out.println(poggers.getLocalidade());
            System.out.println(poggers.getLogradouro());
            System.out.println(poggers.getBairro());
            System.out.println(poggers.getUf());
            System.out.println(poggers.getComplemento());
        }
        catch(Exception e){System.out.println(e.getMessage());}
        
    }
}
