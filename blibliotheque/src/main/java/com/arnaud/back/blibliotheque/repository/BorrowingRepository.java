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

    /**
     *
     * @param dateDuJour
     * @return les réservation dont la date de fin est plus petite que la date du jour (limit 1 )
     */
    @Query(nativeQuery = true, value = "SELECT * FROM borrowing WHERE borrowing.date_limite_retour < ?1 order by  borrowing.date_limite_retour  limit 1 ")
    List<Borrowing> findAllByBookingDateEndLessThan(LocalDateTime dateDuJour);

    @Transactional
    @Modifying
    /**
     * vérifie si la valeur ne dépase pas la date limite si c'est le cas out_of_times passe a true
     */
    @Query(nativeQuery = true,value = "update borrowing set out_of_time =true WHERE date_limite_retour<now();")
    void isOutOfTime();

    /**
     *
     * @param id
     * @return toute les reservation d'un compte
     */
    List<Borrowing> findAllByAccountId(int id);

    @Query("select b from borrowing b where b.book.available = ?1")
    List<Borrowing> findAllByBookAvailable(boolean available);

    int countBorrowingByBookBookId(int bookid);

    @Modifying
    @Query(nativeQuery = true,value = "update borrowing set cmpt= cmpt-1 where book_id = ?1")
    @Transactional
    void updateCmptBorrowing(int bookid);

    int countByBook_BookId(int bookid);

    @Modifying
    @Transactional
    void deleteBorrowingByOutOfTimeTrue();


}
