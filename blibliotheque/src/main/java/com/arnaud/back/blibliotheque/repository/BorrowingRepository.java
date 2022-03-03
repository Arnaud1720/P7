package com.arnaud.back.blibliotheque.repository;


import com.arnaud.back.blibliotheque.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing,Integer> {


    @Query("select p.bookingDate,p.account.id,p.bookpret.bookId from borrowing p order by p.bookingDate")
    List<Object> findByDateTimeJOrderByDateTimeJ();

    List<Borrowing> findAllByBookingDate(LocalDateTime ld);

    @Query(nativeQuery = true, value = "SELECT * FROM borrowing WHERE borrowing.date_limite_retour < ?1 order by  borrowing.date_limite_retour  limit 1 ")
    List<Borrowing> findAllByBookingDateEndLessThan(LocalDateTime dateDuJour);

    @Transactional
    @Modifying
    @Query( nativeQuery = true,value = "delete from borrowing  where borrowing.date_limite_retour < ?1 ")
    void  deleteByBookingDateEndLessThan(LocalDateTime dateDuJour);

}
