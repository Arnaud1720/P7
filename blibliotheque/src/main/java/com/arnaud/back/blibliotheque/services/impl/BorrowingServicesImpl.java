package com.arnaud.back.blibliotheque.services.impl;

import com.arnaud.back.blibliotheque.exception.EntityNotFoundException;
import com.arnaud.back.blibliotheque.exception.ErrorCode;
import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.Borrowing;
import com.arnaud.back.blibliotheque.repository.AccountRepository;
import com.arnaud.back.blibliotheque.repository.BorrowingRepository;
import com.arnaud.back.blibliotheque.services.BorrowingService;
import com.arnaud.back.blibliotheque.validator.BorrowingValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class BorrowingServicesImpl implements BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Borrowing findById(Integer id) {
        if (id == null) {
            log.error("le numéro de la reservation n'exite pas");
            throw new EntityNotFoundException("le numéro de la reservation n'exite pas", ErrorCode.BORROWING_NOT_FOUND);
        }
        return borrowingRepository.findById(id).orElseThrow();
    }

    @Override
    public Borrowing save(Borrowing borrowing) {
        List<String> erros = BorrowingValidator.chemaValidator(borrowing);
        if (!erros.isEmpty()) {
            log.error("erreur de création de l'utilisateur {}", borrowing);
            throw new EntityNotFoundException("erreur pendant la création du compte", ErrorCode.USER_NOT_VALID, erros);
        } else
            return borrowingRepository.save(borrowing);
    }

    @Override
    public List<Borrowing> findAll() {
        return borrowingRepository.findAll();
    }



    @Override
    public String addExtension(int userid, int borrowingid, boolean available) {

        Account user = accountRepository.findById(userid).orElseThrow(()-> new EntityNotFoundException(" message"));
        Borrowing borrowing = borrowingRepository.findById(borrowingid).orElseThrow(()-> new EntityNotFoundException("message"));
        borrowing.setAccount(user);
        if (available) {
            this.addExtension(borrowing);
            borrowing.setExtension(true);
            borrowingRepository.save(borrowing);

            return "vôtre prêt est prolongé de 1 mois";
        } else
            return "do nothing";
    }

    @Override
    public List<Borrowing> findAllByAccountId(Integer id) {
        if(id ==null){
            log.error("--------");
        }
        return borrowingRepository.findAllByAccountId(id);
    }

    /**
     *  ne pas mettre de corrp de méthode dans une interface  la déclaré en privé
     * @param borrowing
     */
    private void addExtension(Borrowing borrowing) {
        LocalDate d1 =  borrowing.getEndDate();
        LocalDate d2 = d1.plusMonths(1);
        borrowing.setEndDate(d2);

    }
}



