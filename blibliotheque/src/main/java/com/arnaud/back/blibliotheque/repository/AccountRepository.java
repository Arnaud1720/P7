package com.arnaud.back.blibliotheque.repository;

import com.arnaud.back.blibliotheque.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

     Optional<Account> findByMail(String mail);

}
