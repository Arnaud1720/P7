package com.arnaud.back.blibliotheque.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.management.relation.Role;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(	name = "account",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "pseudo"),
                @UniqueConstraint(columnNames = "mail"),
                @UniqueConstraint(columnNames = "last_name"),

        })
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Account  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "pseudo")
    private String pseudo;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "frist_name")
    private String fristName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "mail")
    private String mail;
    @Column(name = "password")
    private String password;
    @Column(name = "postal_adress")
    private String postalAdress;
    @Column(name = "city")
    private String city;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "account")
    @JsonIgnore
    private List<Roles> roles;
    @Transient
    private Boolean exceeded;
    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private List<Borrowing> borrowings;

}
