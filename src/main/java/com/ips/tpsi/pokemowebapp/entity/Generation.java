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
@Table(name = "generation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Generation {
    @Id
    @Column(name = "id_generation")
    private Integer idGeneration;

    @Column(name = "generation")
    private Integer generation;

}
