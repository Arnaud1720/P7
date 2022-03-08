package com.arnaud.back.blibliotheque.controlleur;

import com.arnaud.back.blibliotheque.controlleur.api.BorrowingApi;
import com.arnaud.back.blibliotheque.model.Borrowing;
import com.arnaud.back.blibliotheque.services.impl.BorrowingServicesmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
public class BorrowingController implements BorrowingApi {
    @Autowired
    BorrowingServicesmpl borrowingServicesmpl;


    @Override
    public Borrowing save(Borrowing borrowing, Integer bookid, Integer accountid) {
        return borrowingServicesmpl.save(borrowing, accountid, bookid);
    }


    @Override
    public List<Borrowing> findByDateTimeJOrderByDateTimeJ() {
        return borrowingServicesmpl.findByDateTimeJOrderByDateTimeJ();
    }

    @Override
    public void deletePretById(Borrowing borrowing,Integer id, Integer accountid, Integer bookid) {
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
    public BigInteger checkDoublon() {
       return borrowingServicesmpl.checkDoublon();
    }


}
