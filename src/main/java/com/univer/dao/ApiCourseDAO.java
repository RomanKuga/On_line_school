package com.univer.dao;


import com.univer.models.Course;
import com.univer.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApiCourseDAO {

    public List<Course> getAllApiCourse() {
        List<Course> apiCourse = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM course";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idCourse");
                String title = resultSet.getString("Course_name");


                Course apiSection = new Course(id, title);
                apiCourse.add(apiSection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apiCourse;
    }


    public void insertApiSection(Course course) {
        //generate this method
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO course (id,title) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, course.getCourseID());
            statement.setString(2, course.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
