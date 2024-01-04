package com.ips.tpsi.pokemowebapp.controller;

import com.ips.tpsi.pokemowebapp.bc.PokemonBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PokemonController {
    @Autowired
    PokemonBC pokemonBc;


    //###################### Consultar ###########################
    @GetMapping("/consultar")
    public ModelAndView getConsultar(){
        ModelAndView mv = new ModelAndView("consultar");
        return mv;
    }
    @GetMapping("/consultarLogic")
    public ModelAndView consultar(){
        ModelAndView mv = new ModelAndView("consultar");
        //Fazer Logica
        return mv;
    }

    //########################### Alterar ###########################
    @GetMapping("/alterar")
    public ModelAndView getAlterar(){
        ModelAndView mv = new ModelAndView(" alterar");
        return mv;
    }
    @PostMapping("/alterarLogic")
    public ModelAndView alterar(){
        ModelAndView mv = new ModelAndView("alterar");
        //Fazer Logica
        return mv;
    }

    //########################## Apagar ###########################
    @GetMapping("/apagar")
    public ModelAndView getApagar(){
        ModelAndView mv = new ModelAndView("apagar");
        return mv;
    }
    @PostMapping("/apagarLogic")
    public ModelAndView apagar(){
        ModelAndView mv = new ModelAndView("apagar");
        //Fazer Logica
        return mv;
    }
}
