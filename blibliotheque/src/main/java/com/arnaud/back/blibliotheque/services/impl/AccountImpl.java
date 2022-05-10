package com.arnaud.back.blibliotheque.services.impl;

import com.arnaud.back.blibliotheque.exception.EntityNotFoundException;
import com.arnaud.back.blibliotheque.exception.ErrorCode;
import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.Roles;
import com.arnaud.back.blibliotheque.repository.AccountRepository;
import com.arnaud.back.blibliotheque.repository.RolesRepository;
import com.arnaud.back.blibliotheque.services.AccountService;
import com.arnaud.back.blibliotheque.validator.AccountValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
@Slf4j
@Service
@Transactional(rollbackOn = Exception.class)
public class AccountImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public Account save(Account account) {
        List<String> erros = AccountValidator.chemaValidator(account);
        if(!erros.isEmpty()){
            log.error("erreur de création de l'utilisateur {}",account);
            throw new EntityNotFoundException("erreur pendant la création du compte", ErrorCode.USER_NOT_VALID,erros);
        }
        else
           account.setPassword(passwordEncoder.encode(account.getPassword()));
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

    public static boolean isValidEmail( String email ) {
        String regExp = "^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$";
        return email.matches( regExp );
    }

    /**
     *
     * @param email
     * @throws Exception
     */
    @Override
    public void validationEmail(String email) throws Exception {
        if(email != null && email.length() !=0){
            if(!isValidEmail(email)){
                log.info("do nothing");
            }
        }else
            throw new Exception( "Merci de saisir une adresse mail." );
    }

    @Override
    public void validationMotsDePasse(String password) throws Exception {
        if (password != null && password.length() != 0) {
            if (password.length() <5) {
                throw new Exception("Les mots de passe doivent contenir au moins 5 caractères.");
            }
        }
    }

    }



