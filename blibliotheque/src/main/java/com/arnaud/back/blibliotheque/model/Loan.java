package com.arnaud.back.blibliotheque.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "loan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loan_id")
    private int id;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "extension")
    private boolean extension;
    @JoinColumn(name ="accountid" )
    @ManyToOne
    private Account account;
    @JoinColumn(name = "id_exemplaire")
    @ManyToOne
    private Exemplary exemplaryId;
    @Transient
    private Boolean exceeded;

}
