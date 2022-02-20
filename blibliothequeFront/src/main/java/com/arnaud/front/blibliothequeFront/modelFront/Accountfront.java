package com.arnaud.front.blibliothequeFront.modelFront;


import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Accountfront {

    private int id;
    private String pseudo;
    private String lastName;
    private String fristName;
    private String phoneNumber;
    private String mail;
    private String password;
    private String postalAdress;
    private String city;
    private List<Borrowingfront> pret;


}
