package com.arnaud.back.blibliotheque.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Borrowing implements Serializable {
    @Id
    @Column(name = "id",unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer id;
    @Column(name = "date_Reservation")
    private LocalDateTime bookingDate;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "bookpret_book_id")
    private Book bookpret;
    @Column(name = "date_limite_retour")
    private LocalDateTime bookingDateEnd;
    @Column(columnDefinition = "boolean default false")
    private boolean outOfTime;



}
