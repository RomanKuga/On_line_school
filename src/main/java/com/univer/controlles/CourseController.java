package com.univer.controlles;

import com.univer.baseEntity.CourseEntity;
import com.univer.dao.ApiCourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ApiSectionController", urlPatterns = {"/api-sections"})
public class CourseController extends HttpServlet {

    private final ApiCourseDAO apiCourseDAO = new ApiCourseDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        List<CourseEntity> apiCourse =  apiCourseDAO.getAllApiCourse();

        request.setAttribute("courseList", apiCourse);
        request.getRequestDispatcher("/WEB-INF/views/api_course/course_all.jsp")
                .forward(request, response);
    }


}
