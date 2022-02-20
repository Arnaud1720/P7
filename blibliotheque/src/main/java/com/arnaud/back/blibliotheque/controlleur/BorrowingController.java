package com.arnaud.back.blibliotheque.controlleur;

import com.arnaud.back.blibliotheque.controlleur.api.BorrowingApi;
import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.Borrowing;
import com.arnaud.back.blibliotheque.services.impl.BorrowingServicesmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BorrowingController implements BorrowingApi {
    @Autowired
    BorrowingServicesmpl borrowingServicesmpl;


    @Override
    public Borrowing save(Borrowing borrowing, Integer bookid, Integer accountid) {
        return borrowingServicesmpl.save(borrowing, accountid, bookid);
    }


    @Override
    public List<Object> findByDateTimeJOrderByDateTimeJ() {
        return borrowingServicesmpl.findByDateTimeJOrderByDateTimeJ();
    }

    @Override
    public void deletePretById(Borrowing borrowing,Integer id, Integer accountid, Integer bookid) {
        borrowingServicesmpl.deleteBorrowingById(borrowing,id,accountid,bookid);
    }

    @Override
    public Optional<Account> displayMailEndDateOutofTime(Borrowing borrowing, Integer accountid, Integer bookid) {
        Optional<Account> borrowingList = borrowingServicesmpl.displayMailEndDateOutofTime(borrowing,accountid,bookid);
        return borrowingList;
    }

    @Override
    public List<Borrowing> showLateLoan() {
        return borrowingServicesmpl.showLateLoan();
    }

    @Override
    public List<Borrowing> findall() {
        return borrowingServicesmpl.findall();
    }


}
