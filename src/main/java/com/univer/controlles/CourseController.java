package com.univer.controlles;

import com.univer.baseEntity.CourseEntity;
import com.univer.service.CourseSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@WebServlet(name = "SectionController", urlPatterns = {"/course_all"})
@Controller

public class CourseController  {
//   ApplicationContext apc = new AnnotationConfigApplicationContext(AppConfig.class);
    @Autowired
    CourseSpringService css ;
    @RequestMapping( "/course_all")
    public ModelAndView products() {
        List<CourseEntity> apiCourse =  css.allCourse();
        ModelAndView mv = new ModelAndView();
        System.out.println(apiCourse);
        mv.setViewName("api_course/course_all");
        mv.addObject("courseList", apiCourse);
        return mv;
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
