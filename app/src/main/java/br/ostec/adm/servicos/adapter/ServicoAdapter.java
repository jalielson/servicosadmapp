package br.ostec.adm.servicos.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.ostec.adm.servicos.model.Servico;
import br.ostec.adm.servicos.views.R;

public class ServicoAdapter extends BaseAdapter {

    private List<Servico> servicos;
    private Context context;

    public ServicoAdapter(Context context, List<Servico> servicos) {
        this.servicos = servicos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.servicos.size();
    }

    @Override
    public Object getItem(int posicao) {
        return this.servicos.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return this.servicos.get(posicao).getId();
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View quadro = inflater.inflate(R.layout.item_lista, null);

        TextView campoCliente = (TextView) quadro.findViewById(R.id.lista_cliente);
        TextView campoFone = (TextView) quadro.findViewById(R.id.lista_fone);
        TextView campoDispositivo = (TextView) quadro.findViewById(R.id.lista_dispositivo);

        Servico servico = (Servico) getItem(posicao);

        campoCliente.setText(servico.getCliente());
        campoFone.setText(servico.getFone());
        campoDispositivo.setText(servico.getDispositivo());

        return quadro;
    }
}
