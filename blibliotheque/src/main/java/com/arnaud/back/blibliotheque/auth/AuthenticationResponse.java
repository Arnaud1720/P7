package com.arnaud.back.blibliotheque.auth;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthenticationResponse {
    private String accesToken;

}
