package br.com.manager.pdv.service;

import br.com.manager.pdv.dao.CategoryDao;
import br.com.manager.pdv.model.entity.Category;

import java.sql.SQLException;

public class CategoryService {
    private final CategoryDao categoryDao;

    public CategoryService() {
        this.categoryDao = new CategoryDao();
    }

    public void create(String name) {
        try {
            Category newCategory = new Category(name);
            categoryDao.create(newCategory);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
