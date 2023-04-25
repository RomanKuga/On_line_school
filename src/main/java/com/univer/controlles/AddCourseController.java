package com.univer.controlles;

import com.univer.baseEntity.CourseEntity;
import com.univer.service.CourseSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@WebServlet(value ="/secure/add_api_section")
@Controller
public class AddCourseController {
    //    ApplicationContext apc = new AnnotationConfigApplicationContext(AppConfig.class);
    @Autowired
    CourseSpringService css;

    @GetMapping("/secure/add_api_section")

    public String urlPage() {
        return "api_course/add_course";
    }

    @PostMapping("/secure/add_api_section")
 //   @ResponseBody
    public String addCourse(Model model, @RequestParam("title") String title) {
        CourseEntity apiCourse = new CourseEntity();
        apiCourse.setCourseName(title);
        css.addUser(apiCourse);
        return "redirect:/course_all";
    }

//    @ResponseBody
//    public ModelAndView addCourse(@RequestParam("title") String title) {
//        CourseEntity apiCourse = new CourseEntity();
//        apiCourse.setCourseName(title);
//        css.addUser(apiCourse);
//        ModelAndView rt = new ModelAndView();
//        rt.setViewName("api_course/course_all");
//        return rt;
//    }


//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.getRequestDispatcher("/WEB-INF/views/api_course/add_course.jsp").forward(request, response);
//    }
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int courseId= Integer.parseInt(request.getParameter("id"));
//        String title = request.getParameter("title");
//
//        CourseEntity apiCourse = new CourseEntity();
//
//        apiCourse.setCourseName(title);
//        css.addUser(apiCourse);
//
//
//        response.sendRedirect(request.getContextPath() + "/course_all");
//    }
}
