package com.arnaud.back.blibliotheque.model.dto;

import com.arnaud.back.blibliotheque.model.Book;
import com.arnaud.back.blibliotheque.model.Borrowing;
import com.arnaud.back.blibliotheque.model.Exemplary;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
public class BookDto {
    private  int bookId;
    private String bookTitle;
    private String bookKide;
    private String bookAuthor;
    private String bookEditor;
    private String bookRef;
    private String bookSynopsis;
    private ExemplaryDto exemplaryId;
    private boolean available;
    @JsonIgnore
    private List<Borrowing> borrowingList;
    //   Créé un Lien OneToMany de Book vers exemplary
    @JsonIgnore
    List<ExemplaryDto> exemplaries;

    //Mapping Book -> BookDto
    public static BookDto fromEntity(Book book){
        if(book==null){
            return null;
        }
        return  BookDto.builder()
                .bookId(book.getBookId())
                .bookTitle(book.getBookTitle())
                .bookKide(book.getBookKide())
                .bookAuthor(book.getBookAuthor())
                .bookEditor(book.getBookEditor())
                .bookRef(book.getBookRef())
                .bookSynopsis(book.getBookSynopsis())
                .available(book.isAvailable()).build();

    }
    //Mapping BookDto -> Book
    public Book toEntity(BookDto bookDto){
        Book book = new Book();
        book.setBookId(bookDto.getBookId());
        book.setBookTitle(bookDto.getBookTitle());
        book.setBookKide(bookDto.getBookKide());
        book.setBookAuthor(bookDto.getBookAuthor());
        book.setBookEditor(bookDto.getBookEditor());
        book.setBookRef(bookDto.getBookRef());
        book.setBookSynopsis(bookDto.getBookSynopsis());
        book.setAvailable(bookDto.isAvailable());
        return book;
    }
}
