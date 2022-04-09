package com.arnaud.back.blibliotheque.controlleur;

import com.arnaud.back.blibliotheque.controlleur.api.BorrowingApi;
import com.arnaud.back.blibliotheque.model.Borrowing;
import com.arnaud.back.blibliotheque.model.dto.BorrowingDto;
import com.arnaud.back.blibliotheque.services.impl.BorrowingServicesmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
public class BorrowingController implements BorrowingApi {
    final BorrowingServicesmpl borrowingServicesmpl;
    @Autowired
    public BorrowingController(BorrowingServicesmpl borrowingServicesmpl) {
        this.borrowingServicesmpl = borrowingServicesmpl;
    }

    @Override
    public BorrowingDto saveDto(BorrowingDto dto, Integer bookid, Integer accountid) {
        return borrowingServicesmpl.save(dto,bookid,accountid);
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
