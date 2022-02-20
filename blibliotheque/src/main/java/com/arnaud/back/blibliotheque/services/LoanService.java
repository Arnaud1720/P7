package com.arnaud.back.blibliotheque.services;

import com.arnaud.back.blibliotheque.model.Loan;

import java.util.List;

public interface LoanService {

    Loan findById(Integer id);

    Loan save(Loan loan, Integer utilisateurid, Integer exemplaryid);

    List<Loan> findAll();

    String addExtension(int userid, int loanid,boolean available);

    List<Loan> findAllByAccountId(Integer id);

    List<Loan> findAllByAccountMail(String mail);

    List<Loan> findAllLateLoan();

    void deleteLoanByid(Integer id, Integer exemplaryid);

    List<Object[]> findByStartDate();

}
