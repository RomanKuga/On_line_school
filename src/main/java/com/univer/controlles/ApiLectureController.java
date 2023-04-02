package com.univer.controlles;

import com.univer.dao.ApiLectureDAO;
import com.univer.models.Lecture;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ApiLectureController", urlPatterns = {"/api_lecture"})
public class ApiLectureController extends HttpServlet {
    private final ApiLectureDAO apiLectureDAO = new ApiLectureDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        List<Lecture> apiLecture = apiLectureDAO.getAllApiLecture();
        request.setAttribute("lectureList", apiLecture);
        request.getRequestDispatcher("/WEB-INF/views/api_lecture/lecture_all.jsp")
                .forward(request, response);
    }
}
