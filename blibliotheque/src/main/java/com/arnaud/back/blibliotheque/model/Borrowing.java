package com.arnaud.back.blibliotheque.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * pret
 */
@Entity(name = "borrowing")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Borrowing implements Serializable {
    @Id
    @Column(name = "id",unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer id;
    @Column(name = "date_Reservation")
    private LocalDateTime dateTimeJ;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnore
    private Account account;
    @ManyToOne
    @JoinColumn(referencedColumnName = "book_id")
    @JsonIgnore
    private Book bookpret;
    @Column(name = "date_Fin")
    private LocalDateTime dateTimeFin;



}
