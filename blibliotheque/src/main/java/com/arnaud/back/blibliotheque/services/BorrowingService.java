package com.arnaud.back.blibliotheque.services;

import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.Borrowing;

import java.util.List;
import java.util.Optional;

public interface BorrowingService {

    Borrowing save(Borrowing borrowing, Integer bookId, Integer accountId);
    List<Object> findByDateTimeJOrderByDateTimeJ();
    void deleteBorrowingById(Borrowing borrowing,Integer id,Integer accountid,Integer bookid);
    Optional<Account> displayMailEndDateOutofTime(Borrowing borrowing, Integer accountid, Integer bookid);
    List<Borrowing> showLateLoan();
    List<Borrowing> findall();






}
