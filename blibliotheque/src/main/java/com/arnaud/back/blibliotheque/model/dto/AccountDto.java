package com.arnaud.back.blibliotheque.model.dto;

import com.arnaud.back.blibliotheque.model.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AccountDto {
    private int id;
    private String pseudo;
    private String lastName;
    private String fristName;
    private String phoneNumber;
    private String mail;
    private String password;
    private String postalAdress;
    private String city;
    private List<RolesDto> roles;
    private Boolean exceeded;
    private List<BorrowingDto> borrowings;
    // mapping Account -> AccountDto
    public static AccountDto fromEntity(Account account){
        if(account==null){
            return null;
        }
        return AccountDto.builder().id(account.getId())
                .pseudo(account.getPseudo())
                .lastName(account.getFristName())
                .fristName(account.getLastName())
                .phoneNumber(account.getPhoneNumber())
                .mail(account.getMail())
                .password(account.getPassword())
                .postalAdress(account.getPostalAdress())
                .city(account.getCity()).build();
    }


    //Mapping AccountDto -> Account
    public static Account toEntity(AccountDto accountDto){
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setPseudo(accountDto.getPseudo());
        account.setLastName(accountDto.getLastName());
        account.setFristName(accountDto.getFristName());
        account.setPhoneNumber(accountDto.getPhoneNumber());
        account.setMail(accountDto.getMail());
        account.setPassword(accountDto.getPassword());
        account.setPostalAdress(accountDto.getPostalAdress());
        account.setCity(accountDto.getCity());
        return account;   }
}
