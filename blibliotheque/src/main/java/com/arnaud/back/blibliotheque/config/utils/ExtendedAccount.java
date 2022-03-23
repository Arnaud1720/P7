package com.arnaud.back.blibliotheque.config.utils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class ExtendedAccount extends User {

    public ExtendedAccount(String mail, String password, Collection<? extends GrantedAuthority> authorities) {
        super(mail, password, authorities);
    }

    public ExtendedAccount(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }


}
