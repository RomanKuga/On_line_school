package com.univer.controlles;

import com.univer.dao.ApiAddMaterial;
import com.univer.models.AddMaterial;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ApiSortAddMaterial", urlPatterns = {"/api-sortAddMaterial"})
public class ApiSortAddMaterial extends HttpServlet {
    private final ApiAddMaterial apiSortAddMaterialDAO = new ApiAddMaterial();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sectionId = Integer.parseInt(request.getParameter("sectionId"));

            List<AddMaterial> apiSortAddMaterial = apiSortAddMaterialDAO.getSortApiAddMaterialResource();

            request.setAttribute("apiSortAddMaterial", apiSortAddMaterial);
            request.getRequestDispatcher("/WEB-INF/views/api_sort/api_sort_AddMaterial.jsp").forward(request, response);

    }
}
