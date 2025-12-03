package br.com.manager.pdv.service;

import br.com.manager.pdv.dao.CategoryDao;
import br.com.manager.pdv.model.entity.Category;

import java.sql.SQLException;
import java.util.List;

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

    public List<Category> list() {
        try {
            return categoryDao.list();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(Integer id) {
        try {
             categoryDao.delete(id);
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void update(Integer id, String name) {
        try {
            categoryDao.update(id, name);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
