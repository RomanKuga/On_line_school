package com.univer.workBaseSQL;

import com.univer.errorMenuService.ValidationUtil;
import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.log.LogWriter;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;

public class BaseRequestAddMaterial {
    private static final String URL = "jdbc:mysql://localhost/on_line_school";
    private static final String USER = "root";
    private static final String PASSWORD = "qwerty123";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void baseAddMaterialPrintAll() throws  IOException {

        String sql = "{call getBaseAllFields(?)}";

        try (Connection connection = getConnection()) {

            CallableStatement callableStatement = connection.prepareCall(sql);

            callableStatement.setString(Types.CHAR,"addmaterial");


            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                int idAddMaterial = resultSet.getInt("idaddMaterial");
                String nameAddMaterial = resultSet.getString("nameAddMaterial");
                int idLecture = resultSet.getInt("idLecture");
                String resourseType = resultSet.getString("resourseType");
                System.out.println("//  AddMaterials id = " + idAddMaterial + "/  Назва додаткових матеріалів--  " + nameAddMaterial + "/ ID лекції-- " + idLecture + "/ Залучені типи додаткових завдань-- " + resourseType);
            }
        } catch (SQLException e) {
            System.out.println(LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                    "Помилка отримання даних з бази AddMaterial", LocalDateTime.now(),
                    e.getStackTrace()));
        }
    }

    public void openBaseAddMaterialPrintLine() throws  IOException {
        ValidationUtil testing = new ValidationUtil();
        String sqlFirst = "SELECT COUNT(*) FROM on_line_school.addmaterial";

        try (PreparedStatement statement = getConnection().prepareStatement(sqlFirst)) {

            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            int sizeBase = resultSet.getInt(1);
            System.out.println("Ви вибрали відкрити доаткові матеріали, кількість додаткових матеріалів-" + sizeBase +
                    " / ведіть номер доаткові матеріали від 1 до " + sizeBase);
            statement.close();
            int numberPers = testing.testInt();
            if ((numberPers > 0) && (numberPers <= sizeBase)) {
                String sql = "{call getBaseAllFields(?)}";

                try (Connection connection = getConnection()) {

                    CallableStatement callableStatement = connection.prepareCall(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

                    callableStatement.setString(Types.CHAR, "addmaterial");


                    ResultSet resultSetTwo = callableStatement.executeQuery();

                    System.out.println(numberPers);

                    resultSetTwo.absolute(numberPers);

                    int idAddMaterial = resultSetTwo.getInt("idaddMaterial");
                    String nameAddMaterial = resultSetTwo.getString("nameAddMaterial");
                    int idLecture = resultSetTwo.getInt("idLecture");
                    String resourseType = resultSetTwo.getString("resourseType");
                    System.out.println("//  AddMaterials id = " + idAddMaterial + "/  Назва додаткових матеріалів--  " + nameAddMaterial + "/ ID лекції-- " + idLecture + "/ Залучені типи додаткових завдань-- " + resourseType);
                } catch (SQLException e) {
                    System.out.println(LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                            "Помилка отримання даних з бази AddMaterial", LocalDateTime.now(),
                            e.getStackTrace()));
                }
            } else {
                System.out.println("Номер за межами розмірності бази");
            }

        } catch (SQLException e) {
            System.out.println(LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                    "Помилка отримання даних з бази AddMaterial", LocalDateTime.now(),
                    e.getStackTrace()));
        }
    }

        public void sortBaseAddMaterialForLecture() throws  IOException {

        String sql = "SELECT * FROM on_line_school.addmaterial order by idLecture;";

        try (PreparedStatement prepareStatement = getConnection().prepareStatement(sql)) {

            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                int idAddMaterial = resultSet.getInt("idaddMaterial");
                String nameAddMaterial = resultSet.getString("nameAddMaterial");
                int idLecture = resultSet.getInt("idLecture");
                String resourseType = resultSet.getString("resourseType");
                System.out.println("//  AddMaterials id = " + idAddMaterial + "/  Назва додаткових матеріалів--  " + nameAddMaterial + "/ ID лекції-- " + idLecture + "/ Залучені типи додаткових завдань-- " + resourseType);
            }
        } catch (SQLException e) {
            System.out.println(LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                    "Помилка отримання даних з бази AddMaterial", LocalDateTime.now(),
                    e.getStackTrace()));
        }
    }

    public void sortBaseAddMaterialForID() throws  IOException {

        String sql = "SELECT * FROM on_line_school.addmaterial order by idaddMaterial;";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idAddMaterial = resultSet.getInt("idaddMaterial");
                String nameAddMaterial = resultSet.getString("nameAddMaterial");
                int idLecture = resultSet.getInt("idLecture");
                String resourseType = resultSet.getString("resourseType");
                System.out.println("//  AddMaterials id = " + idAddMaterial + "/  Назва додаткових матеріалів--  " + nameAddMaterial + "/ ID лекції-- " + idLecture + "/ Залучені типи додаткових завдань-- " + resourseType);
            }
        } catch (SQLException e) {
            System.out.println(LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                    "Помилка отримання даних з бази AddMaterial", LocalDateTime.now(),
                    e.getStackTrace()));
        }
    }

    public void sortBaseAddMaterialForResourseType() throws  IOException {

        String sql = "SELECT * FROM on_line_school.addmaterial order by resourseType;";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idAddMaterial = resultSet.getInt("idaddMaterial");
                String nameAddMaterial = resultSet.getString("nameAddMaterial");
                int idLecture = resultSet.getInt("idLecture");
                String resourseType = resultSet.getString("resourseType");
                System.out.println("//  AddMaterials id = " + idAddMaterial + "/  Назва додаткових матеріалів--  " + nameAddMaterial + "/ ID лекції-- " + idLecture + "/ Залучені типи додаткових завдань-- " + resourseType);
            }
        } catch (SQLException e) {
            System.out.println(LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                    "Помилка отримання даних з бази AddMaterial", LocalDateTime.now(),
                    e.getStackTrace()));
        }
    }

    public void addBaseAddMaterialForLecture(int idAddMaterial, String nameAddMaterial, int idLecture, String resourseType) throws  IOException {



        String sql = "SELECT * FROM on_line_school.addmaterial;";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.moveToInsertRow();
            System.out.println("hello");
            resultSet.updateInt("idaddMaterial", idAddMaterial);
            resultSet.updateString("nameAddMaterial", nameAddMaterial);
            resultSet.updateInt("idLecture", idLecture);
            resultSet.updateString("resourseType", resourseType);
            resultSet.insertRow();
            System.out.println("Поле добавлено до баи Додаткові матеріали");
        } catch (SQLException e) {
            System.out.println(LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                    "Помилка отримання даних з бази AddMaterial", LocalDateTime.now(),
                    e.getStackTrace()));
        }
    }

    public void deleteBaseAddMaterialPrintLine() throws  IOException {
        ValidationUtil testing = new ValidationUtil();
        String sqlFirst = "SELECT COUNT(*) FROM on_line_school.addmaterial";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sqlFirst,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            int sizeBase = resultSet.getInt(1);
            System.out.println("Ви вибрали видалити доаткові матеріали, кількість додаткових матеріалів-" + sizeBase +
                    " / ведіть номер доаткові матеріали від 1 до " + sizeBase);
            int numberPers = testing.testInt();
            if ((numberPers > 0) && (numberPers <= sizeBase)) {
                resultSet = preparedStatement.executeQuery("SELECT * FROM on_line_school.addmaterial;");
                resultSet.absolute(numberPers);
                resultSet.deleteRow();
            } else {
                System.out.println("Номер за межами розмірності бази");
            }
        } catch (SQLException e) {
            System.out.println(LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                    "Помилка отримання даних з бази AddMaterial", LocalDateTime.now(),
                    e.getStackTrace()));
        }
    }
}
