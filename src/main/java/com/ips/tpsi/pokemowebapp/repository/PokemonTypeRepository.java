package com.ips.tpsi.pokemowebapp.repository;

import com.ips.tpsi.pokemowebapp.entity.PokemonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PokemonTypeRepository extends JpaRepository<PokemonType,Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM PokemonType pt WHERE pt.pokemonId = :pokemonId")
    void deleteByPokemonId(Integer pokemonId);
}
