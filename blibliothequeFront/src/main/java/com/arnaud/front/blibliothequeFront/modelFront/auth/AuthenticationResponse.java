package com.arnaud.front.blibliothequeFront.modelFront.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class AuthenticationResponse  {
    private String accesToken;
    private String email;
    private String id;


    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public AuthenticationResponse(@JsonProperty("id")String id,@JsonProperty("accesToken") String accesToken,@JsonProperty("email") String email) {
        this.accesToken = accesToken;
        this.email = email;
        this.id = id;
    }

    public String getAccesToken() {
        return accesToken;
    }

    public void setAccesToken(String accesToken) {
        this.accesToken = accesToken;
    }

    public String getId() {
        return id;
    }
}
