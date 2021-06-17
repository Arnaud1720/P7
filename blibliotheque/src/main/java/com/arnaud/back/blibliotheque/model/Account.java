package com.arnaud.back.blibliotheque.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "account")
public class Account {

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


}
