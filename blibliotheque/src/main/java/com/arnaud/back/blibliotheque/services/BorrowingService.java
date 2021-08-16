package com.arnaud.back.blibliotheque.services;

import com.arnaud.back.blibliotheque.model.Borrowing;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

public interface BorrowingService {

    Borrowing findById(Integer id);

    Borrowing save(Borrowing borrowing,Integer utilisateurid,Integer exemplaryid);

    List<Borrowing> findAll();


    String addExtension(int userid, int borrowingid,boolean available);

    List<Borrowing> findAllByAccountId(Integer id);

    List<Borrowing> findAllByAccountMail(String mail);
}
