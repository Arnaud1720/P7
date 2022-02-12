package com.arnaud.back.blibliotheque.controlleur.api;

import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.Pret;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.arnaud.back.blibliotheque.constant.Constants.APP_ROOT;

@Api(APP_ROOT)
public interface PretApi {

    @PostMapping(value = APP_ROOT+"/pret/save/{accountid}/{bookid}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregister un pret",response = Pret.class)
    Pret save(@RequestBody Pret pret, @PathVariable(name = "accountid") Integer accountid,
              @PathVariable(name = "bookid") Integer bookid);



    @GetMapping(value = APP_ROOT+"/pret/list/datej",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list des pret par date",responseContainer = "List<Object>")
    List<Object> findByDateTimeJOrderByDateTimeJ();

    @DeleteMapping(value = APP_ROOT+"/delete/pret/",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "",response = Pret.class)

     void deletePretById(@RequestBody Pret pret, @RequestParam(name = "idpret") Integer id,
                         @RequestParam(name = "accountid") Integer accountid,
                         @RequestParam(name = "bookid") Integer bookid);

        @GetMapping(value = APP_ROOT+"/pret/list/",produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "test list date return email",responseContainer = "List<Pret>")
        List<Pret> displayMailEndDateOutofTime(@RequestBody Pret pret,@RequestParam(name = "accountid")
                Integer accountid,@RequestParam(name = "bookid") Integer bookid);


}
