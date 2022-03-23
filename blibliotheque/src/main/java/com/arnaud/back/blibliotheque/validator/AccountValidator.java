package com.arnaud.back.blibliotheque.validator;

import com.arnaud.back.blibliotheque.model.dto.AccountDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AccountValidator {

    public static List<String> chemaValidator(AccountDto account){
        List<String> chemaErros = new ArrayList<>();

        if(account  == null || !StringUtils.hasLength(account.getLastName())){
            chemaErros.add("veuillez renseigner le nom de l'utilisateur");
        }

        if(account  == null || !StringUtils.hasLength(account.getFristName())){
            chemaErros.add("veuillez renseigner le prenom de l'utilisateur");
        }

        if(account  == null || !StringUtils.hasLength(account.getMail())){
            chemaErros.add("veuillez renseigner le mail de l'utilisateur");
        }

        if(account  == null || !StringUtils.hasLength(account.getPassword())){
            chemaErros.add("veuillez renseigner le mot de passe de l'utilisateur");
        }

        if(account  == null || !StringUtils.hasLength(account.getPhoneNumber())){
            chemaErros.add("veuillez renseigner le numero de téléphone de l'utilisateur");
        }

        if(account  == null || !StringUtils.hasLength(account.getPostalAdress())){
            chemaErros.add("veuillez renseigner l'adresse postal de  l'utilisateur");
        }


        return chemaErros;

    }
}
