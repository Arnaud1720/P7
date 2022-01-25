package com.arnaud.back.blibliotheque.services;

import com.arnaud.back.blibliotheque.model.Pret;

public interface PretService {

    Pret save(Pret pret,Integer bookId,Integer accountId);
}
