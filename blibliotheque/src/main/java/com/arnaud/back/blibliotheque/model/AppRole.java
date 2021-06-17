package com.arnaud.back.blibliotheque.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "App_Role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_ROLE_UK", columnNames = "Role_Name") })
public class AppRole{

    @Id
    @GeneratedValue
    @Column(name = "Role_Id", nullable = false)
    private int roleId;

    @Column(name = "Role_Name", length = 30, nullable = false)
    private String roleName;
    @javax.persistence.Id
    private Integer id;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
