package com.univer.dao;

import com.univer.models.AddMaterial;
import com.univer.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApiAddMaterial {
    public List<AddMaterial> getAllApiAddMaterial() {
        List<AddMaterial> apiAddMaterial = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM addmaterial";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idaddMaterial = resultSet.getInt("idaddMaterial");
                String nameAddMaterial = resultSet.getString("nameAddMaterial");
                int idLecture = resultSet.getInt("idLecture");
                String resourceType = resultSet.getString("resourseType");
                String task = null;
                AddMaterial addMaterial = new AddMaterial(idaddMaterial,nameAddMaterial, idLecture, resourceType,task);

                apiAddMaterial.add(addMaterial);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apiAddMaterial;
    }

    public List<AddMaterial> getSortApiAddMaterialResource() {
        List<AddMaterial> apiAddMaterial = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT  addmaterial.resourseType, count(*) as Number FROM addmaterial Group by resourseType;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String resourceType = resultSet.getString("resourseType");
                int numberResource = resultSet.getInt("Number");
                AddMaterial addMaterial = new AddMaterial( resourceType,numberResource);

                apiAddMaterial.add(addMaterial);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apiAddMaterial;
    }
}
