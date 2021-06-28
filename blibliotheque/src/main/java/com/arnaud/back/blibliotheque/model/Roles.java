package com.arnaud.back.blibliotheque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "roles")
public class Roles  extends AbstractEntity {
    @Id
    private Integer id;

    @Column(name = "rolename")
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "id_account")
    private Account account;


}
