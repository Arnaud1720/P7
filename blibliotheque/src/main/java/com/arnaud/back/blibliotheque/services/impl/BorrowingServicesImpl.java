package com.arnaud.back.blibliotheque.services.impl;

import com.arnaud.back.blibliotheque.exception.BorrowingNotValidException;
import com.arnaud.back.blibliotheque.exception.EntityNotFoundException;
import com.arnaud.back.blibliotheque.exception.ErrorCode;
import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.Borrowing;
import com.arnaud.back.blibliotheque.model.Exemplary;
import com.arnaud.back.blibliotheque.repository.AccountRepository;
import com.arnaud.back.blibliotheque.repository.BorrowingRepository;
import com.arnaud.back.blibliotheque.repository.ExemplaryRepository;
import com.arnaud.back.blibliotheque.services.AccountService;
import com.arnaud.back.blibliotheque.services.BorrowingService;
import com.arnaud.back.blibliotheque.validator.BorrowingValidator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
public class BorrowingServicesImpl implements BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    ExemplaryRepository exemplaryRepository;

    @Override
    public Borrowing findById(Integer id) {
        if (id == null) {
            log.error("le numéro de la reservation n'exite pas");
            throw new EntityNotFoundException("le numéro de la reservation n'exite pas", ErrorCode.BORROWING_NOT_FOUND);
        }
        return borrowingRepository.findById(id).orElseThrow();
    }

    @Override
    public Borrowing save(Borrowing borrowing, Integer utilisateurid, Integer exemplaryid) {
        List<String> erros = BorrowingValidator.chemaValidator(borrowing);

        Account account = accountRepository.findById(utilisateurid).orElse(null);
        Exemplary exemplary = exemplaryRepository.findById(exemplaryid).orElse(null);
        borrowing.setAccount(account);
        borrowing.setExemplaryId(exemplary);
        if (!erros.isEmpty()) {

            throw new EntityNotFoundException("erreur pendant la création de la réservation", ErrorCode.BORROWING_NOT_FOUND, erros);
        } else {
            assert exemplary != null;
            decremente(exemplary);
            if (exemplary.getExemplaryNumbers() <= 0) {
                throw new EntityNotFoundException("ce livre n'est plus disponible");

            }
        }
        return borrowingRepository.save(borrowing);
    }

    /**
     *
     * @param id
     * @param exemplaryid
     * a terminer
     */
    @Override
    public void deleteBorrowingByid(Integer id,Integer exemplaryid) {
        Exemplary exemplary = exemplaryRepository.findById(exemplaryid).orElse(null);
        assert exemplary != null;
        incremente(exemplary);
        borrowingRepository.deleteById(id);

    }

    @Override
    public List<Borrowing> findAll() {
        return borrowingRepository.findAll();
    }


    @Override
    public String addExtension(int userid, int borrowingid, boolean available) throws BorrowingNotValidException {
        Account user = accountRepository.findById(userid).orElseThrow(() -> new EntityNotFoundException(" l'utilisateur n'existe pas "));
        Borrowing borrowing = borrowingRepository.findById(borrowingid).orElseThrow(() -> new EntityNotFoundException("la réservation n'exite pas"));
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
        if (id == null) {
            log.error("--------");
        }
        return borrowingRepository.findAllByAccountId(id);
    }

    @Override
    public List<Borrowing> findAllByAccountMail(String mail) {
        return borrowingRepository.findAllByAccountMail(mail);
    }

    @Override
    public List <Borrowing> findAllLateBorrowing() {
        LocalDate dt = LocalDate.now();
        return borrowingRepository.findAllByEndDateLessThan(dt);

    }



    /**
     * ne pas mettre de corrp de méthode dans une interface  la déclaré en privé
     *
     * @param borrowing
     */

    private void addExtension(Borrowing borrowing) {
        LocalDate d1 = borrowing.getEndDate();
        LocalDate d2 = d1.plusMonths(1);
        borrowing.setEndDate(d2);
        if (borrowing.isExtension()) {
            throw new BorrowingNotValidException("le prêt ne peut être prolongé que de 1 mois", ErrorCode.IMPOSSIBLE_ADD_EXTENSION);
        }

    }

    private void decremente(Exemplary exemplary) {
        exemplary.setRemainingexemplary(exemplary.getRemainingexemplary() - 1);
    }

    private void incremente(Exemplary exemplary) {
        exemplary.setRemainingexemplary(exemplary.getRemainingexemplary() + 1);
    }

}