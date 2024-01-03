package com.ips.tpsi.pokemowebapp.repository;

import com.ips.tpsi.pokemowebapp.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon,Integer> {
    Pokemon findByIdPokemon(Integer idPokemon);
}
