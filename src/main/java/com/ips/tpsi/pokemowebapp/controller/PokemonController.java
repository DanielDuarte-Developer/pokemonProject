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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class PokemonController {
    @Autowired
    PokemonBC pokemonBc;


    //###################### Consultar ###########################
    @PostMapping("/consultarLogic")
    public ModelAndView consultar(@RequestParam(name = "pokemonName", required = false) String pokemonName,
                                  @RequestParam(name = "typePokemon", required = false) String typePokemon,
                                  @RequestParam(name = "generation", required = false) Integer generation,
                                  @RequestParam(name = "hp", required = false) Integer hp,
                                  @RequestParam(name = "attack", required = false) Integer attack,
                                  @RequestParam(name = "defense", required = false) Integer defense,
                                  @RequestParam(name = "speedAT", required = false) Integer speedAT,
                                  @RequestParam(name = "speedDF", required = false) Integer speedDF,
                                  @RequestParam(name = "speed", required = false) Integer speed,
                                  @RequestParam(name = "legendary", required = false) String legendary){
        ModelAndView mv = new ModelAndView("consultar");
        List<Object> pokemonDetailed = pokemonBc.getPokemonByFilters(pokemonName,typePokemon,generation,hp,attack,defense,speedAT,speedDF,speed,legendary);
        mv.addObject("pokemons",pokemonDetailed);
        return mv;
    }

    //########################### Alterar ###########################
    @PostMapping("/alterarLogic")
    public ModelAndView alterar(@RequestParam("alterarPokemonId") Integer id, String pokemonName, String typePokemon1, String typePokemon2, Integer generation, Integer total,Integer hp, Integer attack, Integer defense, Integer speedAttack,
                                Integer speedDefense, Integer speed, String legendary){
        ModelAndView mv = new ModelAndView("alterar");
        ModelAndView mvC = new ModelAndView("consultar");
        boolean isUpdated = pokemonBc.updatePokemonById(id,pokemonName,typePokemon1,typePokemon2,generation,total,hp,attack,defense,speedAttack,speedDefense,speed,legendary);
        if(isUpdated){
            mv.addObject("updateConfirm", "Pokemon alterado com sucesso");
            return mvC;
        }

        return mv;
    }

    //########################## Apagar ###########################
    @PostMapping("/apagarLogic")
    public ModelAndView apagar(@RequestParam String action, @RequestParam String[] selectedPokemons){
        ModelAndView mv = new ModelAndView("consultar");
        boolean isDeleted = false;
        if("Apagar".equals(action)){
            for(String pokemonId: selectedPokemons){
                Optional<Pokemon> optionalPokemon = pokemonBc.findPokemonById(Integer.parseInt(pokemonId));

                if (optionalPokemon.isPresent()){
                    Pokemon pokemon = optionalPokemon.get();

                    isDeleted = pokemonBc.deletePokemonById(pokemon.getIdPokemon());
                }
            }

            if(isDeleted){
                mv.addObject("deleteConfirm", "Pokemon(s) apagado(s) com sucesso");
            }
        } else if ("Alterar".equals(action)) {
            ModelAndView mvA = new ModelAndView("alterar");
            for(String pokemonId: selectedPokemons){
                if(!(selectedPokemons.length > 1)){
                    mvA.addObject("pokemonId",Integer.parseInt(pokemonId));
                    return mvA;
                }else {
                   mv.addObject("alterAviso","Por favor Alter apenas 1 de cada vez");
                }
            }
        }
        return mv;
    }
}
