package com.arnaud.back.blibliotheque.controlleur;

import com.arnaud.back.blibliotheque.controlleur.api.UtilisateurApi;
import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController implements UtilisateurApi {
    @Autowired
    private AccountService accountService;


    @Override
    public Account save(Account account) {
      return   accountService.save(account);
    }

    @Override
    public Account findById(Integer id) {
        return accountService.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
         accountService.deleteById(id);
    }

    @Override
    public Account findByIdAccount(Integer Uid) {
        return accountService.findByIdAccount(Uid);
    }


}
