package com.univer.controlles;

import com.univer.dao.ApiCourseDAO;
import com.univer.models.Course;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/secure/add_api_section")
public class AddApiSectionController extends HttpServlet {

    private ApiCourseDAO apiCourseDAO;

    public void init() {
        apiCourseDAO = new ApiCourseDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int courseId= request.getIntHeader("id");
        String title = request.getParameter("title");
 //       String description = request.getParameter("description");

        Course apiCourse = new Course(courseId,title);
        apiCourseDAO.insertApiSection(apiCourse);

        response.sendRedirect(request.getContextPath() + "/api-sections");
    }
}
