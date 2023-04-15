package com.univer.controlles;

import com.univer.baseEntity.CourseEntity;
import com.univer.dao.ApiCourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value ="/secure/add_api_section")
public class AddCourseController extends HttpServlet {

    private ApiCourseDAO apiCourseDAO;

    public void init() {
        apiCourseDAO = new ApiCourseDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/api_course/add_course.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courseId= Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");

        CourseEntity apiCourse = new CourseEntity();
       // apiCourse.setIdCourse(courseId);
        apiCourse.setCourseName(title);
        System.out.println(apiCourse);
        apiCourseDAO.insertApiSection(apiCourse);

        response.sendRedirect(request.getContextPath() + "/api-sections");
    }
}
