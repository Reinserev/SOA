package com.ubb.pcis2083.soa.news.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// https://www.baeldung.com/spring-redirect-and-forward

@Controller
public class MainController {
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ModelAndView redirectWithUsingRedirectPrefix(ModelMap model) {
        return new ModelAndView("redirect:/login", model);
    }
}
