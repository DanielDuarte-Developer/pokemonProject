package com.ips.tpsi.pokemowebapp.controller;

import com.ips.tpsi.pokemowebapp.bc.PokemonBC;
import com.ips.tpsi.pokemowebapp.entity.Pokemon;
import com.ips.tpsi.pokemowebapp.entity.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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
    @PostMapping("/consultarLogic")
    public ModelAndView consultar(String pokemonName, String typePokemon, Integer generation, Integer hp, Integer attack, Integer defense, Integer speedAT,
    Integer speedDF, Integer speed, String legendary){

        System.out.println("PokemonName:"+ pokemonName + "TypePokemon "+ typePokemon + "generation "+ generation + "Legendary "+ legendary);
        List<Object> pokemonDetailed = pokemonBc.getPokemonByFilters(pokemonName,typePokemon,hp,attack,defense,speedAT,generation,speedDF,speed,legendary);

        ModelAndView mv = new ModelAndView("consultar");
        mv.addObject("pokemons",pokemonDetailed);
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
