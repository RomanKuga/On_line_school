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

@WebServlet(name = "ApiAddMaterialController", urlPatterns = {"/api_add_material"})
public class ApiAddMaterialController extends HttpServlet {
    private final ApiAddMaterial apiAddMaterialDAO = new ApiAddMaterial();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        List<AddMaterial> apiAddMaterial = apiAddMaterialDAO.getAllApiAddMaterial();
        request.setAttribute("addMaterialList", apiAddMaterial);
        request.getRequestDispatcher("/WEB-INF/views/api_add_material/add_material_all.jsp")
                .forward(request, response);
    }
}
