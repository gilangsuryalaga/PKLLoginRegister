package com.example.pklloginregister.apihelper;

public class UtilsApi {
    public static final String BASE_URL_API = "http://192.168.1.7:8000";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
