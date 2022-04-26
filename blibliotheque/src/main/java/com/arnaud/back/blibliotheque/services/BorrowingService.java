package com.arnaud.back.blibliotheque.services;

import com.arnaud.back.blibliotheque.model.Borrowing;

import java.util.List;

public interface BorrowingService {

    Borrowing save(Borrowing borrowing, long exemplaryId, Integer accountid,Integer bookid);
    void deleteBorrowingById(Borrowing borrowing,Integer id,Integer accountid,long exemplaryId,int bookid);
     List<Borrowing> findBorrrowingOutOfTime();
    void isOutOfTime();
    List<Borrowing> findAllByAccountId(Integer id);
    List<Borrowing> findall();
    List<Borrowing> findAllByBookAvailable(boolean available);

}
