package com.arnaud.back.blibliotheque.repository;

import com.arnaud.back.blibliotheque.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
     @Query("select a from Account a where a.mail = :mail ")
     Optional<Account> findAccountByMail(String mail);
     List<Account> findAllByMail();



}
