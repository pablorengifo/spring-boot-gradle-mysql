package com.javasampleapproach.security.controller;

import com.javasampleapproach.security.entity.User;
import com.javasampleapproach.security.entity.UserRole;
import com.javasampleapproach.security.repository.UserRepository;
import com.javasampleapproach.security.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRepository userRepository;
   
    @RequestMapping(value={"/","home"})
    public String home(){
            return "home";
        }
   
    @RequestMapping(value={"/welcome"})
    public String welcome(){
        return "welcome";
    }
  
    @RequestMapping(value="/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping(value={"/login"})
    public String login(){
        return "login";
    }

    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }
}