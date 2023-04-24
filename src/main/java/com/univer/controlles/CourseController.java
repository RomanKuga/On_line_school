package com.univer.controlles;

import com.univer.baseEntity.CourseEntity;
import com.univer.service.CourseSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@WebServlet(name = "SectionController", urlPatterns = {"/course_all"})
@Controller
public class CourseController  {
//   ApplicationContext apc = new AnnotationConfigApplicationContext(AppConfig.class);
    @Autowired
    CourseSpringService css ;
    @GetMapping( "/course_all")
    public String products(Model model) {
        List<CourseEntity> apiCourse =  css.allCourse();
        System.out.println(apiCourse);
        model.addAttribute("courseList", apiCourse);
        return "courseList";
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
//
//        List<CourseEntity> apiCourse =  css.allCourse();
//
//
//        request.setAttribute("courseList", apiCourse);
//        request.getRequestDispatcher("/WEB-INF/views/api_course/course_all.jsp")
//                .forward(request, response);
//    }


}
