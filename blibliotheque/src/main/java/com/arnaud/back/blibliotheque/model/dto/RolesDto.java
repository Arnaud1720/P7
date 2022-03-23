package com.arnaud.back.blibliotheque.model.dto;

import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class RolesDto {

    @Column(name = "id")
    private Integer id;
    @Column(name = "role_name")
    private String roleName;
    private Account account;

    public static RolesDto fromEntity(Roles roles) {
        if (roles == null) {
            return null;
        }
        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .build();
    }

    public static Roles toEntity(RolesDto dto) {
        if(dto==null){
            return null;
        }
        Roles roles = new Roles();
        roles.setId(roles.getId());
        roles.setRoleName(roles.getRoleName());
        roles.setAccount(roles.getAccount());
        return roles;
    }
}
