package br.com.manager.pdv.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private static final Properties props = new Properties();

    static {
        try (InputStream input = AppConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
            props.load(input);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
