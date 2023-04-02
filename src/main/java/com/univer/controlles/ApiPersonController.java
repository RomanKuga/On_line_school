package com.univer.controlles;

import com.univer.dao.ApiPersonDAO;
import com.univer.models.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ApiPersonController", urlPatterns = {"/api_person"})
public class ApiPersonController extends HttpServlet {
    private final ApiPersonDAO apiPersonDAO = new ApiPersonDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        List<Person> apiPerson = apiPersonDAO.getAllApiLPerson();
        request.setAttribute("personList", apiPerson);
        request.getRequestDispatcher("/WEB-INF/views/api_person/person_all.jsp")
                .forward(request, response);
    }
}
