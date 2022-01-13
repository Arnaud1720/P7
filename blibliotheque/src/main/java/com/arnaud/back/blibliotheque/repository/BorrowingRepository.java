package com.arnaud.back.blibliotheque.repository;


import com.arnaud.back.blibliotheque.model.Borrowing;
import com.arnaud.back.blibliotheque.model.Exemplary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing,Integer> {
    List<Borrowing> findAllByAccountId(Integer id);

    List<Borrowing> findAllByAccountMail(String mail);

    List<Borrowing> findAllByEndDateLessThan(LocalDate localDate);
    @Query("SELECT d.startDate FROM borrowing d ORDER BY d.startDate DESC")
    List<Object[]> findByStartDate();
}
