package com.univer.controlles;

import com.univer.dao.ApiExampleDAO;
import com.univer.models.ApiExample;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ApiExampleController", urlPatterns = {"/api-examples"})
public class ApiExampleController extends HttpServlet {

    private final ApiExampleDAO apiExampleDAO = new ApiExampleDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sectionId = Integer.parseInt(request.getParameter("sectionId"));


        List<ApiExample> apiExamples = apiExampleDAO.getApiExamplesBySectionId(sectionId);
        request.setAttribute("apiExamples", apiExamples);
        request.getRequestDispatcher("/WEB-INF/views/api_example/index.jsp").forward(request, response);
    }

}
