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
import java.util.List;

@WebServlet(name = "SectionController", urlPatterns = {"/course_all"})
public class CourseController extends HttpServlet {
   ApplicationContext apc = new AnnotationConfigApplicationContext(AppConfig.class);
    CourseSpringService css = apc.getBean(CourseSpringService.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {

        List<CourseEntity> apiCourse =  css.allCourse();


        request.setAttribute("courseList", apiCourse);
        request.getRequestDispatcher("/WEB-INF/views/api_course/course_all.jsp")
                .forward(request, response);
    }


}
