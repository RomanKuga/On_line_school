package com.univer.controlles;

import com.univer.dao.ApiExampleDAO;
import com.univer.models.ApiExample;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/secure/add_api_example")
public class AddApiExampleController extends HttpServlet {

    private ApiExampleDAO apiExampleDAO;


    public void init() {
        apiExampleDAO = new ApiExampleDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {




        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String code = request.getParameter("code");

        ApiExample apiExample = new ApiExample(title, code);
        apiExampleDAO.insertApiExample(apiExample);

        response.sendRedirect(request.getContextPath() + "/api-examples");
    }
}
