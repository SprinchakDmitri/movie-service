package com.daa.movieservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;


import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "t_persons")
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "biography")
    private String biography;

    @Column(name = "person_height")
    private Double personHeight;

    @Column(name = "photo")
    private String encodedPhoto;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "death_date")
    private Date deathDate;

    @Column(name = "place_of_death")
    private String placeOfDeath;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_persons_countries",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id"))
    @JsonManagedReference
    private Set<Country> countries;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_person_roles",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonManagedReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Role> roles;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "person")
    @JsonManagedReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Crew> crews;

}
