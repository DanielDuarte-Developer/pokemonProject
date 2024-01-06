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
@Table(name = "typep")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Type {
    @Id
    @Column(name = "id_type")
    private Integer idType;

    @Column(name = "element")
    private String element;

}
