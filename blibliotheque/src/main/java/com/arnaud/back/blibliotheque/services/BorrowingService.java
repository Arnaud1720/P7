package com.arnaud.back.blibliotheque.services;

import com.arnaud.back.blibliotheque.model.Borrowing;
import com.arnaud.back.blibliotheque.model.Exemplary;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BorrowingService {

    Borrowing findById(Integer id);

    Borrowing save(Borrowing borrowing,Integer utilisateurid,Integer exemplaryid);

    List<Borrowing> findAll();

    String addExtension(int userid, int borrowingid,boolean available);

    List<Borrowing> findAllByAccountId(Integer id);

    List<Borrowing> findAllByAccountMail(String mail);

    List<Borrowing>findAllLateBorrowing();

    void deleteBorrowingByid(Integer id,Integer exemplaryid);

    List<Object[]> findByStartDate();

}
