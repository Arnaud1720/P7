package com.arnaud.back.blibliotheque.services.impl;

import com.arnaud.back.blibliotheque.exception.BorrowingNotValidException;
import com.arnaud.back.blibliotheque.exception.EntityNotFoundException;
import com.arnaud.back.blibliotheque.exception.ErrorCode;
import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.Exemplary;
import com.arnaud.back.blibliotheque.model.Loan;
import com.arnaud.back.blibliotheque.repository.AccountRepository;
import com.arnaud.back.blibliotheque.repository.ExemplaryRepository;
import com.arnaud.back.blibliotheque.repository.LoanRepository;
import com.arnaud.back.blibliotheque.services.LoanService;
import com.arnaud.back.blibliotheque.validator.BorrowingValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class LoanServicesImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    ExemplaryRepository exemplaryRepository;

    @Override
    public Loan findById(Integer id) {
        if (id == null) {
            log.error("le numéro de la reservation n'exite pas");
            throw new EntityNotFoundException("le numéro de la reservation n'exite pas", ErrorCode.BORROWING_NOT_FOUND);
        }
        return loanRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Loan save(Loan loan, Integer utilisateurid, Integer exemplaryid) {
        List<String> erros = BorrowingValidator.chemaValidator(loan);

        Account account = accountRepository.findById(utilisateurid).orElse(null);
        Exemplary exemplary = exemplaryRepository.findById(exemplaryid).orElse(null);
        loan.setAccount(account);
        loan.setExemplaryId(exemplary);
        if (!erros.isEmpty()) {

            throw new EntityNotFoundException("erreur pendant la création de la réservation", ErrorCode.BORROWING_NOT_FOUND, erros);
        } else {
            assert exemplary != null;
            decremente(exemplary);
            if (exemplary.getRemainingexemplary() == 0) {
                    //

            }

        }
        return loanRepository.save(loan);
    }

    /**
     *
     * @param id
     * @param exemplaryid
     * a terminer
     */
    @Override
    public void deleteLoanByid(Integer id, Integer exemplaryid) {
        Exemplary exemplary = exemplaryRepository.findById(exemplaryid).orElse(null);
        assert exemplary != null;
        incremente(exemplary);
        loanRepository.deleteById(id);

    }

    @Override
    public List<Object[]> findByStartDate() {
        return loanRepository.findByStartDate();
    }


    @Override
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }



    @Override
    public String addExtension(int userid, int borrowingid, boolean available) throws BorrowingNotValidException {
        Account user = accountRepository.findById(userid).orElseThrow(() -> new EntityNotFoundException(" l'utilisateur n'existe pas "));
        Loan loan = loanRepository.findById(borrowingid).orElseThrow(() -> new EntityNotFoundException("la réservation n'exite pas"));
        loan.setAccount(user);
        if (available) {
            this.addExtension(loan);
            loan.setExtension(true);

            loanRepository.save(loan);

            return "vôtre prêt est prolongé de 1 mois";
        } else
            return "do nothing";
    }

    @Override
    public List<Loan> findAllByAccountId(Integer id) {
        if (id == null) {
            log.error("--------");
        }
        return loanRepository.findAllByAccountId(id);
    }



    @Override
    public List<Loan> findAllByAccountMail(String mail) {
        return loanRepository.findAllByAccountMail(mail);
    }

    @Override
    public List<Loan> findAllLateLoan() {
        LocalDate dt = LocalDate.now();
        return loanRepository.findAllByEndDateLessThan(dt);

    }



    /**
     * ne pas mettre de corrp de méthode dans une interface  la déclaré en privé
     *
     * @param loan
     */

    private void addExtension(Loan loan) {
        LocalDate d1 = loan.getEndDate();
        LocalDate d2 = d1.plusMonths(1);
        loan.setEndDate(d2);
        if (loan.isExtension()) {
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