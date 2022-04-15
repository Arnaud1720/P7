package com.arnaud.back.blibliotheque.controlleur;

import com.arnaud.back.blibliotheque.controlleur.api.LoanApi;
import com.arnaud.back.blibliotheque.model.Loan;
import com.arnaud.back.blibliotheque.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class LoanController implements LoanApi {
    @Autowired
    private LoanService loanService;

    @Override
    public Loan findById(Integer id) {
        return loanService.findById(id);
    }

    @Override
    public Loan save(Loan loan,Integer utilisateurid,Long exemplaryid) {
        Loan valueReturn = loanService.save(loan,utilisateurid,exemplaryid);
        return valueReturn;
    }

    @Override
    public List<Loan> findAll() {
        return loanService.findAll();
    }

    @Override
    public String addExtension(int userid, int loanid,boolean avaible) {
        return loanService.addExtension(userid,loanid,avaible);
    }

    @Override
    public List<Loan> findByAccountId(Integer Uid) {
        List<Loan> resultList = loanService.findAllByAccountId(Uid);
        return resultList;
    }


    @Override
    public List<Loan> findAllLateLoan() {
        return loanService.findAllLateLoan();
    }

    @Override
    public void deleteLoanByid(Integer id, Long exemplaryid) {
        loanService.deleteLoanByid(id,exemplaryid);

    }

    @Override
    public List<Object[]> findByStartDate() {
        List<Object[]> resulDateList = loanService.findByStartDate();
        return resulDateList;
    }


}
