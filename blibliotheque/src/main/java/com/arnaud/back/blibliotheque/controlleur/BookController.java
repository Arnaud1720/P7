package com.arnaud.back.blibliotheque.controlleur;

import com.arnaud.back.blibliotheque.controlleur.api.BookApi;
import com.arnaud.back.blibliotheque.model.Book;
import com.arnaud.back.blibliotheque.model.dto.BookDto;
import com.arnaud.back.blibliotheque.services.impl.BookServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController implements BookApi {

    private final BookServicesImpl bookServicesImpl;
    @Autowired
    public BookController( BookServicesImpl bookServicesImpl) {
        this.bookServicesImpl = bookServicesImpl;
    }


    @Override
    public List<Book> findBookByAvailableTrue(@RequestParam(value = "available",defaultValue = "true")boolean available) {
        if(available){
            return bookServicesImpl.findBookByAvailableTrue();
        }else{
            return bookServicesImpl.findBookByAvailableFalse();
        }
    }

    @Override
    public List<BookDto> findAll() {
        return bookServicesImpl.findAll();
    }

    @Override
    public List<Book> findAllByBookTitleContains(@RequestParam(value ="title",defaultValue = "")String titre,
                                                 @RequestParam(value = "author",defaultValue = "")String auteur,
                                                 @RequestParam(value = "kind",defaultValue = "")String genre) {
        return bookServicesImpl.findAllByBookTitleAndBookAuthorAndAndBookKide(titre,auteur,genre);
    }


}
