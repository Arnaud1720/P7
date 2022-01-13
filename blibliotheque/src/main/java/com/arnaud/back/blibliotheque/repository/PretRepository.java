package com.arnaud.back.blibliotheque.repository;

import com.arnaud.back.blibliotheque.model.Pret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PretRepository extends JpaRepository<Pret,Integer> {

}
