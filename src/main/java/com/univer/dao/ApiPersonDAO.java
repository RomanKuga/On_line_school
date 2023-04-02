package com.univer.dao;

import com.univer.models.Person;
import com.univer.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApiPersonDAO {
    public List<Person> getAllApiLPerson() {
        List<Person> apiPerson = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM person";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idPerson = resultSet.getInt("idPerson");
                int idCourse = resultSet.getInt("idCourse");
                String roleString = resultSet.getString("role");
                String firstname = resultSet.getString("firstname");
                String secondName = resultSet.getString("secondName");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");

                Person person = new Person(idPerson, idCourse, roleString, firstname,secondName, phone, email);

                apiPerson.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apiPerson;
    }

    public List<Person> getApiPersonId(int personId) {
        List<Person> apiPerson = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM person WHERE idPerson = ?";
            PreparedStatement statement =  connection.prepareStatement(sql);
            statement.setInt(1, personId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idPerson = resultSet.getInt("idPerson");
                int idCourse = resultSet.getInt("idCourse");
                String roleString = resultSet.getString("role");
                String firstname = resultSet.getString("firstname");
                String secondName = resultSet.getString("secondName");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");

                Person person = new Person(idPerson, idCourse, roleString, firstname,secondName, phone, email);

                apiPerson.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apiPerson;
    }
    public List<Person> getApiPersonCourseId(int personId) {
        List<Person> apiPerson = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM person WHERE idCourse = ?";
            PreparedStatement statement =  connection.prepareStatement(sql);
            statement.setInt(1, personId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idPerson = resultSet.getInt("idPerson");
                int idCourse = resultSet.getInt("idCourse");
                String roleString = resultSet.getString("role");
                String firstname = resultSet.getString("firstname");
                String secondName = resultSet.getString("secondName");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");

                Person person = new Person(idPerson, idCourse, roleString, firstname,secondName, phone, email);

                apiPerson.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apiPerson;
    }
    public List<Person> getSortApiPersonTeacher() {
        List<Person> apiPerson = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM person where role='Teacher' and secondName<'N%'";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idPerson = resultSet.getInt("idPerson");
                int idCourse = resultSet.getInt("idCourse");
                String roleString = resultSet.getString("role");
                String firstname = resultSet.getString("firstname");
                String secondName = resultSet.getString("secondName");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");

                Person person = new Person(idPerson, idCourse, roleString, firstname,secondName, phone, email);

                apiPerson.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apiPerson;
    }
    public List<Person> getSortApiPersonStudent() {
        List<Person> apiPerson = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM person where role='Student' order by secondName";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idPerson = resultSet.getInt("idPerson");
                int idCourse = resultSet.getInt("idCourse");
                String roleString = resultSet.getString("role");
                String firstname = resultSet.getString("firstname");
                String secondName = resultSet.getString("secondName");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");

                Person person = new Person(idPerson, idCourse, roleString, firstname,secondName, phone, email);

                apiPerson.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apiPerson;
    }
}
