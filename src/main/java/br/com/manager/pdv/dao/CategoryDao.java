package br.com.manager.pdv.dao;

import br.com.manager.pdv.model.entity.Category;
import br.com.manager.pdv.util.DatabaseFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class CategoryDao {
    public void create(Category category) throws SQLException {
        try (Connection conn = DatabaseFactory.getConnection()) {
            String SQL = "INSERT INTO categories (name) VALUES (?)";
            var stmt = conn.prepareStatement(SQL);

            stmt.setString(1, category.name());

            stmt.executeUpdate();
        }
    }
}
