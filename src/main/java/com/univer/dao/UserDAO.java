package com.univer.dao;


import com.univer.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDAO {

    public Optional<String> findByUsername(String username, String password) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT username FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
resultSet.next();
            String login = resultSet.getString("username");

            if(login != null) {
                return Optional.of(login);
            }

            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
