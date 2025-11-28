package br.com.manager.pdv.service;

import br.com.manager.pdv.dao.UserDao;
import br.com.manager.pdv.model.entity.User;

import java.sql.SQLException;

public class UserService {
    private final UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public void register(String firstName, String lastName) throws SQLException {
        User newUser = new User(firstName, lastName);
        userDao.create(newUser);
    }
}

