package com.arnaud.back.blibliotheque.services;

import com.arnaud.back.blibliotheque.model.Borrowing;

import java.util.List;

public interface BorrowingService {

    Borrowing findById(Integer id);

    Borrowing save(Borrowing borrowing,Integer utilisateurid,Integer exemplaryid);

    List<Borrowing> findAll();


    String addExtension(int userid, int borrowingid,boolean available);

    List<Borrowing> findAllByAccountId(Integer id);

    List<Borrowing> findAllByAccountMail(String mail);

    List<Borrowing>findAllLateBorrowing();


}
