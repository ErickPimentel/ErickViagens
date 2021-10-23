package br.com.erick.erickviagens.util;

import androidx.annotation.NonNull;

import br.com.erick.erickviagens.model.Pacote;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    @NonNull
    public static String formataEmTexto(int quantidadeDeDias) {
        if (quantidadeDeDias > 1){
            return quantidadeDeDias + PLURAL;
        }
        return quantidadeDeDias + SINGULAR;
    }


}
