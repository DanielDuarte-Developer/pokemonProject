package com.ips.tpsi.pokemowebapp.repository;

import com.ips.tpsi.pokemowebapp.entity.Pokemon;
import com.ips.tpsi.pokemowebapp.entity.PokemonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon,Integer> {
    //Primeira opção a ser considerada
    List<Pokemon> findAll();
    List<Pokemon> findByPokemonName(String pokemonName);
    List<Pokemon> findByGeneration(int generation);
    List<Pokemon> findByHp(int hp);
    List<Pokemon> findByAttack(int attack);
    List<Pokemon> findByDefense(int defense);
    List<Pokemon> findBySpAttack(int sp_attack);
    List<Pokemon> findBySpDefense(int sp_defense);
    List<Pokemon> findBySpeed(int speed);
    List<Pokemon> findByLegendary(String legendary);


    //Possivel 2 opção a ser analisada pela stora
    /*
    @Query("SELECT p FROM Pokemon p " +
            "WHERE (:pokemonName IS NULL OR p.pokemonName = :pokemonName) " +
            "AND (:generation IS NULL OR p.generation = :generation) " +
            "AND (:hp IS NULL OR p.hp = :hp) " +
            "AND (:attack IS NULL OR p.attack = :attack) " +
            "AND (:defense IS NULL OR p.defense = :defense) " +
            "AND (:spAttack IS NULL OR p.sp_attack = :spAttack)" +
            "AND (:spDefense IS NULL OR p.sp_defense = :spDefense)" +
            "AND (:speed IS NULL OR p.speed = :speed)"+
            "AND (:legendary IS NULL OR p.legendary = :legendary)")
    List<Pokemon> findByMultipleFilters(
            @Param("pokemonName") String pokemonName,
            @Param("generation") Integer generation,
            @Param("hp") Integer hp,
            @Param("attack") Integer attack,
            @Param("defense") Integer defense,
            @Param("spAttack") Integer sp_attack,
            @Param("spDefense") Integer sp_defense,
            @Param("speed") Integer speed,
            @Param("legendary") boolean legendary
    );
     */
}
