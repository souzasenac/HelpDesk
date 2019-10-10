package br.senac.es.helpdesk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import br.senac.es.helpdesk.API.ChamadoTask;
import br.senac.es.helpdesk.API.OnEventListener;
import br.senac.es.helpdesk.model.Chamados;

public class Tab1Fragment extends Fragment {
    ListView listViewMensagensEnviadas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_1, container, false);
        FloatingActionButton save = (FloatingActionButton) view.findViewById(R.id.botaofloat1);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ChamadoTask chamadoTask = new ChamadoTask(view.getContext(), new OnEventListener<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Toast.makeText(view.getContext(), "Lista atualizada", Toast.LENGTH_LONG).show();
                        Gson gson = new Gson();
                        Chamados[] chamados = gson.fromJson(result, Chamados[].class);
                        List<Chamados> chamadosAbertos = new ArrayList<Chamados>();
                        for (Chamados chamado : chamados) {
                            if (chamado.getStatus().toLowerCase().equals("aberto")) {
                                chamadosAbertos.add(chamado);
                            }
                        }

                        ArrayAdapter<Chamados> adapter = new ArrayAdapter<Chamados>(getActivity(), android.R.layout.simple_list_item_1, chamadosAbertos);
                        listViewMensagensEnviadas = (ListView) view.findViewById(R.id.lista);
                        listViewMensagensEnviadas.setAdapter(adapter);

                        //Chamados[] chamadosAbertos = gson.fromJson(result, Chamados[].class);

                    }

                    public void onFailure(Exception e) {
                        Toast.makeText(view.getContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
                chamadoTask.execute();
            }
        });


        final ChamadoTask chamadoTask = new ChamadoTask(view.getContext(), new OnEventListener<String>() {
            @Override
            public void onSuccess(String result) {
                Toast.makeText(view.getContext(), "SUCCESS", Toast.LENGTH_LONG).show();
                Gson gson = new Gson();
                Chamados[] chamados = gson.fromJson(result, Chamados[].class);
                List<Chamados> chamadosAbertos = new ArrayList<Chamados>();
                for (Chamados chamado : chamados) {
                    if (chamado.getStatus().toLowerCase().equals("aberto")) {
                        chamadosAbertos.add(chamado);
                    }
                }

                ArrayAdapter<Chamados> adapter = new ArrayAdapter<Chamados>(getActivity(), android.R.layout.simple_list_item_1, chamadosAbertos);
                listViewMensagensEnviadas = (ListView) view.findViewById(R.id.lista);
                listViewMensagensEnviadas.setAdapter(adapter);

                //Chamados[] chamadosAbertos = gson.fromJson(result, Chamados[].class);

            }

            public void onFailure(Exception e) {
                Toast.makeText(view.getContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        chamadoTask.execute();
        return view;
    }
}














      /* FloatingActionButton save = (FloatingActionButton) view.findViewById(R.id.botaofloat1) ;
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proximo = new Intent(getActivity(),Descricao.class);

                getActivity().startActivity(proximo);
            }
        });
        listaTela = (ListView) view.findViewById(R.id.lista);

        List<Mensagem> mensagens = new ArrayList<Mensagem>();
        List<Mensagem> mensagensAberto = new ArrayList<Mensagem>();


        mensagens.add(new Mensagem(1L, "reparo de pc", Status.ENVIADA));
        mensagens.add(new Mensagem(2L, "chatuba", Status.NAOENVIADA));
        mensagens.add(new Mensagem(3L, "aloo", Status.ENVIADA));
        mensagens.add(new Mensagem(4L, "mensagem 5", Status.ENVIADA));
        mensagens.add(new Mensagem(5L, "reparo de peça", Status.NAOENVIADA));
        mensagens.add(new Mensagem(6L, "jkdhsf", Status.ENVIADA));

  for (Chamados chamado: chamados){
                if(chamado.getStatus().toLowerCase().equals("fechado")){

                }
        for (int i = 0; i < mensagens.size(); i++) {
            if (mensagens.get(i).getStatus().equals((Status.NAOENVIADA))) {

                mensagensAberto.add(mensagens.get(i));
            }

        }
        ArrayAdapter<Mensagem> adapter = new ArrayAdapter<Mensagem>(getActivity(), android.R.layout.simple_list_item_1, mensagensAberto);
        listaTela.setAdapter(adapter);


        return view;
    }
*/


