package com.arnaud.back.blibliotheque.controlleur;

import com.arnaud.back.blibliotheque.controlleur.api.PretApi;
import com.arnaud.back.blibliotheque.model.Pret;
import com.arnaud.back.blibliotheque.services.impl.PretIServicesmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PretController implements PretApi {
    @Autowired
    PretIServicesmpl pretIServicesmpl;

    @Override
    public Pret save(Pret pret) throws Exception {
        Pret valueResturn = pretIServicesmpl.save(pret);
        return valueResturn;
    }
}
