package com.arnaud.back.blibliotheque.validator;

import com.arnaud.back.blibliotheque.model.Borrowing;

import java.util.ArrayList;
import java.util.List;

public class BorrowingValidator {

    public static List<String> chemaValidator(Borrowing borrowing){
        List<String> chemaErros = new ArrayList<>();

        if(borrowing.getStartDate() == null){
            chemaErros.add("vous devez remplir le champ concernant la date de départ");
        }
        if(borrowing.getEndDate() == null){
            chemaErros.add("vous devez remplir le champ concernant la date de fin");
        }

        return chemaErros;

    }
}
