package com.arnaud.back.blibliotheque.repository;


import com.arnaud.back.blibliotheque.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing,Integer> {

    List<Borrowing> findAllByAccountId(Integer id);

}
