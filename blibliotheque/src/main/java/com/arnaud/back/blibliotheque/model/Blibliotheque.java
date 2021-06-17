package com.arnaud.back.blibliotheque.model;


import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "blibliotheque")
public class Blibliotheque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name",length = 255)
    private String name;
    @Column(name = "city")
    private String city;
    @Column(name = "streetnumber")
    private String streetNumber;
    @Column(name = "surface")
    private int surface;


}
