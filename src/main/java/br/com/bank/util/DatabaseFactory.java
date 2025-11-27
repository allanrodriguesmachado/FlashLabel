package br.com.bank.util;

import br.com.bank.config.AppConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseFactory {
    public static Connection getConnection() throws SQLException {
        String url = AppConfig.get("db.url");
        String username = AppConfig.get("db.username");
        String password = AppConfig.get("db.password");
        return DriverManager.getConnection(url, username, password);
    }
}
