package com.arnaud.front.blibliothequeFront.proxies;


import com.arnaud.front.blibliothequeFront.modelFront.Accountfront;
import com.arnaud.front.blibliothequeFront.modelFront.Loanfront;
import com.arnaud.front.blibliothequeFront.modelFront.auth.AuthenticationRequest;
import com.arnaud.front.blibliothequeFront.modelFront.auth.AuthenticationResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.arnaud.front.blibliothequeFront.configuration.constant.APP_ROOT;

@FeignClient(name = "microservice", url = "localhost:8001")
public interface MicroServiceProxy {



    @PostMapping(value = APP_ROOT + "/utilisateur/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Headers("Content-type:application/json")
    Accountfront save(@RequestBody Accountfront accountfront);


    @PostMapping(value = APP_ROOT + "/loan/{utilisateurid}/{exemplaryid}/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Headers("Content-type:application/json")
    Loanfront save(@RequestBody Loanfront loanfront, @PathVariable(name = "utilisateurid") Integer utilisateurid,
                   @PathVariable(name = "exemplaryid") Integer exemplaryid);


    @GetMapping(value = APP_ROOT + "/loan/{utilisateurid}/listloan", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Loanfront> findByAccountId(@PathVariable(name = "utilisateurid") Integer id);


    @PostMapping("/authenticate")
    ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request);



}