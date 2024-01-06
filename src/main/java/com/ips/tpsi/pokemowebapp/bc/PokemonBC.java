package com.ips.tpsi.pokemowebapp.bc;

import com.ips.tpsi.pokemowebapp.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonBC {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Object> getPokemonByFilters(String pokemonName, String typePokemon, Integer generation, Integer hp, Integer attack, Integer defense, Integer speedAT,
                                                     Integer speedDF, Integer speed, String legendary){
        if(pokemonName.isBlank() && generation == null && hp == null && attack == null && defense == null && speedAT == null && speedDF== null
        && speed == null && typePokemon.isBlank()){
            return pokemonRepository.findDetailedPokemons();
        }else{
            return pokemonRepository.findByMultipleFilters(pokemonName,generation,hp,attack,defense,speedAT,speedDF,speed,legendary,typePokemon);
        }
    }

    public void alterarPokemon(Integer idPokemon, String pokemonName, Integer generation, Integer hp, Integer attack, Integer defense,
                               Integer speedAttack, Integer speedDefense, Integer speed, boolean legendary){


    }

    public  void apagarPokemon(Integer idPokemon){

    }
}
