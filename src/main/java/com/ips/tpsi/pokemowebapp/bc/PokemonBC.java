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

    public boolean updatePokemonById(Integer idPokemon, String pokemonName, String typePokemon1, String typePokemon2, Integer generation,
                                     Integer total ,Integer hp, Integer attack, Integer defense, Integer speedAT,
                                     Integer speedDF, Integer speed, String legendary){
        if(pokemonRepository.existsById(idPokemon)){
            System.out.println("PokemonId: "+ idPokemon + " Nome: "+ pokemonName+ " typePokemon1: " + typePokemon1 +" typePokemon2 " + typePokemon2 +" generation " + generation
                    +" hp " + hp +" attack " + attack +" defense " + defense + " speedAttack " + speedAT + " speedDefense " + speedDF +" speed " +speed  +" Legendary " + legendary);
            pokemonRepository.updatePokemonWithFilters(idPokemon,pokemonName,generation,total,hp,attack,defense,speedAT,speedDF,speed,legendary);
            if(!typePokemon1.isBlank() || !typePokemon2.isBlank()){
                pokemonRepository.updatePokemonType1(idPokemon,typePokemon1);
                pokemonRepository.updatePokemonType2(idPokemon,typePokemon2);
            }
            return true;
        }else {
            return false;
        }
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
