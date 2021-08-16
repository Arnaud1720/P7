package com.arnaud.back.blibliotheque.model;


import com.fasterxml.jackson.databind.deser.Deserializers;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "borrowing")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Borrowing implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "borrowing_id")
    private int id;
    @Column(name = "start_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "extension")
    private boolean extension;
    @JoinColumn(name ="accountid" )
    @ManyToOne
    private Account account;
    @JoinColumn(name = "id_exemplaire")
    @ManyToOne
    private Exemplary exemplaryId;


}
