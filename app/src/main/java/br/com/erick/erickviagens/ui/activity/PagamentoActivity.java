package br.com.erick.erickviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.erick.erickviagens.R;
import br.com.erick.erickviagens.model.Pacote;
import br.com.erick.erickviagens.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);

        Intent intent = getIntent();
        if(intent.hasExtra("pacote")){
            final Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");

            mostraPreco(pacote);

            Button botaofinalizaCompra = findViewById(R.id.pagamento_botao_finalizar_compra);
            botaofinalizaCompra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);

                    intent.putExtra("pacote", pacote);
                    startActivity(intent);
                }
            });
        }



    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}