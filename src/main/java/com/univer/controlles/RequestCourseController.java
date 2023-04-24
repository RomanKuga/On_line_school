package com.univer.controlles;

import com.univer.baseEntity.CourseEntity;
import com.univer.service.CourseSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//@WebServlet(name = "ExCourseController", urlPatterns = {"/requestCourse"})
@Controller
public class RequestCourseController  {
//    ApplicationContext apc = new AnnotationConfigApplicationContext(AppConfig.class);
  @Autowired
   CourseSpringService css ;

  @GetMapping ("/requestCourse")
    public ModelAndView getCourse(@RequestParam("sectionId") String sectionId){
    System.out.println(sectionId);
    Long sect = Long.valueOf(sectionId);
    System.out.println(sect);
     CourseEntity apiExCourse = css.findById(sect);
      ModelAndView mv = new ModelAndView();
      mv.setViewName("api_example/apiExCourse");
      mv.addObject("apiExCourse", apiExCourse);
      return mv;
  }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Long sectionId = Long.valueOf(request.getParameter("sectionId"));
//        CourseEntity apiExCourse = css.findById(sectionId);
//        request.setAttribute("apiExCourse", apiExCourse);
//        request.getRequestDispatcher("/WEB-INF/views/api_example/apiExCourse.jsp").forward(request, response);
//    }
}
