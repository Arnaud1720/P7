package com.arnaud.back.blibliotheque.validator;

import com.arnaud.back.blibliotheque.model.dto.BookDto;
import com.arnaud.back.blibliotheque.model.dto.BorrowingDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class BookValidator {

    public static List<String> chemaValidator(BookDto dto) {
        List<String> erros = new ArrayList<>();

        if (dto == null || dto.getBookId() == null) {
            erros.add("id est null");
        }
        if(dto==null||!StringUtils.hasLength(dto.getBookTitle())){
            erros.add("le titre du livre est vide ");
        }
        if(dto==null||!StringUtils.hasLength(dto.getBookKide())){
            erros.add("le genre du livre est vide ");
        }
        if(dto==null||!StringUtils.hasLength(dto.getBookAuthor())){
            erros.add("Auteur vide ");
        }
        if(dto==null||!StringUtils.hasLength(dto.getBookEditor())){
            erros.add("Editeur vide ");
        }
        if(dto==null||!StringUtils.hasLength(dto.getBookRef())){
            erros.add("aucun référence");
        }

        return erros;


    }

}
