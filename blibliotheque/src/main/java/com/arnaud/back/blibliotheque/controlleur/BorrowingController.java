package com.arnaud.back.blibliotheque.controlleur;

import com.arnaud.back.blibliotheque.controlleur.api.BorrowingApi;
import com.arnaud.back.blibliotheque.model.Borrowing;
import com.arnaud.back.blibliotheque.services.BorrowingService;
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
    public Borrowing save(Borrowing borrowing) {
        return borrowingService.save(borrowing);
    }

    @Override
    public List<Borrowing> findAll() {
        return borrowingService.findAll();
    }

    @Override
    public String addExtension(int userid, int borrowingid, boolean available) {
        return borrowingService.addExtension(userid,borrowingid,available);
    }

    @Override
    public List<Borrowing> findAllByAccountId(Integer id) {
        return borrowingService.findAllByAccountId(id);
    }


}
