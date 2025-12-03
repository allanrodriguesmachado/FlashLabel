package br.com.manager.pdv.dao;

import br.com.manager.pdv.model.entity.Auth;
import br.com.manager.pdv.model.entity.User;
import br.com.manager.pdv.util.DatabaseFactory;

import java.sql.*;

public class UserDao {
    public void create(User user) throws SQLException {
        try (Connection conn = DatabaseFactory.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (first_name, last_name) VALUES (?, ?)");
            stmt.setString(1, user.firstName());
            stmt.setString(2, user.lastName());
            stmt.executeUpdate();
        }
    }

    public boolean authenticated(Auth auth) throws SQLException{
        String SQL = "SELECT * FROM users WHERE username = ? AND password = ? AND active = true";

        try (Connection conn = DatabaseFactory.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(SQL);

            stmt.setString(1, auth.username());
            stmt.setString(2, auth.password());

            try (ResultSet rs = stmt.executeQuery()) {
               return rs.next();
            }
        }
    }
}
