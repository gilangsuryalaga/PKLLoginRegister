package com.example.pklloginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pklloginregister.apihelper.BaseApiService;
import com.example.pklloginregister.apihelper.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText editnama,editemail,editpassword,editpassword2;
    Button btnregister;

    Context mContext;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        initComponents();

    }

    private void initComponents() {

        editnama = (EditText) findViewById(R.id.editusername);
        editemail = (EditText) findViewById(R.id.editemail);
        editpassword = (EditText) findViewById(R.id.editpassword);
        editpassword2 = (EditText) findViewById(R.id.editpassword2);
        btnregister = (Button) findViewById(R.id.btnregister);



        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestRegister();
            }

            String nama = editnama.getText().toString();
            String email = editemail.getText().toString();
            String pass = editpassword.getText().toString();
            String pass2 = editpassword2.getText().toString();

            private void requestRegister() {
                mApiService.registerRequest("application/json","XMLHttpRequest",nama,email,pass,pass2)
                        .enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                if (response.isSuccessful()){
                                    Log.i("debug", "onResponse: BERHASIL");

                                    try {
                                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                        if (jsonRESULTS.getString("message").equals("Berhasil Membuat User!")){
                                            Toast.makeText(mContext, "BERHASIL REGISTRASI", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(mContext, MainActivity.class));
                                        } else {
                                            String error_message = jsonRESULTS.getString("error_msg");
                                            Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    Log.i("debug", "onResponse: GA BERHASIL");
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Log.e("debug", "onFailure: ERROR > " + t.getMessage());
                                Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
