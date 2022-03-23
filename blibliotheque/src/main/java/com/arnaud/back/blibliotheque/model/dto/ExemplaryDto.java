package com.arnaud.back.blibliotheque.model.dto;

import com.arnaud.back.blibliotheque.model.Blibliotheque;
import com.arnaud.back.blibliotheque.model.Book;
import com.arnaud.back.blibliotheque.model.Exemplary;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Builder
@Data
public class ExemplaryDto {
    private int id;

    private BlibliothequeDto idBlibliotheque;
    private int exemplaryNumbers;
    private int remainingexemplary;
    //    Créé un lien ManyToOne d'Exemplary vers Book
    private BookDto book;


    // mapping Exemplary -> ExemplaryDto fromEntity
    public ExemplaryDto fromEntity(Exemplary exemplary){
        if(exemplary==null){
            return null;
        }
        return ExemplaryDto.builder()
                .id(exemplary.getId())
                .exemplaryNumbers(exemplary.getExemplaryNumbers())
                .remainingexemplary(exemplary.getRemainingexemplary())
                .build();
    }
    //Mapping AccountDto -> Account ToEntity
    public Exemplary toEntity(ExemplaryDto exemplaryDto){
        Exemplary exemplary = new Exemplary();
        exemplary.setId(exemplaryDto.getId());
        exemplary.setExemplaryNumbers(exemplaryDto.getExemplaryNumbers());
        exemplary.setRemainingexemplary(exemplaryDto.getRemainingexemplary());
        return exemplary;
    }
}
