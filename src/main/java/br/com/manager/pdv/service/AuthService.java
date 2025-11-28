package br.com.manager.pdv.service;

import br.com.manager.pdv.dao.UserDao;
import br.com.manager.pdv.model.entity.Auth;

import java.sql.SQLException;

public class AuthService {
    private final UserDao userDao;

    public AuthService() {
        this.userDao = new UserDao();
    }

    public boolean authenticate(String document, String password)  {
        try {
            Auth newAuth = new Auth(document, password);
            return userDao.authenticated(newAuth);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
