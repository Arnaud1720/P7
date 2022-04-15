package com.arnaud.back.blibliotheque.repository;

import com.arnaud.back.blibliotheque.model.Exemplary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExemplaryRepository extends JpaRepository<Exemplary,Long> {
    @Query(nativeQuery = true, value = " SELECT exemplairenumber  from exemplary where book_book_id = ?1")
    List<Exemplary> findRemainingExemplaryByBookId(Integer bookid);
    // recupére une liste D'exemplaire ( findAllByBookId )
}
