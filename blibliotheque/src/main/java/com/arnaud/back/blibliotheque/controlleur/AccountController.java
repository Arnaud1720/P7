package com.arnaud.back.blibliotheque.controlleur;

import com.arnaud.back.blibliotheque.controlleur.api.UtilisateurApi;
import com.arnaud.back.blibliotheque.model.dto.AccountDto;
import com.arnaud.back.blibliotheque.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController implements UtilisateurApi {
    private final AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @Override
    public AccountDto save(AccountDto accountDto) throws Exception {
        //TODO valid email regex a modifier

        accountService.validationEmail(accountDto.getMail());
        accountService.validationMotsDePasse(accountDto.getPassword());
      return   accountService.save(accountDto);
    }

    @Override
    public AccountDto findById(Integer id) {
        return accountService.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
         accountService.deleteById(id);
    }

    @Override
    public AccountDto findByIdAccount(Integer Uid) {
        return accountService.findByIdAccount(Uid);
    }


}
