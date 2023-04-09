package com.univer.controlles;

import com.univer.dao.ApiLectureDAO;
import com.univer.dao.ApiPersonDAO;
import com.univer.models.Lecture;
import com.univer.models.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ApiExLecturePersonController", urlPatterns = {"/api-exLecturePerson"})
public class RequestLecturePersonController extends HttpServlet {
    private final ApiLectureDAO apiExLectureDAO = new ApiLectureDAO();
    private final ApiPersonDAO apiExPersonDAO = new ApiPersonDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sectionId = Integer.parseInt(request.getParameter("sectionId"));
        List<Lecture> apiExLecture = apiExLectureDAO.getApiLectureCourseId(sectionId);
        List<Person> apiExPerson = apiExPersonDAO.getApiPersonCourseId(sectionId);
        request.setAttribute("apiExLecture", apiExLecture);
        request.setAttribute("apiExPerson", apiExPerson);
        request.getRequestDispatcher("/WEB-INF/views/api_example/apiExLecturePerson.jsp").forward(request, response);
    }
}
