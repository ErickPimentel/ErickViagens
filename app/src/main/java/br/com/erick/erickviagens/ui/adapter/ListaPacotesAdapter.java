package br.com.erick.erickviagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.erick.erickviagens.R;
import br.com.erick.erickviagens.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context){
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int posicao, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(posicao);

        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());

        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDoDrawable);
        imagem.setImageDrawable(drawableImagemPacote);

        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = "";
        int quantidadeDeDias = pacote.getDias();
        if (quantidadeDeDias > 1){
            diasEmTexto = quantidadeDeDias + " dias";
        }else{
            diasEmTexto = quantidadeDeDias + " dia";
        }
        dias.setText(diasEmTexto);

        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        BigDecimal precoDoPacote = pacote.getPreco();
        String moedaBrasileira = formatoBrasileiro.format(precoDoPacote);

        preco.setText(moedaBrasileira);

        return viewCriada;
    }
}
