package com.example.demo.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class NewTokenResponse {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("expirationDate")
    @Expose
    private Date expirationDate;
    @SerializedName("username")
    @Expose
    private String username;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public NewTokenResponse(String token, Date expirationDate, String username) {
        this.token = token;
        this.expirationDate = expirationDate;
        this.username = username;
    }
    public NewTokenResponse() {
    }

    @Override
    public String toString() {
        return "NewTokenResponse{" +
                "token='" + token + '\'' +
                ", expirationDate=" + expirationDate +
                ", username='" + username + '\'' +
                '}';
    }
}

