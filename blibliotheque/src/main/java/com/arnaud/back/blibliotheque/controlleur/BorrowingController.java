package com.arnaud.back.blibliotheque.controlleur;

import com.arnaud.back.blibliotheque.controlleur.api.BorrowingApi;
import com.arnaud.back.blibliotheque.model.Borrowing;
import com.arnaud.back.blibliotheque.model.Exemplary;
import com.arnaud.back.blibliotheque.services.BorrowingService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class BorrowingController implements BorrowingApi {
    @Autowired
    private BorrowingService borrowingService;

    @Override
    public Borrowing findById(Integer id) {
        return borrowingService.findById(id);
    }

    @Override
    public Borrowing save(Borrowing borrowing,Integer utilisateurid,Integer exemplaryid) {
        Borrowing valueReturn = borrowingService.save(borrowing,utilisateurid,exemplaryid);
        return valueReturn;
    }

    @Override
    public List<Borrowing> findAll() {
        return borrowingService.findAll();
    }

    @Override
    public String addExtension(int userid, int borrowingid,boolean avaible) {
        return borrowingService.addExtension(userid,borrowingid,avaible);
    }

    @Override
    public List<Borrowing> findByAccountId(Integer Uid) {
        List<Borrowing> resultList = borrowingService.findAllByAccountId(Uid);
        return resultList;
    }

    @Override
    public List<Borrowing> findAllLateBorrowing() {
        return borrowingService.findAllLateBorrowing();
    }

    @Override
    public void deleteBorrowingByid(Integer id, Integer exemplaryid) {
        borrowingService.deleteBorrowingByid(id,exemplaryid);
    }



}
