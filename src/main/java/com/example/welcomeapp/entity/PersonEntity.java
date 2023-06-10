package com.example.welcomeapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PERSON")
@NoArgsConstructor
@Getter
@Setter
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq_generator")
    @SequenceGenerator(name = "person_seq_generator", sequenceName = "person_id_seq", allocationSize = 1)
    private long id;

    @Column(name = "PUBLIC_ID")
    private String publicId;

    @Column(name = "NAME")
    private String name;
}
