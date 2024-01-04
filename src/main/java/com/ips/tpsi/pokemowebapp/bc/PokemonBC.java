package com.ips.tpsi.pokemowebapp.bc;

import com.ips.tpsi.pokemowebapp.entity.Pokemon;
import com.ips.tpsi.pokemowebapp.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonBC {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> getPokemonByFilters(String pokemonName, Integer generation, Integer hp, Integer attack, Integer defense,
                                             Integer speedAttack, Integer speedDefense, Integer speed, boolean legendary){
        if(pokemonName == null && generation == null && hp == null && attack == null && defense == null && speedAttack == null && speedDefense== null
        && speed == null){
            return pokemonRepository.findAll();
        }
        return null;
    }

    public void alterarPokemon(Integer idPokemon, String pokemonName, Integer generation, Integer hp, Integer attack, Integer defense,
                               Integer speedAttack, Integer speedDefense, Integer speed, boolean legendary){


    }

    public  void apagarPokemon(Integer idPokemon){

    }
}
