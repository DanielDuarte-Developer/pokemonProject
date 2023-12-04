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
@Table(name = "pokemon")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pokemon {
    @Id
    @Column(name = "id_pokemon")
    private Integer idPokemon;

    @Column(name = "typeP_id")
    private Integer typeId;

    @Column(name = "generation_id")
    private Integer generationId;

    @Column(name = "total")
    private Integer total;

    @Column(name = "hp")
    private Integer hp;

    @Column(name = "attack")
    private Integer attack;

    @Column(name = "defense")
    private Integer defense;

    @Column(name = "sp_attack")
    private Integer spAttack;

    @Column(name = "sp_defense")
    private Integer spDefense;

    @Column(name = "speed")
    private Integer speed;

    @Column(name = "legendary")
    private boolean isLegendary;


}
