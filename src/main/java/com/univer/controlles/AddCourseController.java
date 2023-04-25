package com.univer.controlles;

import com.univer.baseEntity.CourseEntity;
import com.univer.service.CourseSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@WebServlet(value ="/secure/add_api_section")
@Controller
public class AddCourseController {

    @Autowired
    CourseSpringService css;

    @GetMapping("/secure/add_api_section")

    public String urlPage() {
        return "api_course/add_course";
    }

    @PostMapping("/secure/add_api_section")
    public String addCourse( @RequestParam("title") String title) {
        CourseEntity apiCourse = new CourseEntity();
        apiCourse.setCourseName(title);
        css.addUser(apiCourse);
        return "redirect:/course_all";
    }

}
