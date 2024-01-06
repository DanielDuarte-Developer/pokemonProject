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
                                                     Integer speedDF, Integer speed, boolean legendary){
        if(pokemonName == null && generation == null && hp == null && attack == null && defense == null && speedAT == null && speedDF== null
        && speed == null && typePokemon == null){
            return pokemonRepository.findDetailedPokemons();
        }
        return null;
    }

    public void alterarPokemon(Integer idPokemon, String pokemonName, Integer generation, Integer hp, Integer attack, Integer defense,
                               Integer speedAttack, Integer speedDefense, Integer speed, boolean legendary){


    }

    public  void apagarPokemon(Integer idPokemon){

    }
}
