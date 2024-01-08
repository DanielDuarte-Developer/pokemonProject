package com.ips.tpsi.pokemowebapp.repository;

import com.ips.tpsi.pokemowebapp.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon,Integer> {
    Optional<Pokemon> findByIdPokemon(Integer idPokemon);

    //Consultar Querry sem filtros
    @Query("SELECT p, e1.element as type1, e2.element as type2 " +
            "FROM Pokemon p " +
            "INNER JOIN PokemonType pe1 ON p.idPokemon = pe1.pokemonId AND pe1.typeLVL = 1 " +
            "INNER JOIN Type e1 ON pe1.typeId = e1.idType " +
            "LEFT JOIN PokemonType pe2 ON p.idPokemon = pe2.pokemonId AND pe2.typeLVL = 2 " +
            "LEFT JOIN Type e2 ON pe2.typeId = e2.idType")
    List<Object> findDetailedPokemons();

    //Consultar Querry com filtros
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
    @Transactional
    @Modifying
    @Query("UPDATE Pokemon p SET " +
            "p.pokemonName = COALESCE(NULLIF(:pokemonName, ''), p.pokemonName), " +
            "p.generation = COALESCE(:generation, p.generation), " +
            "p.total = COALESCE(:total, p.total), "+
            "p.hp = COALESCE(:hp, p.hp), " +
            "p.attack = COALESCE(:attack, p.attack), " +
            "p.defense = COALESCE(:defense, p.defense), " +
            "p.spAttack = COALESCE(:spAttack, p.spAttack), " +
            "p.spDefense = COALESCE(:spDefense, p.spDefense), " +
            "p.speed = COALESCE(:speed, p.speed), " +
            "p.legendary = COALESCE(NULLIF(:legendary, ''), p.legendary) " +
            "WHERE p.idPokemon = :idPokemon")
    void updatePokemonWithFilters( @Param("idPokemon") Integer idPokemon,
                        @Param("pokemonName") String pokemonName,
                        @Param("generation") Integer generation,
                        @Param("total") Integer total,
                        @Param("hp") Integer hp,
                        @Param("attack") Integer attack,
                        @Param("defense") Integer defense,
                        @Param("spAttack") Integer spAttack,
                        @Param("spDefense") Integer spDefense,
                        @Param("speed") Integer speed,
                        @Param("legendary") String legendary
    );

    @Modifying
    @Transactional
    @Query("UPDATE PokemonType pt " +
            "SET pt.typeId = (SELECT idType FROM Type WHERE element = :newTypePokemon1) " +
            "WHERE pt.pokemonId = :pokemonId AND pt.typeLVL = 1")
    void updatePokemonType1(
            @Param("pokemonId") Integer pokemonId,
            @Param("newTypePokemon1") String newTypePokemon1
    );

    @Modifying
    @Transactional
    @Query("UPDATE PokemonType pt " +
            "SET pt.typeId = (SELECT idType FROM Type WHERE element = :newTypePokemon2) " +
            "WHERE pt.pokemonId = :pokemonId AND pt.typeLVL = 2")
    void updatePokemonType2(
            @Param("pokemonId") Integer pokemonId,
            @Param("newTypePokemon2") String newTypePokemon2
    );


}
