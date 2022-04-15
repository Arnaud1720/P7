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
    public Borrowing save(Borrowing borrowing, Long exemplaryid, Integer accountid) {
        return borrowingServicesmpl.save(borrowing, exemplaryid, accountid);
    }

    @Override
    public void deleteBorrowingById(Borrowing borrowing, Integer id, Integer accountid, Long exemplaryId) {
        borrowingServicesmpl.deleteBorrowingById(borrowing,id,accountid,exemplaryId);
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


}
