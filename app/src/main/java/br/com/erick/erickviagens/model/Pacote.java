package br.com.erick.erickviagens.model;

import java.io.Serializable;
import java.math.BigDecimal;

//A interface Serializable serve para mandar um pacote de uma activity para outra activity
public class Pacote implements Serializable {

    private final String local;
    private final String imagem;
    private final int dias;
    private final BigDecimal preco;

    public Pacote(String local, String imagem, int dias, BigDecimal preco) {
        this.local = local;
        this.imagem = imagem;
        this.dias = dias;
        this.preco = preco;
    }

    public String getLocal() {
        return local;
    }

    public String getImagem() {
        return imagem;
    }

    public int getDias() {
        return dias;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
