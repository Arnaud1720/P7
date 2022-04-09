package com.arnaud.back.blibliotheque.validator;

import com.arnaud.back.blibliotheque.model.Borrowing;
import com.arnaud.back.blibliotheque.model.Loan;
import com.arnaud.back.blibliotheque.model.dto.BorrowingDto;

import java.util.ArrayList;
import java.util.List;

public class BorrowingValidator {
    public static List<String> chemaValidator(BorrowingDto dto){
        List<String> erros = new ArrayList<>();
        if(dto == null || dto.getId()==null){
            erros.add("id est null");
        }
        if(dto==null||dto.getBookingDate()==null){
            erros.add("date de fin non renseigner");

        }
        if(dto==null||dto.getBookingDate()==null){
            erros.add("date de début vide ou invalide");
        }

        return erros;

    }
}
