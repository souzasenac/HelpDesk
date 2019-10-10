package br.senac.es.helpdesk.API;

public class ApiUtils {

    private ApiUtils(){}

    public static final String BASE_URL = "http://10.0.2.2:8080/";

    public static APIService getService(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}

