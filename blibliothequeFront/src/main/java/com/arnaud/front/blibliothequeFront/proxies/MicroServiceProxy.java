package com.arnaud.front.blibliothequeFront.proxies;



import com.arnaud.front.blibliothequeFront.modelFront.auth.AuthenticationResponse;
import com.arnaud.front.blibliothequeFront.modelFront.Accountfront;
import com.arnaud.front.blibliothequeFront.modelFront.auth.AuthenticationRequest;
import com.arnaud.front.blibliothequeFront.modelFront.Bookfront;
import com.arnaud.front.blibliothequeFront.modelFront.Borrowingfront;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.arnaud.front.blibliothequeFront.configuration.constant.APP_ROOT;

@FeignClient(name = "microservice", url = "localhost:8001")
public interface MicroServiceProxy {


    @GetMapping(value = APP_ROOT+"/display/books/available",produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    @RequestLine("GET/{available}")
    List<Bookfront> findBookByAvailableTrue(@RequestParam(value = "available",defaultValue = "true")boolean available);

    @PostMapping(value = APP_ROOT+"/utilisateur/save",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @Headers("Content-type:application/json")
    Accountfront save(@RequestBody Accountfront accountfront);



    @PostMapping(value = APP_ROOT + "/borrowing/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Headers("Content-type:application/json")
    Borrowingfront save(@RequestBody Borrowingfront borrowingfront);


    @GetMapping(value = APP_ROOT+"/display/books/bookList",produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    List<Bookfront> findAll();

    @PostMapping("/authenticate")
     ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request);

    @GetMapping(value = APP_ROOT + "/borrowing/{utilisateurid}/listborrowing", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Borrowingfront> findByAccountId(@PathVariable(name = "utilisateurid") Integer id);



    @GetMapping(value = APP_ROOT + "/{utilisateurid}/{borrowingid}", produces = MediaType.APPLICATION_JSON_VALUE)
    String addExtension(@PathVariable(name = "utilisateurid") int userid,
                        @PathVariable(name = "borrowingid") int borrowingid,@RequestParam(value = "available") boolean available);
}
