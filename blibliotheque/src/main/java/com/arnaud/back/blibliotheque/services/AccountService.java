package com.arnaud.back.blibliotheque.services;

import com.arnaud.back.blibliotheque.model.Account;

public interface AccountService {

    Account save(Account account);

   public Account findById(Integer id);


    void deleteById(Integer id);

    Account findByIdAccount(Integer Uid);


    Account findAccountByMail(String mail);

     void validationEmail( String email ) throws Exception;

     void validationMotsDePasse( String motDePasse) throws Exception;
}
