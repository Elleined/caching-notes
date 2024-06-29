package com.elleined.caching.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@org.hibernate.annotations.Cache(region = "carCache", usage = CacheConcurrencyStrategy.READ_WRITE)

@Entity
@Table(name = "tbl_car")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            nullable = false,
            updatable = false,
            unique = true
    )
    private int id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(
            name = "person_id",
            referencedColumnName = "id",
            nullable = false,
            updatable = false
    )
    private Person person;
}
