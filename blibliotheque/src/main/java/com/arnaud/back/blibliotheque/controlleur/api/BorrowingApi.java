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

    @PostMapping(value = APP_ROOT+"/borrowing/save/{accountid}/{bookid}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "faire une réservation ",response = Borrowing.class)
    Borrowing save(@RequestBody Borrowing borrowing, @PathVariable(name = "bookid") Integer bookid,
                   @PathVariable(name = "accountid") Integer accountid
                   );



    @GetMapping(value = APP_ROOT+"/borrowing/list/datej",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list des borrowing par date",responseContainer = "List<Object>")
    List<Object> findByDateTimeJOrderByDateTimeJ();

    @DeleteMapping(value = APP_ROOT+"/delete/borrowing/",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "",response = Borrowing.class)

     void deletePretById(@RequestBody Borrowing borrowing, @RequestParam(name = "idpret") Integer id,
                         @RequestParam(name = "accountid") Integer accountid,
                         @RequestParam(name = "bookid") Integer bookid);



    @PostMapping(value = APP_ROOT+"/borrowing/find/all/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "affiche la liste des réservation ",responseContainer ="List<Borrowing>")
    List<Borrowing> findAllByBookingDate();

    /**
     * //TODO a modifier !
     */
}

