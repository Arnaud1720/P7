package com.arnaud.back.blibliotheque.services.impl;

import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.services.AccountService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountImplTest {

    @Autowired
    AccountService service;

    @Test
    public void shouldSaveAccountWithSuccess(){
     Account accountTestSuccess = Account.builder()
             .id(1)
             .city("Saint-Medard-en-Jalles")
             .fristName("Derisbourg")
                .lastName("Arnaud")
                .mail("derisbourgarnaud@gmail.com")
                .password("12345")
                .phoneNumber("078244739741")
                .postalAdress("2 rue charle chaplin")
                .pseudo("Arnaud1720")

                .build();

    Account savedAccount =  service.save(accountTestSuccess);



      assertNotNull(savedAccount);
        Assertions.assertEquals(accountTestSuccess.getId(),savedAccount.getId());
        Assertions.assertEquals(accountTestSuccess.getCity(),savedAccount.getCity());
        Assertions.assertEquals(accountTestSuccess.getFristName(),savedAccount.getFristName());
        Assertions.assertEquals(accountTestSuccess.getLastName(),savedAccount.getLastName());
        Assertions.assertEquals(accountTestSuccess.getPassword(),savedAccount.getPassword());
        Assertions.assertEquals(accountTestSuccess.getPostalAdress(),savedAccount.getPostalAdress());
        Assertions.assertEquals(accountTestSuccess.getMail(),savedAccount.getMail());
        Assertions.assertEquals(accountTestSuccess.getPseudo(),savedAccount.getPseudo());
        Assertions.assertEquals(accountTestSuccess.getPhoneNumber(),savedAccount.getPhoneNumber());

    }

    /**
     * test logic de l'update
     */

    @Test
    public void shouldSaveAccountWithSuccessUpdate(){
        Account accountTestSuccess = Account.builder()
                .id(1)
                .city("Saint-Medard-en-Jalles")
                .fristName("Derisbourg")
                .lastName("Arnaud")
                .mail("derisbourgarnaud@gmail.com")
                .password("12345")
                .phoneNumber("078244739741")
                .postalAdress("2 rue charle chaplin")
                .pseudo("Arnaud1720")

                .build();

        Account savedAccount =  service.save(accountTestSuccess);
        Account accountToUpadate = savedAccount;
        accountToUpadate.setCity("test_Update_WithClass_Test");
        accountToUpadate.setPhoneNumber("0782739741");
        accountToUpadate.setPassword("12345");

        savedAccount =  service.save(accountToUpadate);


        assertNotNull(savedAccount);
        Assertions.assertEquals(accountToUpadate.getId(),savedAccount.getId());
        Assertions.assertEquals(accountToUpadate.getCity(),savedAccount.getCity());
        Assertions.assertEquals(accountToUpadate.getFristName(),savedAccount.getFristName());
        Assertions.assertEquals(accountToUpadate.getLastName(),savedAccount.getLastName());
        Assertions.assertEquals(accountToUpadate.getPassword(),savedAccount.getPassword());
        Assertions.assertEquals(accountToUpadate.getPostalAdress(),savedAccount.getPostalAdress());
        Assertions.assertEquals(accountToUpadate.getMail(),savedAccount.getMail());
        Assertions.assertEquals(accountToUpadate.getPseudo(),savedAccount.getPseudo());
        Assertions.assertEquals(accountToUpadate.getPhoneNumber(),savedAccount.getPhoneNumber());

    }

//    @Test
//    public void shouldThrowInvalidEntityExeception(){
//        Account accountTestSuccess = Account.builder().build();
//
//        /**
//         * recuperation de l'exception
//         */
//
//        EntityNotFoundException entityNotFoundException = assertThrows(EntityNotFoundException.class, () -> service.save(accountTestSuccess));
//
//        assert
//
//
//
//    }

}