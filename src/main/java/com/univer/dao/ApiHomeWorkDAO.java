package com.univer.dao;

import com.univer.models.HomeWork;
import com.univer.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApiHomeWorkDAO {
    public List<HomeWork> getAllApiHomeWork() {
        List<HomeWork> apiHomeWork = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM homework";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idhomeWork = resultSet.getInt("idhomeWork");
                int idLecture = resultSet.getInt("idLecture");
                String task = resultSet.getString("task");
                HomeWork homeWork = new HomeWork(idhomeWork, idLecture, task);

                apiHomeWork.add(homeWork);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apiHomeWork;
    }
}
