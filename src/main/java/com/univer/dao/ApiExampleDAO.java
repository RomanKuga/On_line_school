package com.univer.dao;

import com.univer.models.ApiExample;
import com.univer.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApiExampleDAO {

    public List<ApiExample> getApiExamplesBySectionId(int sectionId) {
        List<ApiExample> apiExamples = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM api_examples WHERE section_id = ?";
            PreparedStatement statement = ((Connection) connection).prepareStatement(sql);
            statement.setInt(1, sectionId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String codeSnippet = resultSet.getString("code_snippet");

                ApiExample apiExample = new ApiExample(id, sectionId, title, codeSnippet);
                apiExamples.add(apiExample);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apiExamples;
    }

    public void insertApiExample(ApiExample apiExample) {
    }
}
