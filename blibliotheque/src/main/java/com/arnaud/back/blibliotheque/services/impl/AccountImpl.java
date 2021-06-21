package com.arnaud.back.blibliotheque.services.impl;

import com.arnaud.back.blibliotheque.exception.EntityNotFoundException;
import com.arnaud.back.blibliotheque.exception.ErrorCode;
import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.repository.AccountRepository;
import com.arnaud.back.blibliotheque.services.AccountService;
import com.arnaud.back.blibliotheque.validator.AccountValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
@Slf4j
@Service
public class AccountImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        List<String> erros = AccountValidator.chemaValidator(account);
        if(!erros.isEmpty()){
            log.error("erreur de création de l'utilisateur {}",account);
            throw new EntityNotFoundException("erreur pendant la création du compte", ErrorCode.USER_NOT_VALID,erros);
        }
        else
            return accountRepository.save(account);
    }

    @Override
    public Account findById(Integer id) {

        if(id == null){
            log.error("l'utilisateur correspondant a l'id"+id+"pas présent en BDD");
        }
        assert id != null;
        return accountRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("utilisateur introuvable "+ErrorCode.USER_NOT_FOUND));

    }

    @Override
    public void deleteById(Integer id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account findAccountByMail(String mail) {
        if(!StringUtils.hasLength(mail)){
            log.error("le pseudo n'est pas présent en base");
        }
            return accountRepository.findAccountByMail(mail).orElseThrow(() ->
         new EntityNotFoundException("le pseudo de l'utilisateur n'exisite pas",ErrorCode.USER_NOT_VALID));
    }

}
