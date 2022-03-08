package com.arnaud.back.blibliotheque.repository;


import com.arnaud.back.blibliotheque.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing,Integer> {


    @Query( nativeQuery = true,value = " select * from borrowing  order by date_limite_retour limit 1")
    @Modifying
    List<Borrowing> findByDateTimeJOrderByDateTimeJ();


    @Query(nativeQuery = true, value = "SELECT * FROM borrowing WHERE borrowing.date_limite_retour < ?1 order by  borrowing.date_limite_retour  limit 1 ")
    List<Borrowing> findAllByBookingDateEndLessThan(LocalDateTime dateDuJour);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update borrowing set out_of_time =true WHERE date_limite_retour<now();")
    void isOutOfTime();

    @Query(nativeQuery = true, value = "SELECT count(bookpret_book_id) AS nbr_doublon, bookpret_book_id FROM borrowing group by bookpret_book_id HAVING count(bookpret_book_id)>1;")
    BigInteger checkDoublon();


}
