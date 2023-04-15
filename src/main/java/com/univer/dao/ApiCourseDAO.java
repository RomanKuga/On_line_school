package com.univer.dao;


import com.univer.baseEntity.CourseEntity;
import com.univer.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ApiCourseDAO {

    public List<CourseEntity> getAllApiCourse() {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Query<CourseEntity> query = session.createQuery("FROM CourseEntity", CourseEntity.class);
            List<CourseEntity> infoCourse = query.list();
            tx.commit();
            return infoCourse;

        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            throw new RuntimeException("Помилка отримання всіх курсів", e);
        }


    }


    public void insertApiSection(CourseEntity courseEntity) {
        Transaction tx = null;
        try( Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.persist(courseEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            throw new RuntimeException("Помилка запису нового курса", e);
        }

    }
    public List<CourseEntity> getApiCourseId(int courseSectionId) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Query<CourseEntity> query = session.createQuery("FROM CourseEntity WHERE idCourse =: idCourse", CourseEntity.class);
            System.out.println(courseSectionId);
            query.setParameter("idCourse",courseSectionId);
            List<CourseEntity> infoCourse = query.list();
            System.out.println(infoCourse);
            tx.commit();
            return infoCourse;

        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            throw new RuntimeException("Помилка отримання всіх курсів", e);
        }


    }
//    public List<Course> getApiCourseId(int courseSectionId) {
//        List<Course> apiCourse = new ArrayList<>();
//
//        try (Connection connection = DatabaseConnection.getConnection()) {
//            String sql = "SELECT * FROM course WHERE idCourse = ?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, courseSectionId);
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("idCourse");
//                String title = resultSet.getString("Course_name");
//
//
//                Course apiSection = new Course(id, title);
//                apiCourse.add(apiSection);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return apiCourse;
//    }
}
