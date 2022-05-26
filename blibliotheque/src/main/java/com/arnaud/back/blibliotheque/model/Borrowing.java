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
    private Exemplary exemplaryId;
    @OneToOne
    @JoinColumn(name = "book_Id",referencedColumnName = "book_id")
    private Book book =null;
    @Column(name = "cmpt")
    private int cmpt;
    @Column(name = "total")
    private int total;

    public int setCmpt(int cmpt) {
        this.cmpt = cmpt;
        return cmpt;
    }

    public int getCmpts(Integer accountid) {
        return accountid;
    }


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
