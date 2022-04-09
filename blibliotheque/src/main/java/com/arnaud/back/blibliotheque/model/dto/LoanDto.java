package com.arnaud.back.blibliotheque.model.dto;

import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.Exemplary;
import com.arnaud.back.blibliotheque.model.Loan;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Data
public class LoanDto {

    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean extension;
    private AccountDto account;
    private ExemplaryDto exemplaryId;
    @Transient
    private Boolean exceeded;


    // mapping Account -> AccountDto
    public LoanDto fromEntity(Loan loan){
        if(loan==null){
            return null;
        }
        return LoanDto.builder()
                .id(loan.getId())
                .startDate(loan.getStartDate())
                .endDate(loan.getEndDate())
                .extension(loan.isExtension())
                .exceeded(loan.getExceeded()).build();
    }
    //Mapping AccountDto -> Account
    public Loan toEntity(LoanDto loanDto){
        if(loanDto==null){
            return null;
        }
        Loan loan = new Loan();
        loan.setId(loanDto.getId());
        loan.setStartDate(loanDto.getStartDate());
        loan.setEndDate(loanDto.getEndDate());
        loan.setExtension(loanDto.isExtension());
        loan.setExceeded(loanDto.exceeded);
        return loan;
    }
}
