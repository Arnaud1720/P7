package com.arnaud.back.blibliotheque.repository;

import com.arnaud.back.blibliotheque.model.Pret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PretRepository extends JpaRepository<Pret,Integer> {
//        List<LocalDateTime> slectAllLocalDateTime;
    @Query("SELECT p.debutDatePret from pret p order by p.debutDatePret")
    List<Pret> listByDateDebut();
}
