package br.com.erick.erickviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.erick.erickviagens.R;
import br.com.erick.erickviagens.dao.PacoteDAO;
import br.com.erick.erickviagens.model.Pacote;
import br.com.erick.erickviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITLO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITLO_APPBAR);

        configuraLista();
    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}