package com.arnaud.back.blibliotheque.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "prêt")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pret {
    @Id
    @Column(name = "id", nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "date_debut",nullable = false)
    private LocalDateTime dPretStart;
    @Column(name = "date_fin",nullable = false)
    private LocalDateTime dPretEnd;
    @Column(name = "email_pret",nullable = false)
    private String Epret;


}
