package com.arnaud.back.blibliotheque.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "pret")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pret implements Serializable {
    @Id
    @Column(name = "id", nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "date_debut",nullable = false)
    private LocalDateTime debutDatePret;
    @Column(name = "date_fin",nullable = false)
    private LocalDateTime finDatePret;
    @Column(name = "email_pret")
    private String emailPret;

//    @ManyToOne
//    @JoinColumn(name = "book_Title",referencedColumnName = "title")
//    private Book bookTitle;
//    @ManyToOne
//    @JoinColumn(name = "account_mail",referencedColumnName = "mail")
//    private Account accountMail;


    public String getDebutDatePret() {
        return String.valueOf(debutDatePret);
    }

    public String getFinDatePret() {
        return String.valueOf(finDatePret);
    }


}
