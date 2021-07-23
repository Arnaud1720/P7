package com.arnaud.back.blibliotheque.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private String accesToken;
    private String email;
    private int id;
}
