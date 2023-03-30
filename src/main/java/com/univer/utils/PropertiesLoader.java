package com.univer.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesLoader {
    private static Properties properties;

    static {
        properties = new Properties();

//            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//            URI resurceURI = Objects.requireNonNull(classLoader.getResource("/application.properties")).toURI();
//            Path path = Paths.get(resurceURI);

        //ServletContext context = getServletContext();

        Path path = Paths.get("D:\\Java_Projects\\On_line_school\\src\\main\\webapp\\resources\\application.properties");

        try (InputStream input = Files.newInputStream(path)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load application.properties file.");
        }
    }

    private PropertiesLoader() {
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
