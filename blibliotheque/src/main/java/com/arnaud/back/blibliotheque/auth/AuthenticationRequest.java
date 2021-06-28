package com.arnaud.back.blibliotheque.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationRequest  {

    private String mail;
    private String password;


}
