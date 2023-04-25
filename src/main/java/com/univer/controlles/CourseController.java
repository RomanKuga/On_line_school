package com.univer.controlles;

import com.univer.baseEntity.CourseEntity;
import com.univer.service.CourseSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller

public class CourseController  {

    @Autowired
    CourseSpringService css ;
    @RequestMapping( "/course_all")
    public ModelAndView products() {
        List<CourseEntity> apiCourse =  css.allCourse();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("api_course/course_all");
        mv.addObject("courseList", apiCourse);
        return mv;
    }


}
