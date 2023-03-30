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

@WebServlet(name = "ApiSectionController", urlPatterns = {"/api-sections"})
public class ApiCourseController extends HttpServlet {

    private final ApiCourseDAO apiCourseDAO = new ApiCourseDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        List<Course> apiCourse = apiCourseDAO.getAllApiCourse();

        request.setAttribute("apiSections", apiCourse);

        request.getRequestDispatcher("/WEB-INF/views/api_section/index.jsp")
                .forward(request, response);
    }


}
