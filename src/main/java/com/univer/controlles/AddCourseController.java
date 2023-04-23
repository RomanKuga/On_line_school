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

@WebServlet(value ="/secure/add_api_section")
public class AddCourseController extends HttpServlet {
    ApplicationContext apc = new AnnotationConfigApplicationContext(AppConfig.class);
    CourseSpringService css = apc.getBean(CourseSpringService.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/api_course/add_course.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courseId= Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");

        CourseEntity apiCourse = new CourseEntity();

        apiCourse.setCourseName(title);
        css.addUser(apiCourse);


        response.sendRedirect(request.getContextPath() + "/course_all");
    }
}
