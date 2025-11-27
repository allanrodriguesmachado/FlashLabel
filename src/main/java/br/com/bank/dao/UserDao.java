package br.com.bank.dao;

import br.com.bank.model.entity.User;
import br.com.bank.util.DatabaseFactory;

import java.sql.*;

public class UserDao {
    public void create(User user) throws SQLException {
        try (Connection conn = DatabaseFactory.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (first_name, last_name) VALUES (?, ?)");

            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());

            stmt.executeUpdate();
        }
    }
}
