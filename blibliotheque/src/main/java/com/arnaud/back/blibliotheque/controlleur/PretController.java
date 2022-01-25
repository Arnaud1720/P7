package com.arnaud.back.blibliotheque.controlleur;

import com.arnaud.back.blibliotheque.controlleur.api.PretApi;
import com.arnaud.back.blibliotheque.model.Pret;
import com.arnaud.back.blibliotheque.services.impl.PretServicesmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PretController implements PretApi {
    @Autowired
    PretServicesmpl pretServicesmpl;



    @Override
    public Pret save(Pret pret, Integer accountid, Integer bookid) {
        return pretServicesmpl.save(pret,accountid,bookid);
    }
}
