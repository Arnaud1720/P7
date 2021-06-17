package com.arnaud.back.blibliotheque.services.auth;

import com.arnaud.back.blibliotheque.exception.EntityNotFoundException;
import com.arnaud.back.blibliotheque.exception.ErrorCode;
import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
      Account account = accountRepository.findByMail(mail).
              orElseThrow(() -> new EntityNotFoundException("le mail ou le mot de passe est invalide"
              ,ErrorCode.MAIL_OR_PASSWORD_INVALID));
        return new User(account.getMail(),account.getPassword(), Collections.emptyList());
    }
}
