package com.arnaud.back.blibliotheque.services;

import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.dto.AccountDto;

public interface AccountService {

    AccountDto save(AccountDto accountDto);

    AccountDto findById(Integer id);


    void deleteById(Integer id);

    AccountDto findByIdAccount(Integer Uid);


//    AccountDto findAccountByMail(String mail);
    Account findAccountByMail(String mail);

    void validationEmail( String email ) throws Exception;

     void validationMotsDePasse( String motDePasse) throws Exception;
}
