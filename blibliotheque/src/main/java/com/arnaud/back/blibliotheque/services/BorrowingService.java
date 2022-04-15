package com.arnaud.back.blibliotheque.services;

import com.arnaud.back.blibliotheque.model.Borrowing;

import java.util.List;

public interface BorrowingService {

    Borrowing save(Borrowing borrowing, Long exemplaryId, Integer accountid);
    void deleteBorrowingById(Borrowing borrowing,Integer id,Integer accountid,Long exemplaryId);
     List<Borrowing> findBorrrowingOutOfTime();
    void isOutOfTime();
    List<Borrowing> findAllByAccountId(Integer id);
    List<Borrowing> findall();
    List<Borrowing> findAllByBookAvailable(boolean available);

}
