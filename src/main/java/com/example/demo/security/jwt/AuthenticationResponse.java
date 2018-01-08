package com.example.demo.security.jwt;

public class AuthenticationResponse {

    String token;

    public AuthenticationResponse(){}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
