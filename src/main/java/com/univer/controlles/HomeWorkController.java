package com.univer.controlles;

import com.univer.dao.ApiHomeWorkDAO;
import com.univer.models.HomeWork;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ApiHomeWorkController", urlPatterns = {"/api_home_work"})
public class HomeWorkController extends HttpServlet {
    private final ApiHomeWorkDAO apiHomeWorkDAO = new ApiHomeWorkDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        List<HomeWork> apiHomeWork = apiHomeWorkDAO.getAllApiHomeWork();
        request.setAttribute("homeWorkList", apiHomeWork);
        request.getRequestDispatcher("/WEB-INF/views/api_home_work/home_work_all.jsp")
                .forward(request, response);
    }
}
