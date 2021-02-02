package com.ubb.pcis2083.soa.news.web.controller;

import com.ubb.pcis2083.soa.news.core.dto.LabelDto;
import com.ubb.pcis2083.soa.news.core.dto.converter.LabelConverter;
import com.ubb.pcis2083.soa.news.core.service.LabelService;
import com.ubb.pcis2083.soa.news.web.dto.LoginDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@PropertySource({
        "/WEB-INF/application.properties"
})
public class LoginController implements InitializingBean {

    private final Logger log = LogManager.getLogger(this.getClass());

    @Value("${users}")
    private String usersProperty;

    private List<LoginDTO> approvedLogins = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public ModelAndView  showLoginPage() {
        return new ModelAndView("login", "loginDTO",new LoginDTO());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView submit(@ModelAttribute("loginDTO")LoginDTO loginDTO, ModelMap model, HttpServletRequest request) {
        log.info(loginDTO.getUsername());
        log.info(loginDTO.getPassword());

        if (approvedLogins.contains(loginDTO)) {
            log.info("APPROVED");

            request.getSession().setAttribute("loggedIn",true);

            return new ModelAndView("redirect:/articles/recent/1", model);
        }
        else {
            log.info("REJECTED");
            return new ModelAndView("redirect:/login", model);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("LoginController started !!");

        for(String credentials : usersProperty.split(",")) {
            List<String> splitResult = Arrays.asList(credentials.split("&"));
            String username = splitResult.get(0);
            String password = splitResult.get(1);

            approvedLogins.add(new LoginDTO(username,password));
        }
    }
}
