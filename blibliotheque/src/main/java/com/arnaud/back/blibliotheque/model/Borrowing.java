package com.arnaud.back.blibliotheque.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

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
    private Integer id;
    @Column(name = "date_Reservation")
    private LocalDateTime bookingDate;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Account account;
    @Column(name = "date_limite_retour")
    private LocalDateTime bookingDateEnd;
    @Column(columnDefinition = "boolean default false")
    private boolean outOfTime;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnore
    private Exemplary exemplaryId;
    @OneToOne
    @JoinColumn(name = "book_Id",referencedColumnName = "book_id",nullable = true)
    private Book book;


}
