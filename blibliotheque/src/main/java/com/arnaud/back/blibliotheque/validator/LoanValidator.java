package com.arnaud.back.blibliotheque.validator;

import com.arnaud.back.blibliotheque.model.dto.LoanDto;

import java.util.ArrayList;
import java.util.List;

public class LoanValidator {

    public static List<String> chemaValidator(LoanDto dto){
        List<String> erros = new ArrayList<>();


        if(dto == null || dto.getId() == null){
            erros.add("");
        }
        if(dto==null || dto.getStartDate()==null){
            erros.add("");
        }
        if(dto==null || dto.getEndDate()==null){
            erros.add("");
        }
        if(dto==null || dto.getExemplaryId()==null){
            erros.add("");
        }
        if(dto==null || dto.getExceeded()==null){
            erros.add("");
        }
        return erros;

    }

}
