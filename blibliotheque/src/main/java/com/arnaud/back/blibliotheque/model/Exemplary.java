package com.arnaud.back.blibliotheque.model;


import lombok.*;

import javax.persistence.*;

@Entity(name = "exemplary")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Exemplary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @JoinColumn(name = "id_blibliotheque")
    @ManyToOne
    private Blibliotheque idBlibliotheque;
    @Column(name = "exemplairenumber")
    private int exemplaryNumbers;
    @Column(name = "remainingexemplary")
    private int remainingexemplary;


}
