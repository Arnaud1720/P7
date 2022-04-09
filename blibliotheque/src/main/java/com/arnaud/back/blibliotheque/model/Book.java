package com.arnaud.back.blibliotheque.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "book")
public class Book  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private  Integer bookId;
    @Column(name = "title")
    private String bookTitle;
    @Column(name = "kind")
    private String bookKide;
    @Column(name = "author")
    private String bookAuthor;
    @Column(name = "editor")
    private String bookEditor;
    @Column(name = "ref")
    private String bookRef;
    @Column(name = "synopsis")
    private String bookSynopsis;
    @ManyToOne
    @JoinColumn(name = "id_examplary")
    private Exemplary exemplaryId;
    @Column(name = "book_available")
    private boolean available;
    @OneToMany(mappedBy = "bookpret")
    private List<Borrowing> borrowingList;
//   Créé un Lien OneToMany de Book vers exemplary
    @OneToMany(mappedBy = "book")
    List<Exemplary> exemplaries;

}
