package com.univer.controlles;

import com.univer.dao.ApiCourseDAO;
import com.univer.models.Course;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ApiExCourseController", urlPatterns = {"/api-exCourse"})
public class ApiExCourseController extends HttpServlet {
    private final ApiCourseDAO apiExCourseDAO = new ApiCourseDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sectionId = Integer.parseInt(request.getParameter("sectionId"));
        List<Course> apiExCourse = apiExCourseDAO.getApiCourseId(sectionId);
        request.setAttribute("apiExCourse", apiExCourse);
        request.getRequestDispatcher("/WEB-INF/views/api_example/apiExCourse.jsp").forward(request, response);
    }
}
