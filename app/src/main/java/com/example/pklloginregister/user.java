package com.example.pklloginregister;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class user {
    @SerializedName("name")
    @Expose
    private String nama;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("password_confirmation")
    @Expose
    private String password2;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public String toString(){
        return "Post(" + "name='"+ nama + '\'' +
                ", email='" +email+ '\''+
                ",password=" +password+ '\''+
                ",password_confirmation=" +password2+'}';
    }
}
