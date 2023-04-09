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

@WebServlet(name = "ApiExLectureController", urlPatterns = {"/api-exLecture"})
public class RequestLectureController extends HttpServlet {

    private final ApiLectureDAO apiExLectureDAO = new ApiLectureDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sectionId = Integer.parseInt(request.getParameter("sectionId"));
        List<Lecture> apiExLecture = apiExLectureDAO.getApiLectureId(sectionId);
        request.setAttribute("apiExLecture", apiExLecture);
        request.getRequestDispatcher("/WEB-INF/views/api_example/apiExLecture.jsp").forward(request, response);
    }

}
