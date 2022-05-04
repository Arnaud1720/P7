package com.arnaud.back.blibliotheque.controlleur.api;

import com.arnaud.back.blibliotheque.model.Borrowing;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.arnaud.back.blibliotheque.constant.Constants.APP_ROOT;

@Api(APP_ROOT)
public interface BorrowingApi {

    @PostMapping(value = APP_ROOT+"/borrowing/save/{accountid}/",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "faire une réservation ",response = Borrowing.class)
    Borrowing save(@RequestBody Borrowing borrowing, @RequestParam(name = "exemplaryid") long exemplaryid,
                   @PathVariable(name = "accountid") Integer accountid,@RequestParam( name = "bookid")Integer bookid);



    @DeleteMapping(value = APP_ROOT+"/delete/borrowing/",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "",response = Borrowing.class)

     void deleteBorrowingById(@RequestBody Borrowing borrowing, @RequestParam(name = "idpret") Integer id,
                              @RequestParam(name = "accountid") Integer accountid,
                              @RequestParam(name = "exemplaryId") long exemplaryId,
                              @RequestParam(name = "bookid")int bookid);



    @PostMapping(value = APP_ROOT+"/borrowing/find/all/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "affiche la liste des réservation en retard ",responseContainer ="List<Borrowing>")
    List<Borrowing> findBorrrowingOutOfTime();

    @PutMapping(value = APP_ROOT+"/borrowing/modify/state",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "check si la reservation est hors délai",response = Borrowing.class)
    void isOutOfTime();



    @GetMapping(value = APP_ROOT+"/borrowing/{accountid}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "affiche les reservation de l'utilisateur",responseContainer = "List<Borrowing>")
    List<Borrowing> findBorrowingByAccountId(@PathVariable(name = "accountid")Integer accountId);

    @GetMapping(value = APP_ROOT+"/borrowing/findall",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "affiche toute les rerservation",responseContainer = "List<Borrowing>")
    List<Borrowing> findall();

    @GetMapping(value = APP_ROOT+"/borrowing/available")
    @ApiOperation(value = "affiche toute les livre indisponible",responseContainer = "List<Borrowing>")
    List<Borrowing> findByAvailable(@RequestParam("available")boolean available);

    @DeleteMapping(APP_ROOT+"/borrowing/delete/outoftime")
    @ApiOperation(value = "supprime les réservation hors delai",response = Borrowing.class)
    void deleteBorrowingByOutOfTimeTrue();
}

