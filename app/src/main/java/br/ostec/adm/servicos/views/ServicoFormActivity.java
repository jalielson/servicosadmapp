package br.ostec.adm.servicos.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.ostec.adm.servicos.daos.ServicoDao;
import br.ostec.adm.servicos.model.Servico;

public class ServicoFormActivity extends AppCompatActivity {

    private EditText etCliente, etEndereco, etFone, etDispositivo, etObsdispositivo, etServico, etValor;
    private Button btSalvar;
    private Servico servico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico_form);
        inicializarComponentes();
        definirEventos();
    }



    private void incluir(){

        ServicoDao dao = new ServicoDao(this);

        servico.setCliente(etCliente.getText().toString());
        servico.setEndereco(etEndereco.getText().toString());
        servico.setFone(etFone.getText().toString());
        servico.setDispositivo(etDispositivo.getText().toString());
        servico.setObsdisp(etObsdispositivo.getText().toString());
        servico.setServico(etServico.getText().toString());
        servico.setValor(etValor.getText().toString());

        if(servico.getId() == null) {
            dao.inserir(servico);
        } else {
            dao.editar(servico);
        }
        finish();

        //Intent intentChamalista = new Intent(this, ServicoListaActivity.class);
        //startActivity(intentChamalista);
    }

    private void limparform(){
        etCliente.setText("");
        etEndereco.setText("");
        etFone.setText("");
        etDispositivo.setText("");
        etObsdispositivo.setText("");
        etServico.setText("");
        etValor.setText("");
    }

    private void definirEventos() {
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incluir();
            }
        });
    }

    private void inicializarComponentes() {
        etCliente = (EditText) findViewById(R.id.cliente);
        etEndereco = (EditText) findViewById(R.id.endereco);
        etFone = (EditText) findViewById(R.id.fone);
        etDispositivo = (EditText) findViewById(R.id.dispositivo);
        etObsdispositivo = (EditText) findViewById(R.id.obsdispositivo);
        etServico = (EditText) findViewById(R.id.servico);
        etValor = (EditText) findViewById(R.id.valor);
        btSalvar = findViewById(R.id.salvar);

        Intent intent = getIntent();
        servico = (Servico) intent.getSerializableExtra("servico");
        if(servico != null) {
            preencherCampos(servico);
        } else {
            servico = new Servico();
        }
    }

    private void preencherCampos(Servico servico){
        etCliente.setText(servico.getCliente());
        etEndereco.setText(servico.getEndereco());
        etFone.setText(servico.getFone());
        etDispositivo.setText(servico.getDispositivo());
        etObsdispositivo.setText(servico.getObsdisp());
        etServico.setText(servico.getServico());
        etValor.setText(servico.getValor());
    }
}
