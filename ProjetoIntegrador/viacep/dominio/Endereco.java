package ProjetoIntegrador.viacep.dominio;

public class Endereco {
    String logradouro, bairro, localidade, cep, complemento, uf;


    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    @Override
    public String toString() {
        return String.format("Endereço { CEP: %s, Logradouro: %s, Complemento: %s, Bairro: %s, Localidade: %s, UF: %s}",
        cep, logradouro, complemento, bairro, localidade, uf);
    }

    public String getCep() {
        return cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getUf() {
        return uf;
    }
}
