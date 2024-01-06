package com.ips.tpsi.pokemowebapp.entity;

import jakarta.persistence.*;
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

    @Column(name = "Pokemon_Id")
    private Integer pokemonId;

    @Column(name = "typeP_id")
    private Integer typeId;

    @Column(name = "typelvl")
    private Integer typeLVL;

}
