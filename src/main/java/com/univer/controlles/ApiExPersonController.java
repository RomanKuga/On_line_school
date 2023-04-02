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

@WebServlet(name = "ApiExPersonController", urlPatterns = {"/api-exPerson"})
public class ApiExPersonController extends HttpServlet {
    private final ApiPersonDAO apiExPersonDAO = new ApiPersonDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sectionId = Integer.parseInt(request.getParameter("sectionId"));
        List<Person> apiExPerson = apiExPersonDAO.getApiPersonId(sectionId);
        request.setAttribute("apiExPerson", apiExPerson);
        request.getRequestDispatcher("/WEB-INF/views/api_example/apiExPerson.jsp").forward(request, response);
    }
}
