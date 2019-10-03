package com.example.pklloginregister.apihelper;

import com.example.pklloginregister.user;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface BaseApiService {

    // Fungsi ini untuk memanggil API

    @FormUrlEncoded
    @POST("/api/auth/login")
    Call<ResponseBody> loginRequest(@Field("email") String email,
                                           @Field("password") String password,
                                           @Field("remember_me") Boolean remember);


    // Fungsi ini untuk memanggil API

    @FormUrlEncoded
    @POST("/api/auth/signup")
    Call<user> registerRequest(@Header("Content-Type") String content_type,
                               @Header("X-Requested-With") String requested,
                               @Field("name") String nama,
                               @Field("email") String email,
                               @Field("password") String password,
                               @Field("password_confirmation") String password2);
}

