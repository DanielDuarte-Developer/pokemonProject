package com.ips.tpsi.pokemowebapp.repository;

import com.ips.tpsi.pokemowebapp.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon,Integer> {
    //Primeira opção a ser considerada
    //List<Pokemon> findAll();
    List<Pokemon> findByPokemonName(String pokemonName);
    List<Pokemon> findByGeneration(int generation);
    List<Pokemon> findByHp(int hp);
    List<Pokemon> findByAttack(int attack);
    List<Pokemon> findByDefense(int defense);
    List<Pokemon> findBySpAttack(int sp_attack);
    List<Pokemon> findBySpDefense(int sp_defense);
    List<Pokemon> findBySpeed(int speed);
    List<Pokemon> findByLegendary(String legendary);



    @Query("SELECT p, e1.element as type1, e2.element as type2 " +
            "FROM Pokemon p " +
            "INNER JOIN PokemonType pe1 ON p.idPokemon = pe1.pokemonId AND pe1.typeLVL = 1 " +
            "INNER JOIN Type e1 ON pe1.typeId = e1.idType " +
            "LEFT JOIN PokemonType pe2 ON p.idPokemon = pe2.pokemonId AND pe2.typeLVL = 2 " +
            "LEFT JOIN Type e2 ON pe2.typeId = e2.idType")
    List<Object> findDetailedPokemons();

    //Possivel 2 opção a ser analisada pela stora
    @Query("SELECT p, t1.element as type1, t2.element as type2 " +
            "FROM Pokemon p " +
            "LEFT JOIN PokemonType pt1 ON p.idPokemon = pt1.pokemonId AND pt1.typeLVL = 1 " +
            "LEFT JOIN Type t1 ON pt1.typeId = t1.idType " +
            "LEFT JOIN PokemonType pt2 ON p.idPokemon = pt2.pokemonId AND pt2.typeLVL = 2 " +
            "LEFT JOIN Type t2 ON pt2.typeId = t2.idType " +
            "WHERE " +
            "(COALESCE(:pokemonName, '') = '' OR COALESCE(:pokemonName, '') LIKE CONCAT('%', COALESCE(p.pokemonName, ''), '%')) " +
            "AND (COALESCE(:generation, p.generation) IS NULL OR COALESCE(:generation, p.generation) = p.generation) " +
            "AND (COALESCE(:hp, p.hp) IS NULL OR COALESCE(:hp, p.hp) = p.hp) " +
            "AND (COALESCE(:attack, p.attack) IS NULL OR COALESCE(:attack, p.attack) = p.attack) " +
            "AND (COALESCE(:defense, p.defense) IS NULL OR COALESCE(:defense, p.defense) = p.defense) " +
            "AND (COALESCE(:spAttack, p.spAttack) IS NULL OR COALESCE(:spAttack, p.spAttack) = p.spAttack) " +
            "AND (COALESCE(:spDefense, p.spDefense) IS NULL OR COALESCE(:spDefense, p.spDefense) = p.spDefense) " +
            "AND (COALESCE(:speed, p.speed) IS NULL OR COALESCE(:speed, p.speed) = p.speed) " +
            "AND (COALESCE(:legendary, '') = '' OR COALESCE(:legendary, '') = COALESCE(p.legendary, '')) " +
            "AND (COALESCE(:typePokemon, '') = '' OR COALESCE(:typePokemon, '') = COALESCE(t1.element, '') OR COALESCE(:typePokemon, '') = COALESCE(t2.element, ''))")
    List<Object> findByMultipleFilters(
            @Param("pokemonName") String pokemonName,
            @Param("generation") Integer generation,
            @Param("hp") Integer hp,
            @Param("attack") Integer attack,
            @Param("defense") Integer defense,
            @Param("spAttack") Integer spAttack,
            @Param("spDefense") Integer spDefense,
            @Param("speed") Integer speed,
            @Param("legendary") String legendary,
            @Param("typePokemon") String typePokemon
    );

}
