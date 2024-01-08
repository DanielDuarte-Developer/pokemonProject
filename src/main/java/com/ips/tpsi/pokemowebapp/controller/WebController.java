package com.ips.tpsi.pokemowebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
    @GetMapping({"/","/home"})
    public ModelAndView getHome(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @GetMapping("/consultar")
    public ModelAndView getConsultar(){
        ModelAndView mv = new ModelAndView("consultar");
        return mv;
    }

    @GetMapping("/sobre")
    public ModelAndView getSobre(){
        ModelAndView mv = new ModelAndView("sobre");
        return mv;
    }
}
