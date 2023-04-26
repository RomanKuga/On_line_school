package com.univer.controlles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartPageJsp {
    @Value("${start.Page}")
    @RequestMapping  ("/")
    public String welcome() {
        return "index.jsp";
    }
}
