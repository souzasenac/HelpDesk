package br.senac.es.helpdesk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import br.senac.es.helpdesk.API.ChamadoTask;
import br.senac.es.helpdesk.API.OnEventListener;
import br.senac.es.helpdesk.model.Chamados;


public class Tab2Fragment extends Fragment {
        ListView listViewMensagensEnviadas;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

              final  View view = inflater.inflate(R.layout.fragment_2, container, false);


                final ChamadoTask chamadoTask = new ChamadoTask(view.getContext(), new OnEventListener<String>() {
                        @Override
                        public void onSuccess(String result){
                                Toast.makeText(view.getContext(),"SUCCESS" , Toast.LENGTH_LONG).show();
                                Gson gson = new Gson();
                                Chamados[] chamados = gson.fromJson(result, Chamados[].class);
                                List<Chamados> chamadosFechado = new ArrayList<Chamados>();
                                for (Chamados chamado: chamados){
                                        if(chamado.getStatus().toLowerCase().equals("fechado")){
                                                chamadosFechado.add(chamado);
                                        }
                                }

                                ArrayAdapter<Chamados> adapter = new ArrayAdapter<Chamados>(getActivity(),android.R.layout.simple_list_item_1,chamadosFechado);
                                listViewMensagensEnviadas = (ListView) view.findViewById(R.id.listaFechado);
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

