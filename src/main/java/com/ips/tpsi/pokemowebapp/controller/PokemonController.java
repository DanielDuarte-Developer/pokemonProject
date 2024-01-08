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
    @GetMapping("/consultar")
    public ModelAndView getConsultar(){
        ModelAndView mv = new ModelAndView("consultar");
        return mv;
    }
    @PostMapping("/consultarLogic")
    public ModelAndView consultar(String action, String pokemonName, String typePokemon, Integer generation, Integer hp, Integer attack, Integer defense, Integer speedAT,
    Integer speedDF, Integer speed, String legendary){
        ModelAndView mv = new ModelAndView("consultar");
        List<Object> pokemonDetailed = pokemonBc.getPokemonByFilters(pokemonName,typePokemon,hp,attack,defense,speedAT,generation,speedDF,speed,legendary);
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
    public ModelAndView alterar(@RequestParam("alterarPokemonId") String id, String pokemonName, String typePokemon1, String typePokemon2, Integer generation, Integer total,Integer hp, Integer attack, Integer defense, Integer speedAttack,
                                Integer speedDefense, Integer speed, String legendary){
        ModelAndView mv = new ModelAndView("alterar");
        System.out.println("PokemonId: "+ id + " Nome: "+ pokemonName+ "typePokemon1" + typePokemon1 +"typePokemon2" + typePokemon2 +"generation" + generation
                +"hp" + hp +"attack" + attack +"defense" + defense +"speedAttack" + speedAttack +"speedDefense" + speedDefense +"speed" +speed  +"Legendary" + legendary);
        boolean isUpdated = pokemonBc.updatePokemonById(Integer.parseInt(id),pokemonName,typePokemon1,typePokemon2,generation,total,hp,attack,defense,speedAttack,speedDefense,speed,legendary);
        if(isUpdated){
            mv.addObject("updateConfirm", "Pokemon alterado com sucesso");
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
                mvA.addObject("pokemonId",pokemonId);
                System.out.println("PokemonId: "+ pokemonId);
            }
            return mvA;
        }

        return mv;
    }
}
