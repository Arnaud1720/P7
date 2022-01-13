package com.arnaud.back.blibliotheque.services.impl;

import com.arnaud.back.blibliotheque.model.Pret;
import com.arnaud.back.blibliotheque.repository.PretRepository;
import com.arnaud.back.blibliotheque.services.PretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;


@Service
public class PretIServicesmpl implements PretService {

    @Autowired
    PretRepository pretRepository;

    @Override
    public Pret save(Pret pret) throws Exception {
        String regExp = "^(.+)@(.+)$";
        if (pret.getEpret().isEmpty()){
            throw new Exception("Email Vide");
        }else
        return pretRepository.save(pret);
    }

}
