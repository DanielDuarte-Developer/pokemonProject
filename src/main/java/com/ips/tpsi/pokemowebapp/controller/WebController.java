package com.ips.tpsi.pokemowebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
    @GetMapping({"/","/home"})
    public ModelAndView getHome(){
        ModelAndView mv = new ModelAndView("index");
        // Aceder à business component > acede ao repositorio > obtem dados
        return mv;
    }
    @GetMapping("/name")
    public ModelAndView getName(){
        ModelAndView mv = new ModelAndView("nome");
        // Aceder à business component > acede ao repositorio > obtem dados
        mv.addObject("name","Daniel");
        return mv;
    }

}
