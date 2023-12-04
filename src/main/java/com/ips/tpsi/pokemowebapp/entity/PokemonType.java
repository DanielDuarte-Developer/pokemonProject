package com.ips.tpsi.pokemowebapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pokemontype")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PokemonType {
    @Id
    @Column(name = "id_pokemonType")
    private Integer idPokemonType;

    @Column(name = "pokemon_Id")
    private Integer PokemonId;

    @Column(name = "typeP_id")
    private Integer type_Id;

    @Column(name = "typelvl")
    private Integer typeLVL;

}
