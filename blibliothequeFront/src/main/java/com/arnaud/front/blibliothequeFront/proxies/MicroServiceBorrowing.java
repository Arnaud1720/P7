package com.arnaud.front.blibliothequeFront.proxies;

import com.arnaud.front.blibliothequeFront.exception.BorrowingNotValidException;
import com.arnaud.front.blibliothequeFront.modelFront.Borrowingfront;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.arnaud.front.blibliothequeFront.configuration.constant.APP_ROOT;

@FeignClient(name = "microserviceBorrowing", url = "localhost:8001")
public interface MicroServiceBorrowing {

    @PostMapping(value = APP_ROOT+"/borrowing/save/{accountid}/{bookid}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @Headers("Content-type:application/json")
    Borrowingfront save(@RequestBody Borrowingfront borrowingfront, @PathVariable(name = "accountid") Integer accountid,
                        @PathVariable(name = "bookid") Integer bookid);


    @GetMapping(value = APP_ROOT + "/{utilisateurid}/{loanid}", produces = MediaType.APPLICATION_JSON_VALUE)
    String addExtension(@PathVariable(name = "utilisateurid") int userid,
                        @PathVariable(name = "loanid") int loanid, @RequestParam(value = "available") boolean available) throws BorrowingNotValidException;


    @GetMapping(value = APP_ROOT+"/borrowing/{accountid}",produces = MediaType.APPLICATION_JSON_VALUE)
    List<Borrowingfront> findBorrowingByAccountId(@PathVariable(name = "accountid")Integer accountId);

    @DeleteMapping(value = APP_ROOT+"/delete/borrowing/",produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteBorrowingById(@RequestParam(name = "idpret") Integer id,
                             @RequestParam(name = "accountid") Integer accountid,
                             @RequestParam(name = "exemplaryId") Integer exemplaryId);

    @GetMapping(value = APP_ROOT+"/borrowing/available")
    List<Borrowingfront> findByAvailable(@RequestParam("available")boolean available);

}
