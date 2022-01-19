package com.arnaud.back.blibliotheque.services.impl;

import com.arnaud.back.blibliotheque.model.Pret;
import com.arnaud.back.blibliotheque.repository.PretRepository;
import com.arnaud.back.blibliotheque.services.PretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PretServicesmpl implements PretService {

    @Autowired
    PretRepository pretRepository;

    @Override
    public Pret save(Pret pret) throws Exception {

        return pretRepository.save(pret);
    }

    @Override
    public List<Pret> findByDebutDatePret() {
        return pretRepository.listByDateDebut();
    }


}
