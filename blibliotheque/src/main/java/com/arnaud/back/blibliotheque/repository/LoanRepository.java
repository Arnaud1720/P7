package com.arnaud.back.blibliotheque.repository;


import com.arnaud.back.blibliotheque.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {
    List<Loan> findAllByAccountId(Integer id);

    List<Loan> findAllByAccountMail(String mail);

    List<Loan> findAllByEndDateLessThan(LocalDateTime localDateTime);



}
