package com.univer.dao;

import com.univer.models.Lecture;
import com.univer.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApiLectureDAO {
    public List<Lecture> getAllApiLecture() {
        List<Lecture> apiLecture = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM lecture";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idLecture = resultSet.getInt("idLecture");
                int idCourse = resultSet.getInt("idCourse");
                String name = resultSet.getString("name");
                int idPerson = resultSet.getInt("idPerson");
                String description = resultSet.getString("description");
                String dateTime = resultSet.getString("dateTime");

                Lecture lecture = new Lecture(idLecture, idCourse, name, idPerson, description, dateTime);

                apiLecture.add(lecture);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apiLecture;
    }

    public List<Lecture> getApiLectureId(int lectureSectionId) {
        List<Lecture> apiLecture = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM lecture WHERE idLecture = ?";
            PreparedStatement statement =  connection.prepareStatement(sql);
            statement.setInt(1, lectureSectionId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idLecture = resultSet.getInt("idLecture");
                int idCourse = resultSet.getInt("idCourse");
                String name = resultSet.getString("name");
                int idPerson = resultSet.getInt("idPerson");
                String description = resultSet.getString("description");
                String dateTime = resultSet.getString("dateTime");

                Lecture lecture = new Lecture(idLecture, idCourse, name, idPerson, description, dateTime);

                apiLecture.add(lecture);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apiLecture;
    }
    public List<Lecture> getApiLectureCourseId(int lectureSectionId) {
        List<Lecture> apiLecture = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM lecture WHERE idCourse = ?";
            PreparedStatement statement =  connection.prepareStatement(sql);
            statement.setInt(1, lectureSectionId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idLecture = resultSet.getInt("idLecture");
                int idCourse = resultSet.getInt("idCourse");
                String name = resultSet.getString("name");
                int idPerson = resultSet.getInt("idPerson");
                String description = resultSet.getString("description");
                String dateTime = resultSet.getString("dateTime");

                Lecture lecture = new Lecture(idLecture, idCourse, name, idPerson, description, dateTime);

                apiLecture.add(lecture);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apiLecture;
    }

    public List<Lecture> getSortApiLectureName() {
        List<Lecture> apiLecture = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = " SELECT lecture.idLecture,lecture.name,lecture.dateTime, count(addmaterial.idLecture) as NumberAddMaterial " +
                    " FROM lecture" +
                    " Inner join addmaterial on lecture.idLecture=addmaterial.idLecture" +
                    " where date(dateTime)<'2023-01-01'" +
                    " group by addmaterial.idLecture" +
                    " order by dateTime;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idLecture = resultSet.getInt("idLecture");
                String name = resultSet.getString("name");
                String dateTime = resultSet.getString("dateTime");
                int numberAddMaterial = resultSet.getInt("NumberAddMaterial");
                Lecture lecture = new Lecture( idLecture,name, dateTime,numberAddMaterial);

                apiLecture.add(lecture);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apiLecture;
    }
    public List<Lecture> getSortApiLectureHomeWork() {
        List<Lecture> apiLecture = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = " SELECT on_line_school.lecture.idLecture,on_line_school.lecture.name,on_line_school.lecture.dateTime, count(on_line_school.homework.idLecture) as NumberHomeWork" +
                    "  FROM on_line_school.lecture" +
                    "  Inner join on_line_school.homework on on_line_school.lecture.idLecture=on_line_school.homework.idLecture" +
                    "  where dateTime=all(SELECT min(dateTime) from on_line_school.lecture)" +
                    "  group by on_line_school.homework.idLecture" +
                    "  order by dateTime;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idLecture = resultSet.getInt("idLecture");
                String name = resultSet.getString("name");
                String dateTime = resultSet.getString("dateTime");
                int numberHomeWork = resultSet.getInt("NumberHomeWork");
                Lecture lecture = new Lecture( idLecture,name, dateTime,numberHomeWork);

                apiLecture.add(lecture);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apiLecture;
    }
    public void insertApiLecture(Lecture lecture) {

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO lecture (idLecture,idCourse,name,idPerson,description,dateTime) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, lecture.getID());
            statement.setInt(2, lecture.getCourseID());
            statement.setString(3, lecture.getName());
            statement.setInt(4,lecture.getPersonId());
            statement.setString(5, lecture.getDescription());
            statement.setString(6, lecture.getHoldingTimeString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
