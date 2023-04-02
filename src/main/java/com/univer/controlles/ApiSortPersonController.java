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

@WebServlet(name = "ApiSortPersonController", urlPatterns = {"/api-sortPerson"})
public class ApiSortPersonController extends HttpServlet {
    private final ApiPersonDAO apiExPersonDAO = new ApiPersonDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sectionId = Integer.parseInt(request.getParameter("sectionId"));

        if (sectionId==1) {List<Person> apiExPerson = apiExPersonDAO.getSortApiPersonStudent();
            request.setAttribute("apiExPerson", apiExPerson);
            request.getRequestDispatcher("/WEB-INF/views/api_example/apiExPerson.jsp").forward(request, response);
        } else { if (sectionId==2) {
            List<Person> apiExPerson = apiExPersonDAO.getSortApiPersonTeacher();
            request.setAttribute("apiExPerson", apiExPerson);
            request.getRequestDispatcher("/WEB-INF/views/api_example/apiExPerson.jsp").forward(request, response);
        }
        }
        }
}
