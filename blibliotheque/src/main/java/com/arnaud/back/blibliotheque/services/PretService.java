package com.arnaud.back.blibliotheque.services;

import com.arnaud.back.blibliotheque.model.Pret;

import java.time.LocalDateTime;
import java.util.List;

public interface PretService {

    Pret save(Pret pret,Integer bookId,Integer accountId);
    List<Object> findByDateTimeJOrderByDateTimeJ();
    void deletePretById(Pret pret,Integer id,Integer accountid,Integer bookid);
    List<Pret> displayMailEndDateOutofTime(Pret pret,Integer accountid,Integer bookid);







}
