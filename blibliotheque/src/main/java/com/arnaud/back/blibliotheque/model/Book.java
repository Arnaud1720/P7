package com.arnaud.back.blibliotheque.model;

import lombok.*;

import javax.persistence.*;
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
    private  int bookId;
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


}
