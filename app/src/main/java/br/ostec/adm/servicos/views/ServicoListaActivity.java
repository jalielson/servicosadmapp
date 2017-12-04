package br.ostec.adm.servicos.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.ostec.adm.servicos.adapter.ServicoAdapter;
import br.ostec.adm.servicos.daos.ServicoDao;
import br.ostec.adm.servicos.model.Servico;

public class ServicoListaActivity extends AppCompatActivity {

    private ListView lvServicos;
    private Button btAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico_lista);
    }

    protected void onResume(){
        super.onResume();
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes(){
        lvServicos = (ListView) findViewById(R.id.lista_servicos);
        btAdicionar = (Button) findViewById(R.id.adicionar);
        carregaLista();
        registerForContextMenu(lvServicos);
    }

    private void carregaLista(){
        List<Servico> servicos = new ServicoDao(this).buscarTodos();
        ServicoAdapter adapter = new ServicoAdapter(this, servicos);
        lvServicos.setAdapter(adapter);


    }

    private void definirEventos(){
        btAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentChamaFormulario = new Intent(ServicoListaActivity.this, ServicoFormActivity.class);
                startActivity(intentChamaFormulario);
            }
        });
        lvServicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int posicao, long id) {
                Servico servico = (Servico) lvServicos.getItemAtPosition(posicao);
                Intent intentChamaFormulario = new Intent(ServicoListaActivity.this, ServicoFormActivity.class);
                intentChamaFormulario.putExtra("servico", servico);
                startActivity(intentChamaFormulario);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opcoes, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo servicoEscolhido;
        servicoEscolhido = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Servico servico = (Servico) lvServicos.getItemAtPosition(servicoEscolhido.position);
        switch (item.getItemId()){
            case R.id.item_deletar:
                ServicoDao dao = new ServicoDao(this);
                dao.deletar(servico);
                carregaLista();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
