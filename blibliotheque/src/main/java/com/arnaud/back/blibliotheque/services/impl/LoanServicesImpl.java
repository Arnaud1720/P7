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
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class LoanServicesImpl implements LoanService {

    private final LoanRepository loanRepository;

    private final AccountRepository accountRepository;

    final ExemplaryRepository exemplaryRepository;

    private final JavaMailSenderImpl javaMailSenderImpl;


    public LoanServicesImpl(LoanRepository loanRepository, AccountRepository accountRepository, ExemplaryRepository exemplaryRepository, JavaMailSenderImpl javaMailSenderImpl) {
        this.loanRepository = loanRepository;
        this.accountRepository = accountRepository;
        this.exemplaryRepository = exemplaryRepository;
        this.javaMailSenderImpl = javaMailSenderImpl;
    }


    @Override
    public Loan findById(Integer id) {
        if (id == null) {
            log.error("le numéro de la reservation n'exite pas");
            throw new EntityNotFoundException("le numéro de la reservation n'exite pas", ErrorCode.BORROWING_NOT_FOUND);
        }
        return loanRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Loan save(Loan loan, Integer utilisateurid, long exemplaryid) {
        List<String> erros = BorrowingValidator.chemaValidator(loan);
        LocalDateTime d2 = LocalDateTime.now();
        Account account = accountRepository.findById(utilisateurid).orElse(null);
        Exemplary exemplary = exemplaryRepository.findById(exemplaryid).orElse(null);
        loan.setAccount(account);
        loan.setExemplaryId(exemplary);
        Optional<Loan> loans = loanRepository.findById(Math.toIntExact(exemplaryid));
        if (!erros.isEmpty()) {

            throw new EntityNotFoundException("erreur pendant la création de la réservation", ErrorCode.BORROWING_NOT_FOUND, erros);
        } else {
            assert exemplary != null;
            decremente(exemplary);
        }
        if(loan.getEndDate().getYear()>d2.getYear()){
            throw new EntityNotFoundException("l'année ne peu pas dépassé 2022",ErrorCode.LOAN_YEAR_INVALID);
        }else if (loan.getStartDate().getYear()>d2.getYear()){
            throw new EntityNotFoundException("l'année ne peu pas dépassé 2022",ErrorCode.LOAN_YEAR_INVALID);
        }
        return loanRepository.save(loan);
    }

    /**
     *  @param id
     * @param exemplaryid
     */
    @Override
    public void deleteLoanByid(Integer id, long exemplaryid) {
        Exemplary exemplary = exemplaryRepository.findById(exemplaryid).orElse(null);
        assert exemplary != null;
        incremente(exemplary);
        loanRepository.deleteById(id);

    }


    @Override
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }



    @Override
    public Loan addExtension(int userid, int loanid, boolean available) throws BorrowingNotValidException {

        Account account = accountRepository.findById(userid).orElseThrow(() -> new EntityNotFoundException(" l'utilisateur n'existe pas "));
        Loan loan = loanRepository.findById(loanid).orElseThrow(() -> new EntityNotFoundException("le pret n'exite pas"));
        loan.setAccount(account);
        LocalDateTime d1 = loan.getEndDate();
        LocalDateTime d2 = LocalDateTime.now();
        if (d1.isBefore(d2)){
            throw new EntityNotFoundException("la date de fin est dépassé vous ne pouvez pas prolonger",ErrorCode.IMPOSSIBLE_ADD_EXTENSION);
        }else if (available) {
            this.addExtension(loan);
            loan.setExtension(true);
        }
        javaMailSenderImpl.sendEmail(account.getMail()," prêt au nom de"+ " " +account.getFristName()+" "+account.getLastName()
                ,"vôtre prêt a été prolongé de 1 mois votre nouvelle date de retour : "+" "+loan.getEndDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
           return loanRepository.save(loan);

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
        LocalDateTime dt = LocalDateTime.now();
        return loanRepository.findAllByEndDateLessThan(dt);

    }



    /**
     * ne pas mettre de corrp de méthode dans une interface  la déclaré en privé
     *
     * @param loan
     */

    private void addExtension(Loan loan) {
        LocalDateTime d1 = loan.getEndDate();
        LocalDateTime d2 = d1.plusMonths(1);
        loan.setEndDate(LocalDateTime.from(d2));
        if (loan.isExtension()) {
            throw new BorrowingNotValidException("le prêt ne peut être prolongé que de 1 mois", ErrorCode.IMPOSSIBLE_ADD_EXTENSION);
        }

    }

    private void decremente(Exemplary exemplary) {
        exemplary.setRemainingexemplary(exemplary.getRemainingexemplary() - 1);
        if(exemplary.getRemainingexemplary()<0){
            exemplary.setRemainingexemplary(0);
        }
    }

    private void incremente(Exemplary exemplary) {
        exemplary.setRemainingexemplary(exemplary.getRemainingexemplary() + 1);
    }

}