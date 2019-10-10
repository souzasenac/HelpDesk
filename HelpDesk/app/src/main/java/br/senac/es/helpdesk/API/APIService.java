package br.senac.es.helpdesk.API;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

    @POST("chamados")
    Call<ResponseBody> salvarChamado(@Body RequestBody body);
}
