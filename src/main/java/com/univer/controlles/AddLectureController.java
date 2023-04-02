package com.univer.controlles;

import com.univer.dao.ApiLectureDAO;
import com.univer.models.Lecture;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value ="/add_api_lecture")
public class AddLectureController extends HttpServlet {
    private ApiLectureDAO apiLectureDAO;

    public void init() {
        apiLectureDAO = new ApiLectureDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/api_lecture/add_lecture.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int lectureId= Integer.parseInt(request.getParameter("id"));
        int courseId= Integer.parseInt(request.getParameter("idCourse"));
        String title = request.getParameter("title");
        int personId= Integer.parseInt(request.getParameter("idPerson"));
        String description = request.getParameter("description");
        String dateTime = request.getParameter("dateTime");
        Lecture apiLecture = new Lecture(lectureId,courseId,title,personId,description,dateTime);
        apiLectureDAO.insertApiLecture(apiLecture);

        response.sendRedirect(request.getContextPath() + "/api_lecture");
    }
}
