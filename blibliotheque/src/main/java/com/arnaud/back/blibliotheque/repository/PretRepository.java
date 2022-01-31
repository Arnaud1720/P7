package com.arnaud.back.blibliotheque.repository;

import com.arnaud.back.blibliotheque.model.Pret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PretRepository extends JpaRepository<Pret,Integer> {
    @Query("select p.account,p.bookpret,p.dateTimeJ from pret p ORDER BY p.dateTimeJ")
    List<Object[]> listPretOrderByDateJ();
    @Query("select p.dateTimeJ,p.bookpret.bookId,p.account.id from pret p order by p.dateTimeJ")
    List<Object> findByDateTimeJOrderByDateTimeJ();
}
