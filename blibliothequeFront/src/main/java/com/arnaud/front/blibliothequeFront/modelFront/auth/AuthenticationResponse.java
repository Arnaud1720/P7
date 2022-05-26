package com.arnaud.front.blibliothequeFront.modelFront.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
public class AuthenticationResponse  {
    private String accessToken;
    private String email;
    private Integer id;

    

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public AuthenticationResponse(@JsonProperty("id")Integer id,@JsonProperty("accesToken") String accesToken,@JsonProperty("email") String email) {
        this.accessToken = accesToken;
        this.email = email;
        this.id = id;
    }

    public String getAccesToken() {
        return accessToken;
    }

    public void setAccesToken(String accesToken) {
        this.accessToken = accesToken;
    }

    public Integer getId() {
        return id;
    }
}
