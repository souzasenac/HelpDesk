package br.senac.es.helpdesk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArrayMap;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import br.senac.es.helpdesk.API.APIService;
import br.senac.es.helpdesk.API.ApiUtils;
import br.senac.es.helpdesk.model.Chamados;
import br.senac.es.helpdesk.model.Status;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class newChamado extends AppCompatActivity {

    private APIService mAPIService;
    private TextView mResponseTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_chamado);

        final EditText edtChamado = (EditText) findViewById(R.id.edt_chamado);
        Button btnEnviarChamado= (Button) findViewById(R.id.btn_enviar_chamado);

        mAPIService = ApiUtils.getService();

        btnEnviarChamado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String descricao = edtChamado.getText().toString().trim();
               Chamados chamados = new Chamados();
                chamados.setDecricao(descricao);
                if (!TextUtils.isEmpty(descricao)) {
                    enviarChamado(chamados, getApplicationContext());
                }


            }
        });
    }

    public void enviarChamado(Chamados chamado, final Context context) {
        SimpleDateFormat frm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date dataAbertura = new Date();
        mAPIService = ApiUtils.getService();

        Map<String, String> jsonParams = new ArrayMap<>();
        jsonParams.put("descricao",chamado.getDecricao() );
        jsonParams.put("status", Status.ABERTO.toString() );
        jsonParams.put("dataAbertura", frm.format(dataAbertura.getTime()));

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),(new JSONObject(jsonParams)).toString());

        Call<ResponseBody> response = mAPIService.salvarChamado(body);

        response.enqueue(new Callback<ResponseBody>()
        {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse)
            {
                try
                {
                    Toast.makeText(context, "Chamado Enviado com sucesso!!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(newChamado.this, TabsActivity.class);
                    startActivity(intent);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable)
            {
                // other stuff...
                Toast.makeText(context, "O Envio da mensagem falhou!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
