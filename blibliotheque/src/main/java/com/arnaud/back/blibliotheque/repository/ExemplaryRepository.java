package com.arnaud.back.blibliotheque.repository;

import com.arnaud.back.blibliotheque.model.Exemplary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExemplaryRepository extends JpaRepository<Exemplary,Integer> {
}
