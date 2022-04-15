package com.arnaud.back.blibliotheque.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micrometer.core.lang.Nullable;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "exemplary")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Exemplary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @JoinColumn(name = "id_blibliotheque")
    @ManyToOne
    private Blibliotheque idBlibliotheque;
    @Column(name = "exemplairenumber")
    private int exemplaryNumbers;
    @Column(name = "remainingexemplary")
    private int remainingexemplary;
    @OneToMany(mappedBy = "exemplaryId")
    @JsonIgnore
    private List<Borrowing> borrowingList;
//    @ManyToOne
//    @JoinColumn(name = "book_id")
//    @JsonIgnore
//    private Book book;
    @Column(name = "total_exemplary_number")
    private int maxExemplaryNumber;


}
