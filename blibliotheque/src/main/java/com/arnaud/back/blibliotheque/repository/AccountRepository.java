package com.arnaud.back.blibliotheque.repository;

import com.arnaud.back.blibliotheque.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

     Optional<Account> findAccountByMail(String mail);



}
