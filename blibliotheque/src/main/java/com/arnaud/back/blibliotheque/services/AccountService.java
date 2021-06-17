package com.arnaud.back.blibliotheque.services;

import com.arnaud.back.blibliotheque.model.Account;

public interface AccountService {

    Account save(Account account);

   public Account findById(Integer id);


    void deleteById(Integer id);

    Account findByMail(String mail);


}
