package com.univer.controlles;

import com.univer.baseEntity.CourseEntity;
import com.univer.config.AppConfig;
import com.univer.service.CourseSpringService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@WebServlet(name = "ExCourseController", urlPatterns = {"/requestCourse"})
public class RequestCourseController extends HttpServlet {
    ApplicationContext apc = new AnnotationConfigApplicationContext(AppConfig.class);
    CourseSpringService css = apc.getBean(CourseSpringService.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long sectionId = Long.valueOf(request.getParameter("sectionId"));
        CourseEntity apiExCourse = css.findById(sectionId);
        System.out.println(apiExCourse);
        request.setAttribute("apiExCourse", apiExCourse);
        request.getRequestDispatcher("/WEB-INF/views/api_example/apiExCourse.jsp").forward(request, response);
    }
}
