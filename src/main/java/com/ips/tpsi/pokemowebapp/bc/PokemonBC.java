package com.ips.tpsi.pokemowebapp.bc;

import com.ips.tpsi.pokemowebapp.entity.Pokemon;
import com.ips.tpsi.pokemowebapp.repository.PokemonRepository;
import com.ips.tpsi.pokemowebapp.repository.PokemonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonBC {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PokemonTypeRepository pokemonTypeRepository;

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

    public boolean deletePokemonById(Integer idPokemon){
        if(pokemonRepository.existsById(idPokemon)){
            pokemonTypeRepository.deleteByPokemonId(idPokemon);
            pokemonRepository.deleteById(idPokemon);
            return true;
        }else{
            return false;
        }
    }

    public Optional<Pokemon> findPokemonById(Integer idPokemon){
        return pokemonRepository.findByIdPokemon(idPokemon);
    }
}
