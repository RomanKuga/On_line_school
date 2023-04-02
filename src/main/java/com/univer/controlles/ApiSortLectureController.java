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

@WebServlet(name = "ApiSortLectureController", urlPatterns = {"/api-sortLecture"})
public class ApiSortLectureController extends HttpServlet {
    private final ApiLectureDAO apiExLectureDAO = new ApiLectureDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sectionId = Integer.parseInt(request.getParameter("sectionId"));
        if (sectionId == 1) {
            List<Lecture> apiSortLecture = apiExLectureDAO.getSortApiLectureName();

            request.setAttribute("apiSortLecture", apiSortLecture);
            request.getRequestDispatcher("/WEB-INF/views/api_sort/api_sort_Lecture_name.jsp").forward(request, response);
        } else {
            if (sectionId == 2) {
                List<Lecture> apiSortLecture = apiExLectureDAO.getSortApiLectureHomeWork();
                System.out.println(apiSortLecture);
                request.setAttribute("apiSortLecture", apiSortLecture);
                request.getRequestDispatcher("/WEB-INF/views/api_sort/api_sort_Lecture_name.jsp").forward(request, response);
            }
        }
    }
}
