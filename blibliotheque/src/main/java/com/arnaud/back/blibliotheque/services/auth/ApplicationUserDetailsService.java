package com.arnaud.back.blibliotheque.services.auth;

import com.arnaud.back.blibliotheque.config.utils.ExtendedAccount;
import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.dto.AccountDto;
import com.arnaud.back.blibliotheque.services.AccountService;
import com.arnaud.back.blibliotheque.services.impl.AccountImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountImpl accountImpl;


    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Account account = accountImpl.findAccountByMail(mail);
        List<SimpleGrantedAuthority> authority = new ArrayList<>();
        account.getRoles().forEach(roles -> authority.add(new SimpleGrantedAuthority(roles.getRoleName())));
        return new ExtendedAccount(account.getMail(),account.getPassword(),authority);
    }
}
