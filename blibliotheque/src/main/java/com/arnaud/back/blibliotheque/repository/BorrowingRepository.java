package com.arnaud.back.blibliotheque.repository;


import com.arnaud.back.blibliotheque.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing,Integer> {


    @Query("select p.dateTimeJ,p.account.id,p.bookpret.bookId from borrowing p order by p.dateTimeJ")
    List<Object> findByDateTimeJOrderByDateTimeJ();
    List<Borrowing> findAllByDateTimeFin(LocalDateTime localDateTime);


}
