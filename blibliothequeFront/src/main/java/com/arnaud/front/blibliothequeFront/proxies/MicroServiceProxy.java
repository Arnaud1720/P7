package com.arnaud.front.blibliothequeFront.proxies;


import com.arnaud.back.blibliotheque.model.Book;
import com.arnaud.back.blibliotheque.model.Borrowing;
import com.arnaud.front.blibliothequeFront.modelFront.Accountfront;
import com.arnaud.front.blibliothequeFront.modelFront.Borrowingfront;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.arnaud.back.blibliotheque.constant.Constants.APP_ROOT;

@FeignClient(name = "microservice", url = "localhost:8080")

public interface MicroServiceProxy {

    @GetMapping(value = APP_ROOT+"/display/books/available",produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    List<Book> findBookByAvailableTrue( @RequestParam("available")boolean available);

    @PostMapping(value = APP_ROOT+"/utilisateur/save",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    Accountfront save(@RequestBody Accountfront accountfront);



    @PostMapping(value = APP_ROOT + "/borrowing/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Borrowingfront save(@RequestBody Borrowingfront borrowingfront);


    @GetMapping(value = APP_ROOT+"/display/books/bookList",produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    List<Book> findAll();

}
