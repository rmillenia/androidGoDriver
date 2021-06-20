package com.example.meli.projectdriver.apihelper;

public class UtilsApi {
    public static final String BASE_URL_API = "http://10.0.2.2/rinda-enterprise/login/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
