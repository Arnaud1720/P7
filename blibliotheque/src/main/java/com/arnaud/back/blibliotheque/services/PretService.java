package com.arnaud.back.blibliotheque.services;

import com.arnaud.back.blibliotheque.model.Pret;

import java.util.List;

public interface PretService {

    Pret save(Pret pret,Integer bookId,Integer accountId);
    List<Object[]> listPretOrderByDateJ();
    List<Object> findByDateTimeJOrderByDateTimeJ();
}
