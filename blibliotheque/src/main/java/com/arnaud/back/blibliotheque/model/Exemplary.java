package com.arnaud.back.blibliotheque.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity(name = "exemplary")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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
//    Créé un lien ManyToOne d'Exemplary vers Book
    @ManyToOne
    @JoinColumn(referencedColumnName = "book_id")
    private Book book;

}
