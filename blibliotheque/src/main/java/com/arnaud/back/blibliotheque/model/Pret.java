package com.arnaud.back.blibliotheque.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "pret")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pret  {
    @Id
    @Column(name = "id",unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "dateJ")
    private LocalDateTime dateTimeJ;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Account account;
    @ManyToOne
    @JoinColumn(referencedColumnName = "book_id")
    private Book bookpret;



}
