package com.arnaud.back.blibliotheque.validator;

import com.arnaud.back.blibliotheque.model.Loan;

import java.util.ArrayList;
import java.util.List;

public class BorrowingValidator {

    public static List<String> chemaValidator(Loan loan){
        List<String> chemaErros = new ArrayList<>();

        if(loan.getStartDate() == null){
            chemaErros.add("vous devez remplir le champ concernant la date de départ");
        }
        if(loan.getEndDate() == null){
            chemaErros.add("vous devez remplir le champ concernant la date de fin");
        }

        return chemaErros;

    }
}
