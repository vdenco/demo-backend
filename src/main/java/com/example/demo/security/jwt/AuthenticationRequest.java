package com.example.demo.security.jwt;

public class AuthenticationRequest {

    String login;
    String password;

    public AuthenticationRequest(){}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
