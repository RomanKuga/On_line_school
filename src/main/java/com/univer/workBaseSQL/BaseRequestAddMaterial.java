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

    public void baseAddMaterialPrintAll() throws SQLException, IOException {

        String sql = "SELECT * FROM on_line_school.addmaterial";

        try (Statement statement = getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            ResultSet resultSet = statement.executeQuery(sql);

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

    public void openBaseAddMaterialPrintLine() throws SQLException, IOException {
        ValidationUtil testing = new ValidationUtil();
        String sqlFirst = "SELECT COUNT(*) FROM on_line_school.addmaterial";

        try (Statement statement = getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            ResultSet resultSet = statement.executeQuery(sqlFirst);

            resultSet.next();
            int sizeBase = resultSet.getInt(1);
            System.out.println("Ви вибрали відкрити доаткові матеріали, кількість додаткових матеріалів-" + sizeBase +
                    " / ведіть номер доаткові матеріали від 1 до " + sizeBase);
            int numberPers = testing.testInt();
            if ((numberPers > 0) && (numberPers <= sizeBase)) {
                resultSet = statement.executeQuery("SELECT * FROM on_line_school.addmaterial;");
                resultSet.absolute(numberPers);
                int idAddMaterial = resultSet.getInt("idaddMaterial");
                String nameAddMaterial = resultSet.getString("nameAddMaterial");
                int idLecture = resultSet.getInt("idLecture");
                String resourseType = resultSet.getString("resourseType");
                System.out.println("//  AddMaterials id = " + idAddMaterial + "/  Назва додаткових матеріалів--  " + nameAddMaterial + "/ ID лекції-- " + idLecture + "/ Залучені типи додаткових завдань-- " + resourseType);
            } else {
                System.out.println("Номер за межами розмірності бази");
            }
        } catch (SQLException e) {
            System.out.println(LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                    "Помилка отримання даних з бази AddMaterial", LocalDateTime.now(),
                    e.getStackTrace()));
        }
    }

    public void sortBaseAddMaterialForLecture() throws SQLException, IOException {

        String sql = "SELECT * FROM on_line_school.addmaterial order by idLecture;";

        try (Statement statement = getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            ResultSet resultSet = statement.executeQuery(sql);

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

    public void sortBaseAddMaterialForID() throws SQLException, IOException {

        String sql = "SELECT * FROM on_line_school.addmaterial order by idaddMaterial;";

        try (Statement statement = getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            ResultSet resultSet = statement.executeQuery(sql);

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

    public void sortBaseAddMaterialForResourseType() throws SQLException, IOException {

        String sql = "SELECT * FROM on_line_school.addmaterial order by resourseType;";

        try (Statement statement = getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            ResultSet resultSet = statement.executeQuery(sql);

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

    public void addBaseAddMaterialForLecture(int idAddMaterial, String nameAddMaterial, int idLecture, String resourseType) throws SQLException, IOException {

        String sql = "SELECT * FROM on_line_school.addmaterial;";

        try (Statement statement = getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.moveToInsertRow();
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

    public void deleteBaseAddMaterialPrintLine() throws SQLException, IOException {
        ValidationUtil testing = new ValidationUtil();
        String sqlFirst = "SELECT COUNT(*) FROM on_line_school.addmaterial";

        try (Statement statement = getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

            ResultSet resultSet = statement.executeQuery(sqlFirst);

            resultSet.next();
            int sizeBase = resultSet.getInt(1);
            System.out.println("Ви вибрали видалити доаткові матеріали, кількість додаткових матеріалів-" + sizeBase +
                    " / ведіть номер доаткові матеріали від 1 до " + sizeBase);
            int numberPers = testing.testInt();
            if ((numberPers > 0) && (numberPers <= sizeBase)) {
                resultSet = statement.executeQuery("SELECT * FROM on_line_school.addmaterial;");
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
