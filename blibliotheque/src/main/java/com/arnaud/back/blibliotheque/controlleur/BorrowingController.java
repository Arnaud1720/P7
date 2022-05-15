package com.arnaud.back.blibliotheque.controlleur;

import com.arnaud.back.blibliotheque.controlleur.api.BorrowingApi;
import com.arnaud.back.blibliotheque.model.Borrowing;
import com.arnaud.back.blibliotheque.services.impl.BorrowingServicesmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BorrowingController implements BorrowingApi {
    @Autowired
    BorrowingServicesmpl borrowingServicesmpl;


    @Override
    public Borrowing save(Borrowing borrowing, long exemplaryid, Integer accountid, Integer bookid) {
        return borrowingServicesmpl.save(borrowing, exemplaryid, accountid,bookid );
    }

    @Override
    public void deleteBorrowingById(Borrowing borrowing, Integer id, Integer accountid, int bookid) {
        borrowingServicesmpl.deleteBorrowingById(borrowing,id,accountid,bookid);
    }


    @Override
    public List<Borrowing> findBorrrowingOutOfTime() {
        return borrowingServicesmpl.findBorrrowingOutOfTime();
    }

    @Override
    public void isOutOfTime() {
        borrowingServicesmpl.isOutOfTime();
    }

    @Override
    public List<Borrowing> findBorrowingByAccountId(Integer accountId) {
        return borrowingServicesmpl.findAllByAccountId(accountId);
    }

    @Override
    public List<Borrowing> findall() {
        return borrowingServicesmpl.findall();
    }

    @Override
    public List<Borrowing> findByAvailable(boolean available) {
        return borrowingServicesmpl.findAllByBookAvailable(available);
    }

    @Override
    public void deleteBorrowingByOutOfTimeTrue() {
        borrowingServicesmpl.deleteBorrowingByOutOfTimeTrue();
    }


}
