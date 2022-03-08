package com.arnaud.back.blibliotheque.controlleur.api;

import com.arnaud.back.blibliotheque.model.Borrowing;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

import static com.arnaud.back.blibliotheque.constant.Constants.APP_ROOT;

@Api(APP_ROOT)
public interface BorrowingApi {

    @PostMapping(value = APP_ROOT+"/borrowing/save/{accountid}/{bookid}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "faire une réservation ",response = Borrowing.class)
    Borrowing save(@RequestBody Borrowing borrowing, @PathVariable(name = "bookid") Integer bookid,
                   @PathVariable(name = "accountid") Integer accountid
                   );



    @GetMapping(value = APP_ROOT+"/borrowing/list/datej",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list des borrowing par date",responseContainer = "List<Borrowing>")
    List<Borrowing> findByDateTimeJOrderByDateTimeJ();

    @DeleteMapping(value = APP_ROOT+"/delete/borrowing/",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "",response = Borrowing.class)

     void deletePretById(@RequestBody Borrowing borrowing, @RequestParam(name = "idpret") Integer id,
                         @RequestParam(name = "accountid") Integer accountid,
                         @RequestParam(name = "bookid") Integer bookid);



    @PostMapping(value = APP_ROOT+"/borrowing/find/all/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "affiche la liste des réservation en retard ",responseContainer ="List<Borrowing>")
    List<Borrowing> findBorrrowingOutOfTime();

    @PutMapping(value = APP_ROOT+"/borrowing/modify/state",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "check si la reservation est hors délai",response = Borrowing.class)
    void isOutOfTime();

    @GetMapping(value = APP_ROOT+"/borrowing/check",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "vérifie les doublon",response = Borrowing.class)
    BigInteger checkDoublon();

}

