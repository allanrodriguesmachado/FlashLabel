package br.com.bank.model;

public class AuthModel {
    public boolean  authentication(String document, String password) {
        return "admin".equals(document) && "pass".equals(password);
    }
}
