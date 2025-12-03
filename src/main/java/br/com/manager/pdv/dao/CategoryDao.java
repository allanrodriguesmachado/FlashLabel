package br.com.manager.pdv.dao;

import br.com.manager.pdv.model.entity.Category;
import br.com.manager.pdv.util.DatabaseFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    public void create(Category category) throws SQLException {
        try (Connection conn = DatabaseFactory.getConnection()) {
            String SQL = "INSERT INTO categories (name) VALUES (?)";
            var stmt = conn.prepareStatement(SQL);
            stmt.setString(1, category.name());
            stmt.executeUpdate();
        }
    }

    public List<Category> list() throws SQLException {
        List<Category> categories = new ArrayList<>();
        try (Connection conn = DatabaseFactory.getConnection()) {
            String SQL = "SELECT id, name FROM categories WHERE active = true";
            var stmt = conn.prepareStatement(SQL);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category(id, name);
                categories.add(category);
            }
        }

        return categories;
    }

    public void delete(Integer id) throws SQLException {
        try(Connection conn = DatabaseFactory.getConnection()) {
            var stmt = conn.prepareStatement("UPDATE categories SET active = false WHERE id = ?");

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
