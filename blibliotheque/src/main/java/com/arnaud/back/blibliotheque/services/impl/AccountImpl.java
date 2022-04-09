package com.arnaud.back.blibliotheque.services.impl;

import com.arnaud.back.blibliotheque.exception.EntityNotFoundException;
import com.arnaud.back.blibliotheque.exception.ErrorCode;
import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.dto.AccountDto;
import com.arnaud.back.blibliotheque.repository.AccountRepository;
import com.arnaud.back.blibliotheque.services.AccountService;
import com.arnaud.back.blibliotheque.validator.AccountValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AccountImpl implements AccountService {
    private final AccountRepository accountRepository;
    final PasswordEncoder passwordEncoder;


    @Autowired
    public AccountImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

// GOOD
    @Override
    public AccountDto save(AccountDto accountDto) {
        List<String> erros = AccountValidator.chemaValidator(accountDto);
        if(!erros.isEmpty()){
            log.error("erreur de création de l'utilisateur {}",accountDto);
            throw new EntityNotFoundException("erreur pendant la création du compte", ErrorCode.USER_NOT_VALID,erros);
        }
        else
           accountDto.setPassword(passwordEncoder.encode(accountDto.getPassword()));
            Account saveAccount= accountRepository.save(AccountDto.toEntity(accountDto));
            return AccountDto.fromEntity(saveAccount);
    }


//GOOD
    @Override
    public AccountDto findById(Integer id) {

        if(id == null){
            log.error("Id utilisateur Null");
            return null;
        }
        return  accountRepository.findById(id)
                .map(AccountDto::fromEntity).orElseThrow(()->
                new EntityNotFoundException("aucun utilisateur trouver a l'id"+id+" dans la base de données"));
    }
//GOOD
    @Override
    public void deleteById(Integer id) {
        if(id==null){
            log.error("Id utilisateur null ");
            return;
        }
        accountRepository.deleteById(id);
    }
//GOOD
    @Override
    public AccountDto findByIdAccount(Integer Uid) {
       if(Uid==null){
           return null;
       }
       Optional<Account> account  = accountRepository.findById(Uid);
       //parse
        AccountDto dto = AccountDto.fromEntity(account.get());
        return Optional.of(dto).orElseThrow(()->
                new EntityNotFoundException("aucun utilisateur trouver correspondant a cette id"+Uid));
    }

    @Override
    public Account findAccountByMail(String mail) {


        return accountRepository.findAccountByMail(mail);
    }

//    @Override
//    public AccountDto findAccountByMail(String mail) {
//        if(!StringUtils.hasLength(mail)){
//            log.error("aucun email trouvé");
//        }
//        Optional<Account> account = accountRepository.findAccountByMail(mail);
//        //parse
//        AccountDto dto = AccountDto.fromEntity(account.get());
//        return Optional.of(dto).orElseThrow(()->new EntityNotFoundException("aucun id est lié a cette email"+" "+mail));
//    }

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



