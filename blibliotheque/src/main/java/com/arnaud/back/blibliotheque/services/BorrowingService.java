package com.arnaud.back.blibliotheque.services;

import com.arnaud.back.blibliotheque.model.Borrowing;
import com.arnaud.back.blibliotheque.model.dto.BorrowingDto;

import java.math.BigInteger;
import java.util.List;

public interface BorrowingService {

//    Borrowing save(Borrowing borrowing, Integer bookId, Integer accountId);

    BorrowingDto save(BorrowingDto dto, Integer bookid, Integer accountid);

    List<Borrowing> findByDateTimeJOrderByDateTimeJ();
    void deleteBorrowingById(Borrowing borrowing,Integer id,Integer accountid,Integer bookid);
     List<Borrowing> findBorrrowingOutOfTime();
    void isOutOfTime();
    BigInteger checkDoublon();


}
