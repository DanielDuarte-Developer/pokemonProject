package com.ips.tpsi.pokemowebapp.controller;

import com.ips.tpsi.pokemowebapp.bc.PokemonBC;
import com.ips.tpsi.pokemowebapp.entity.Pokemon;
import com.ips.tpsi.pokemowebapp.entity.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ModelAndView consultar(String action, String pokemonName, String typePokemon, Integer generation, Integer hp, Integer attack, Integer defense, Integer speedAT,
    Integer speedDF, Integer speed, String legendary){
        ModelAndView mv = new ModelAndView("consultar");
        List<Object> pokemonDetailed = pokemonDetailed = pokemonBc.getPokemonByFilters(pokemonName,typePokemon,hp,attack,defense,speedAT,generation,speedDF,speed,legendary);
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
    public ModelAndView alterar(Integer pokemonId){
        ModelAndView mv = new ModelAndView("alterar");
        //Fazer Logica
        return mv;
    }

    //########################## Apagar ###########################
    @PostMapping("/apagarLogic")
    public ModelAndView apagar(@RequestParam String[] selectedPokemons){
        ModelAndView mv = new ModelAndView("consultar");
        boolean isDeleted = false;
        for(String pokemonId: selectedPokemons){
            Optional<Pokemon> optionalPokemon = pokemonBc.findPokemonById(Integer.parseInt(pokemonId));

            if (optionalPokemon.isPresent()){
                Pokemon pokemon = optionalPokemon.get();

                isDeleted = pokemonBc.deletePokemonById(pokemon.getIdPokemon());
            }
        }

        if(isDeleted){
            //mv.addObject("deleteConfirm", "Pokemon(s) apagado(s) com sucesso");
            System.out.println("Pokemon(s) apagado(s) com sucesso");
        }
        return mv;
    }
}
