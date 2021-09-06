package com.arnaud.front.blibliothequeFront.modelFront.auth;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class AuthenticationRequest  {

    private String mail;
    private String password;
    private String pseudo;



    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public AuthenticationRequest(String mail, String password,String pseudo) {
        this.mail = mail;
        this.password = password;
        this.pseudo = pseudo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}

